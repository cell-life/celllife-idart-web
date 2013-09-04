define(['text!./menu.hbs'], function(template) {
    return {
        initialize: function() {
            this.html(template);
        }
    };
});
