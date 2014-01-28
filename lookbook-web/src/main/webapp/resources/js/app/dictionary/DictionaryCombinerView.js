/**
 * User: tub
 * Date: 18.09.12
 * Time: 2:23
 */
$(function(){
    window.DictionaryCombainerView = Backbone.View.extend({

        containerTemplate: templateManager.get('dictionary/CombinerContainer'),

        mainDicView: new Object(),
        subDicView: new Object(),

        events:{
            'click .btn[name=toSub]': 'moveToSub',
            'click .btn[name=toMain]': 'moveToMain'
        },

        initialize: function(config){
            _.bindAll(this);

            var mainDicTitle;
            var subDicTitle;
            _.each(window.dictionaryClassList.models, function(item){
                if(_.isEqual(item.get('name'), config.mainDic)){
                    mainDicTitle = item.get('title');
                    return
                }
                else if(_.isEqual(item.get('name'), config.subDic)){
                    subDicTitle = item.get('title');
                    return;
                }
            }, this);

            this.mainDicView = new DictionaryTableView({
                id: config.mainDic + '-body',
                usageType: 'combine',
                title: mainDicTitle,
                dicName: config.mainDic
            });

            this.subDicView = new DictionaryTableView({
                id: config.subDic + '-body',
                usageType: 'view',
                title: subDicTitle,
                dicName: config.subDic
            });

            this.setElement($('<div id="' + config.id + '"></div>'));
            $(this.el).append($.tmpl(this.containerTemplate));

            $(this.el).find('#main-dic-body').append($(this.mainDicView.el));
            $(this.el).find('#sub-dic-body').append($(this.subDicView.el));

            this.mainDicView.bind('changeMainDic', this.changeMainDicHandler);
        },

        render: function(){
            this.subDicView.render();
            this.mainDicView.render();
        },

        fetchAndRender: function(){
            var me = this;
            this.subDicView.list.reset([], {silent: true});
            this.subDicView.list.fetch({
                success: function(){
                    me.subDicView.render();
                }
            });

            this.mainDicView.list.reset([], {silent: true});
            this.mainDicView.list.fetch({
                success: function(){
                    me.mainDicView.render();
                }
            });
        },

        changeMainDicHandler: function(e){
            var list = this.subDicView.list;
            var me = this;

            list.setURL('/lookbook/dictionary/listDisabled/' + e.selDic.get('dataKey') + '/' + this.subDicView.list.getDictionaryName());
            this.fetchAndRender();
        },

        moveToMain: function(rows){
            var selModels = this.subDicView.getSelectedModels();

            _.each(selModels, function(item){
                this.mainDicView.getSelectedMainDicModel().get('subData').push(item.toJSON());
            }, this);
            this.subDicView.list.remove(selModels);

            this.render();
        },

        moveToSub: function(rows){
            var selModels = this.mainDicView.getSelectedModels();
            this.subDicView.list.add(selModels);

            var selIds = this.mainDicView.getSelectedIds();
            var subModels = this.mainDicView.getSelectedMainDicModel().get('subData');
            _.each(selIds, function(id){
                subModels.splice(id, 1);
            }, this);

            this.render();
        }
    });
});
