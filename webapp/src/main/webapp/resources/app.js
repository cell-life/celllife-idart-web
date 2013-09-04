require(['bower_components/aura/lib/aura'], function(Aura) {
    Aura()
        .use('extensions/aura-menu-extension')
        .start({ components: 'body' }).then(function() {
            console.warn('Aura started...');
        });
});
