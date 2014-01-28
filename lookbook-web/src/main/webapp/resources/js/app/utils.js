/**
 * User: NGorelov
 * Date: 04.09.12
 * Time: 16:11
 */
$(function(){
    window.templateManager = {

        get: function(id){
            var tmpl;
            var me = this;
            $.ajax({
                url: "/resources/tpl/" + id + ".html",
                async: false,

                success: function(template){
                    tmpl = template;
                }
            });

            return $(tmpl).template();
        }
    };

    window.messages = {
        lang: 'RU',

        get: function(key){
            return this.dic[key][this.lang]
        },

        dic : {
            'flow.title' : {
                RU: 'Лента',
                EN: 'Flow'
            }
        }
    };
});

