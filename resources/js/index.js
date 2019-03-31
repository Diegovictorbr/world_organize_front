$(document).ready(() => {
    openSlideRef = $('#openSlideRef');
    closeSlideRef = $('#closeSlideRef');
    menu = $('#menu');
    content = $('#content');

    openSlideRef.click(() => {
        menu.css('width', '250px');
        content.css('margin-left', '250px');
        openSlideRef.hide();
    });

    closeSlideRef.click(() => {
        menu.css('width', '0');
        content.css('margin-left', '0');

        menu.on('webkitTransitionEnd', event => {
            openSlideRef.show();
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
});