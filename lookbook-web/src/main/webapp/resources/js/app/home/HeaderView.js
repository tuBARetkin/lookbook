/**
 * User: NGorelov
 * Date: 01.10.12
 * Time: 18:31
 */
$(function(){
    window.HeaderView = Backbone.View.extend({
        el: $('#mainHeader'),

        initialize: function(){
            $.tmpl($(this.el).template(), {
                'flow.title' : window.messages.get('flow.title')
            });

        }
    });

    window.headerView = new HeaderView();
});
