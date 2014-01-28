/**
 * User: NGorelov
 * Date: 04.09.12
 * Time: 13:27
 */

$(function(){
    window.DictionaryData = Backbone.Model.extend({
        url: '/lookbook/dictionary/save/',

        defaults: {
            dicName: null,
            dataKey: null,
            ruValue: null,
            enValue: null,
            subData: null
        },

        initialize: function(model){
            _.bindAll(this);
            this.dicName = model.dicName;
            this.dataKey = model.dataKey;
            this.ruValue = model.ruValue;
            this.enValue = model.enValue;
            this.subData = model.subData;
            this.url = this.url + this.dicName;
        },

        validate: function(attrs){
            if(!_.isEmpty(attrs.enValue) && attrs.enValue.length > 100){
                return 'Максимальная длина значения 100';
            }
            if(!_.isEmpty(attrs.ruValue) && attrs.ruValue.length > 100){
                return 'Максимальная длина значения 100';
            }
            if(_.isEmpty(attrs.dataKey)){
                return 'Значение ключа не может быть пустым';
            }
            if(attrs.dataKey.length > 45){
                return 'Максимальная длина ключа 45';
            }
        }
    });

    window.DictionaryList = Backbone.Collection.extend({
        model: DictionaryData,
        dicName: '',
        combineValue: undefined,

        sortProperties:{
            field: '',
            order: 'asc'
        },

        initialize: function(models, config){
            _.bindAll(this);

            this.dicName = config.dicName;
            if(_.isString(config.url)){
                this.url = config.url
            }
            else{
                this.url = '/lookbook/dictionary/list/' + this.dicName;
            }
        },

        comparator: function(itemA, itemB){
            var props = this.sortProperties;

            if(!_.isEmpty(props['field']) && (_.isEqual(props['order'], 'asc') || _.isEqual(props['order'], 'desc'))){
                var valA = itemA.get(props['field']);
                var valB = itemB.get(props['field']);

                if(props['order'] == 'asc'){
                    if(valA > valB) {return 1;}
                    else if(valB > valA) {return -1;}
                    else {return 0;}
                }
                else if (props['order'] == 'desc'){
                    if(valA > valB) {return -1;}
                    else if(valB > valA) {return 1;}
                    else {return 0;}
                }
            };
        },

        setURL: function(url){
            if(_.isString(url)){
                this.url = url;
            }
        },

        /**
         * Set field to sort and sort order
         * @param field
         * @param order 'asc' or 'desc'
         */
        setSortProperties: function(field, order){
            this.sortProperties['field'] = field;
            this.sortProperties['order'] = order;
        },

        /**
         * Saves or updates all models in this list
         */
        saveAll: function(){
            var data = [];
            _.each(this.models, function(item){
                data.push(item.attributes);
            });
            $.ajax({
                type: 'POST',
                url: '/lookbook/dictionary/saveAll/' + this.dicName,
                contentType: "application/json; charset=UTF-8",
                data: JSON.stringify(data)
            });
        },

        /**
         * Returns dictionary name of models in this list
         */
        getDictionaryName: function(){
            return this.dicName;
        },

        /**
         * returns model form list, specified by dataKey. false if no item.
         * @param dataKey
         */
        getByDataKey: function(dataKey){
            var retItem = false;
            if(_.isString('dataKey')){
                _.each(this.models, function(item){
                    if(_.isEqual(item.get('dataKey'), dataKey)){
                        retItem =  item;
                    }
                }, this);
            }
            return retItem;
        }
    });

    window.DictionaryClass = Backbone.Model.extend({
        defaults: {
            name: null,
            title: null
        }
    });

    window.DictionaryClassList = Backbone.Collection.extend({
        url: '/lookbook/dictionary/getAllClasses',
        model: DictionaryClass
    });

    window.dictionaryClassList = new DictionaryClassList();
});
