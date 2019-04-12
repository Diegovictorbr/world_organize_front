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

    var map = new ol.Map({
        target: 'mapContainer',
        controls: [],
        layers: [
            new ol.layer.Tile({
                source: new ol.source.OSM()
            })
        ],
        view: new ol.View({
            center: ol.proj.fromLonLat([-43.287962, -22.881046]),
            zoom: 12
        })
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

   
    
    <!-- <ul>
            <li><a href="#">ViolÃªncia</a></li>
            <li><a href="#">Assalto</a></li>
            <li><a href="#">Tiroteio</a></li>
        </ul> -->

    // Pegar tweet pelo id de uma localidade
    // https://7lxc3x2ta7.execute-api.us-east-1.amazonaws.com/Prod/gettweetbylocate?id=3

    // Localidades da aplicação
    // https://7lxc3x2ta7.execute-api.us-east-1.amazonaws.com/Prod/listlocate

    // Pegar tweet pelo id de uma categoria
    // https://7lxc3x2ta7.execute-api.us-east-1.amazonaws.com/Prod/gettweetbycategory?id=4


});