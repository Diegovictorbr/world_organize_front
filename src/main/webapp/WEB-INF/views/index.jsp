<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<tags:pageTemplate titulo="World Organize">
    <nav id="menu" style="background: url('resources/images/bg1.png')">
        <a href="#" id="closeSlideRef">
            <i class="fas fa-times"></i>
        </a>

        <div style="width: 100%; height: 100; background: url('resources/images/bg1.png')">
            <div id="header" class="text-center">
                <div>
                    <img class="rounded-circle" src="resources/images/profile.jpg" alt="User picture"
                         style="width: 150px; height: auto; border: 4px solid dimgray">
                    <br>
                    <h3 style="margin-top: 5%;color: dimgray;font-weight: bolder">World Organize</h3>
                    <hr style="border: none; height: 1px; color: dimgray; background-color: dimgray">
                </div>
            </div>

            <div id='cssmenu'>
                <ul>
                    <li><a href='#'>Home</a></li>

                    <li class='active has-sub'><a href='#'>Categorias</a>
                        <ul id="categories">
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div id="content">
        <input id="filterBtn" type="image" src="resources/images/menu.png" />
        <div id="mapContainer"></div>
    </div>

</tags:pageTemplate>

<script>
    $(document).ready(() => {
        var filterBtn = $('#filterBtn');
        var closeSlideRef = $('#closeSlideRef');
        var menu = $('#menu');
        var content = $('#content');
        filterBtn.click(() => {
            menu.css('width', '250px');
            content.css('margin-left', '250px');
            filterBtn.hide();
        });
        closeSlideRef.click(() => {
            menu.css('width', '0');
            content.css('margin-left', '0');
            menu.on('webkitTransitionEnd', event => {
                filterBtn.show();
                menu.off('webkitTransitionEnd');
            });
        });

        map = new ol.Map({
            target: 'mapContainer',
            controls: [],
            layers: [
                new ol.layer.Tile({
                    source: new ol.source.XYZ({
                        url: 'http://{1-4}.basemaps.cartocdn.com/light_all/{z}/{x}/{y}.png'
                    })
                })
            ],
            view: new ol.View({
                center: ol.proj.fromLonLat([-43.287962, -22.881046]),
                zoom: 10
            })
        });

        vectorLayer = new ol.layer.Vector({
            source: new ol.source.Vector({})
        });

        map.addLayer(vectorLayer);

        map.on('pointermove', function (event) {
            var aux = false;
            map.forEachFeatureAtPixel(event.pixel, function (feature, layer) {
                aux = true;
                map.getOverlays().clear();

                var overlayElement = document.createElement('div');
                overlayElement.innerHTML = feature.get('bairro');

                var overlay = new ol.Overlay({
                    element: overlayElement,
                    positioning: 'center'
                });

                overlay.setPosition(event.coordinate);
                map.addOverlay(overlay);
            });
            if (!aux)
                map.getOverlays().clear();
        });

        map.on("click", function (e) {
            map.forEachFeatureAtPixel(e.pixel, function (feature, layer) {
                map.getView().animate({
                    zoom: 16,
                    center: feature.getGeometry().getCoordinates(),
                    duration: 2000
                });
            });
        });

        var cssmenu = $('#cssmenu > ul');
        menu.find('.has-sub > ul').hide();
        cssmenu.on('click', function (event) {
            event.preventDefault();
            var targetParent = $(event.target).parent();
            if (targetParent.hasClass('has-sub')) {
                targetParent.toggleClass('active');
                targetParent.children('ul').slideToggle(250);
            }
        });

        $.ajax({
            url: '${s:mvcUrl('getCategorias').build()}',
            dataType: 'json',
            success: function (response) {
                response.forEach(categoria => {
                    var li = $('<li>');
                    var a = $("<a href='#'>");
                    a.html(categoria.name);
                    a.on('click', function (event) {
                        vectorLayer.getSource().clear();

                        $.ajax({
                            url: '${s:mvcUrl('getInfoByCateg').arg(0, categoria.id).build()}=' + categoria.id,
                            dataType: 'json',
                            success: function (informacoes) {
                                var bairrosArray = [];
                                informacoes.forEach(info => {
                                    bairrosArray.push({
                                        cidade: info.cidade,
                                        bairro: info.bairro,
                                        geomBairro: info.geom_bairro,
                                        geomCidade: info.geom_cidade,
                                        count: 0
                                    });
                                });
                                function removeDuplicates(originalArray, prop) {
                                    var newArray = [];
                                    var lookupObject = {};

                                    for (var i in originalArray)
                                        lookupObject[originalArray[i][prop]] = originalArray[i];

                                    for (i in lookupObject)
                                        newArray.push(lookupObject[i]);

                                    return newArray;
                                }

                                bairrosArray = removeDuplicates(bairrosArray, 'geomBairro');
                                bairrosArray.forEach(bairro => bairro.count = informacoes.filter(information => information.bairro == bairro.bairro).length);
                                var wktReader = new ol.format.WKT();
                                var vectorSource = vectorLayer.getSource();


                                bairrosArray.forEach(bairro => {
                                    var bairroPointFeature = wktReader.readFeature(bairro.geomBairro, {
                                        dataProjection: 'EPSG:4326',
                                        featureProjection: 'EPSG:3857'
                                    });

                                    bairroPointFeature.setStyle(new ol.style.Style({
                                        fill: new ol.style.Fill({
                                            color: 'rgba(255, 0, 0, 1)'
                                        }),
                                        stroke: new ol.style.Stroke({
                                            color: 'rgba(255, 0, 0, 1)',
                                            width: 2
                                        }),
                                        image: new ol.style.Circle({
                                            // O raio é proporcional à quantidade de informações na categoria
                                            radius: bairro.count / 10,
                                            fill: new ol.style.Fill({color: 'rgba(255, 0, 0, 1)'}),
                                            stroke: new ol.style.Stroke({
                                                color: 'rgba(255, 0, 0, 1)',
                                                width: 2
                                            })
                                        })
                                    }));

                                    vectorSource.addFeature(bairroPointFeature);
                                    bairroPointFeature.set('bairro', bairro.bairro);
                                });

                                map.getView().fit(vectorSource.getExtent(), {duration: 500, maxZoom: 16});
                            }
                        });
                    });
                    li.append(a);
                    $('#categories').append(li);
                });
            }
        });
    }
    );
</script>