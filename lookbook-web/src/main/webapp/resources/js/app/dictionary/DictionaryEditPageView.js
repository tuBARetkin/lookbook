/**
 * User: NGorelov
 * Date: 04.09.12
 * Time: 17:46
 */

$(function(){
    window.DictionaryEditPageView = Backbone.View.extend({
        dicViewList: {},
        el: $('#dictionaryEditContainer'),
        currentDictionary: 'thing_part',
        classesList: window.dictionaryClassList,

        events: {
            'click #selectDictionary .dropdown-menu li' : 'dropdownItemHandler'
        },

        initialize: function(){
            _.bindAll(this);

            var me = this;
            this.classesList.fetch({
                success: function(data){
                   for(var i = 0; i < data.length; i++){
                        var name = data.at(i).get('name');
                        var title = data.at(i).get('title');

                        me.dicViewList[name] = {
                            view: new DictionaryTableView({
                                id: name + '-body',
                                title: title,
                                usageType: 'edit',
                                dicName: name
                            })
                        }
                    }

                    me.render();
                }
            });
        },
        
        render: function(){
            var dropdown = $(this.el).find('#selectDictionary');
            var menu = dropdown.find('.dropdown-menu');

            _.each(this.dicViewList, function(dicView){
                $('<li dicName="' + dicView.view.list.dicName + '"><a>' + dicView.view.title + '</a></li>').appendTo(menu);
                $(dicView.view.el).addClass('hidden').appendTo('#dic-edit-body');
            });

            this.changeDictionary('thing_part', true);
        },

        dropdownItemHandler: function(e){
            this.changeDictionary($(e.target).parents('li').attr('dicName'), false);
        },

        /**
         * Changes dictionary
         * @param dicName name of selected dictionary
         * @param skipEqualsCheck true to change dictionaries if they are equal
         */
        changeDictionary: function (dicName, skipEqualsCheck){
            if(_.isUndefined(skipEqualsCheck) || _.isNull(skipEqualsCheck) || !_.isBoolean(skipEqualsCheck)){
                skipEqualsCheck = true;
            }
            if(skipEqualsCheck || !_.isEqual(dicName, this.currentDictionary)){
                var dropdown = $(this.el).find('#selectDictionary .btn');
                dropdown.text(this.dicViewList[dicName].view.title + ' ');
                dropdown.append('<span class="caret"></span>');

                var view = this.dicViewList[dicName].view;
                $(view.el).removeClass('hidden');
                view.render();

                if(!_.isEqual(this.currentDictionary, dicName)){
                    this.getCurrentDictionaryElement().addClass('hidden');
                }
                this.currentDictionary = dicName;
            }
        },

        /**
         * @return jquery element of selected dictionary
         */
        getCurrentDictionaryElement: function(){
            return $(this.dicViewList[this.currentDictionary].view.el);
        }
    });

    window.dictionaryEditPageView = new DictionaryEditPageView();
});