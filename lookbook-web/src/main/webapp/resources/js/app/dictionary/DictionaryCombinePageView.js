/**
 * User: NGorelov
 */
$(function(){
    window.DictionaryCombinePageView = Backbone.View.extend({
        el: $('#dictionaryCombineContainer'),
        errorTemplate: templateManager.get('dictionary/StatusBlock'),
        currentCombiner: new Object(),
        combinerList: new Array(),
        classesList: window.dictionaryClassList,

        events: {
            'click .btn[name=saveChanges]': 'saveButtonHandler',
            'click .btn[name=revertChanges]': 'revertButtonHandler',
            'click #selectCombinerBox li' : 'chooseCombinerHandler'
        },

        initialize: function(){
            _.bindAll(this);

            this.combinerList.push(
                {
                    id: 'thingPart2ThingClass',
                    mainDic: 'thing_class',
                    subDic: 'thing_part',
                    title: 'Части одежды'
                },
                {
                    id: 'parameter2ThingClass',
                    mainDic: 'thing_class',
                    subDic: 'parameter',
                    title: 'Параметры - классы одежды'
                },
                {
                    id: 'optionClass2ThingClass',
                    mainDic: 'thing_class',
                    subDic: 'option_class',
                    title: 'Классы опций - классы одежды'
                },
                {
                    id: 'optionClass2ThingPart',
                    mainDic: 'thing_part',
                    subDic: 'option_class',
                    title: 'Классы опций - части одежды'
                },
                {
                    id: 'optionClass2ThingPart',
                    mainDic: 'option_class',
                    subDic: 'option',
                    title: 'Классы опций'
                }
            )

            var combinerBox = $(this.el).find('#selectCombinerBox .dropdown-menu');
            _.each(this.combinerList, function(item){
                $('<li combinerKey="' + item.id + '"><a>' + item.title + '</a></li>').appendTo(combinerBox);
            });

            var me = this;
            this.classesList.fetch({
                success: function(){
                    me.currentCombiner = new DictionaryCombainerView({
                        id: 'thingPart2ThingClass',
                        mainDic: 'thing_class',
                        subDic: 'thing_part'
                    });

                    var combinerButton =  $(me.el).find('#selectCombinerBox .btn');
                    combinerButton.text(me.combinerList[0].title + ' ');
                    combinerButton.append('<span class="caret"></span>');

                    me.render();
                }
            });
        },

        render: function(){
            $(this.el).find('#combineTmpl').append($(this.currentCombiner.el));
        },

        saveButtonHandler: function(){
            var me = this;

            this.currentCombiner.mainDicView.getSelectedMainDicModel().save({}, {
                success: function(model, response){
                    me.showNewMessage('Сохранение выполнено', 'success');
                },
                error: function(model, response){
                    me.showNewMessage(_.isString(response) ? response : response.statusText, 'error');
                }
            });
        },

        revertButtonHandler: function(){
            this.currentCombiner.fetchAndRender();
        },

        chooseCombinerHandler: function(e){
            var curComb = $(e.target).parents('li').attr('combinerKey');

            _.each(this.combinerList, function(item){
                if(_.isEqual(item.id, curComb)){
                    delete this.currentCombiner;
                    $(this.el).find('#combineTmpl').empty();

                    this.currentCombiner = new DictionaryCombainerView({
                        id: item.id,
                        mainDic: item.mainDic,
                        subDic: item.subDic
                    });

                    var combinerButton =  $(this.el).find('#selectCombinerBox .btn');
                    combinerButton.text(item.title + ' ');
                    combinerButton.append('<span class="caret"></span>');
                }
            }, this);

            this.render();
        },
        /**
        * Clears old error message and adds new
        * @param mess error message
        */
        showNewMessage: function(mess, status){
            var alertBox = $(this.el).find('.alertBox');
            if(alertBox){
                alertBox.empty();
                alertBox.append($.tmpl(this.errorTemplate, {message: mess, status: status}));
            }
        }
    });

    window.dictionaryCombinePageView = new DictionaryCombinePageView();
});