/**
 * User: NGorelov
 * Date: 07.09.12
 * Time: 15:23
 * supports two types of work: 'view', 'combine' and 'edit'
 */
$(function(){
    window.DictionaryTableView = Backbone.View.extend({

        rowTemplate: templateManager.get('dictionary/TableRow'),
        errorTemplate: templateManager.get('dictionary/StatusBlock'),
        containerTemplate: templateManager.get('dictionary/EditContainer'),

        list: new Object(),
        usageType: 'view',
        dicName: new String(),

        events: {
            'click .edit' : 'editButtonHandler',
            'click .cancel': 'cancelButtonHandler',
            'click .save': 'saveButtonHandler',
            'click .filteredHeader': 'headerClickHandler',
            'click input[type=checkbox]': 'checkboxHandler',
            'click #selectMainDictionary li' : 'chooseMainDicHandler'
        },

        initialize: function(config){
            if(!_.isString(config.title)){
                console.error('DictionaryTableView: title is not string');
                return;
            }
            else if(!_.isString(config.dicName)){
                console.error('DictionaryTableView: dicName is not string');
                return;
            }

            _.bindAll(this);

            this.list = new DictionaryList([], {dicName: config.dicName});
            this.title = config.title;
            this.dicName = this.list.getDictionaryName();
            if(_.isEqual(config.usageType, 'combine') || _.isEqual(config.usageType, 'edit')){
                this.usageType = config.usageType;
            }

            this.setElement($('<div id="' + config.id + '"></div>'));
            $(this.el).append($.tmpl(this.containerTemplate, {
                title: this.title,
                usageType: this.usageType
            }));

            var me = this;
            this.list.fetch({
                success: function(data){
                        me.render();
                }
            });
        },

        render: function(){
            var elBody = $(this.el).find('tbody');
            elBody.empty();

            if(!_.isEqual(this.usageType, 'combine')){
                for(var i = 0; i < this.list.length; i++){
                    var item = this.list.at(i).toJSON();
                    var rowElem = $.tmpl(this.rowTemplate, {
                        id: i + 1,
                        ruValue: item.ruValue,
                        enValue: item.enValue,
                        dataKey: item.dataKey,
                        usageType: this.usageType
                    });
                    elBody.append(rowElem);
                }
            }
            else{
                var menu = $(this.el).find('#selectMainDictionary .dropdown-menu');

                    if(!this.getSelectedMainDicModel()){
                        _.each(this.list.models, function(item){
                            $('<li dataKey="' + item.get('dataKey') + '"><a>' + item.get('ruValue') + '</a></li>').appendTo(menu);
                        });

                        var firstItem = this.list.at(0);
                        if(_.isObject(firstItem)){
                            this.setSelectedMainDicModel(firstItem.get('dataKey'));
                        }
                    }
                var subData = this.getSelectedMainDicModel();
                if(_.isObject(subData)){
                    subData = subData.get('subData');

                    if(subData.length > 0){
                        for(var i = 0; i < subData.length; i++){
                            var item = subData[i];
                            var rowElem = $.tmpl(this.rowTemplate, {
                                id: i + 1,
                                ruValue: item.ruValue,
                                enValue: item.enValue,
                                dataKey: item.dataKey,
                                usageType: this.usageType
                            });
                            elBody.append(rowElem);
                        }
                    }
                }
            }

            //empty row for new model
            if(_.isEqual(this.usageType, 'edit')){
                elBody.append($.tmpl(this.rowTemplate, {usageType: this.usageType}));
            }

            $(elBody + 'tr').bind('mouseover', function(){
                $(this).addClass('mouseOnRow');
            });
            $(elBody + 'tr').bind('mouseout', function(){
                $(this).removeClass('mouseOnRow');
            });
        },

        editButtonHandler: function(e){
            var selectedModels = this.getSelectedModels();
            var selectedRow = $(e.target).parents('tr');
            var table = selectedRow.parents('table');
            var allRows = $(this.el).find('.rowEdited,.rowError');
            _.each(allRows, function(item){
                this.cancelEdit($(item));
            }, this);
            this.startEdit(selectedRow);
        },

        saveButtonHandler: function(e){
            var thingPart = this.createAndFillNewModel();
            var row = this.getEditedRow();

            var me = this;
            thingPart.save({}, {
                success: function(model, response){
                    //adds new id for correctly saved row
                    row.find('td[name=id]').text(me.list.length);
                    me.list.add(model, {silent: true});
                    me.list.sort();
                    me.clearError();
                    me.render();
                },
                error: function(model, response){
                    me.showNewError(_.isString(response) ? response : response.statusText);
                    row.toggleClass('rowEdited rowError');
                }
            });
        },

        cancelButtonHandler: function(e){
            this.cancelEdit($(e.target).parents('tr'));
        },

        checkboxHandler: function(e){
            var checkbox = $(e.target);
            if(checkbox.is(':checked')){
                checkbox.parents('tr').addClass('rowEdited');
            }
            else{
                checkbox.parents('tr').removeClass('rowEdited');
            }
        },

        chooseMainDicHandler: function(e){
            this.setSelectedMainDicModel($(e.target).parents('li').attr('dataKey'));
            this.render();
        },

        cancelEdit: function(row){
            var cancelButton = row.find('.cancel');
            cancelButton.attr('disabled', 'true');

            var saveButton = row.find('.save');

            saveButton.removeClass('save').addClass('edit');
            saveButton.find('i').removeClass('icon-ok').addClass('icon-pencil');

            var input = row.find('input');
            input.attr('disabled', 'true');
            var rowItem = this.list.at(row.find('td[name=id]').text() - 1);
            if(!_.isEmpty(rowItem)){
                $(input[0]).val(rowItem.get('ruValue'));
                $(input[1]).val(rowItem.get('enValue'));
            }
            else{
                _.each(input, function(item){
                    $(item).val('');
                });
            }

            if(row.hasClass('rowError')){
                $(this.el).find('.alert').alert('close');
            }

            row.removeClass('rowEdited rowError');
        },

        startEdit: function(row){
            var editButton = row.find('.edit');
            editButton.removeClass('edit').addClass('save');
            editButton.find('i').removeClass('icon-pencil').addClass('icon-ok');

            var input = row.find('input');
            input.removeAttr('disabled');

            var cancelButton = row.find('.cancel');
            cancelButton.removeAttr('disabled');

            row.addClass('rowEdited');
        },

        headerClickHandler: function(e){
            var icon = $(e.target);
            if(icon.is('th')){
                icon = icon.find('i');
            }
            var fieldName = icon.parents('th').attr('name');

            if(fieldName){
                if(icon.hasClass('icon-chevron-up')){
                    this.setSortedFieldByName(fieldName, 'desc');
                }
                else{
                    this.setSortedFieldByName(fieldName, 'asc');
                }
            }

            this.list.sort();
            this.render();
        },

        /**
        * Clears old error message and adds new
        * @param mess error message
        */
        showNewError: function(mess){
            var alertBox = $(this.el).find('.alertBox');
            if(alertBox){
                alertBox.empty();
                alertBox.append($.tmpl(this.errorTemplate, {status:'error', message: mess}));
            }
        },

        /**
         * Clears error message
         */
        clearError: function(){
            var alertBox = $(this.el).find('.alertBox');
            if(alertBox){
                alertBox.empty();
            }
        },

        /**
         *
         * @return DictionaryModel item full of data and that is not in model list
         */
        createAndFillNewModel: function(){
            var model = this.getEditedModel();
            var row = this.getEditedRow();

            var ruValue = row.find('input[name=ruValue]').val().trim();
            var enValue = row.find('input[name=enValue]').val().trim();

            if(!model){
                var dataKey = row.find('td[name=dataKey]').find('input').val().trim();
                model = new DictionaryData({
                    dicName: this.dicName,
                    dataKey: dataKey,
                    ruValue: ruValue,
                    enValue: enValue
                });
            }
            else{
                model.set({ruValue: ruValue}, {silent: true});
                model.set({enValue: enValue}, {silent: true});
            }

            return model;
        },

        /**
         * @return editing DOM <tr> element
         */
        getEditedRow: function(){
            var row = $(this.el).find('.rowEdited,.rowError');
            if(row.html()){
                return row;
            };
        },

        /**
         * @return editing dictionary model
         */
        getEditedModel: function(){
            if(this.getEditedRow()){
                var index = this.getEditedRow().find('td[name=id]').text() - 1;
                if(_.isNumber(index)){
                    return this.list.at(index);
                }
            }
        },

        /**
         * @return all models assigned to row, that selected by chekbox
         */
        getSelectedModels: function(){
            var selRows = $(this.el).find('input:checked').parents('td');
            var selModels = [];
            _.each(selRows, function(item){
                var id = $(item).text() - 1;
                if(!_.isEqual(this.usageType, 'combine')){
                    selModels.push(this.list.at(id));
                }
                else{
                    selModels.push(this.getSelectedMainDicModel().get('subData')[id]);
                }
            }, this);
            return selModels;
        },

        /**
         * @return all model ids that selected by checkbox
         */
        getSelectedIds: function(){
            var selRows = $(this.el).find('input:checked').parents('td');
            var selModels = [];
            _.each(selRows, function(item){
                selModels.push($(item).text() - 1);
            }, this);
            return selModels;
        },

        /**
         * @return selected main model if usageType is 'combine'
         */
        getSelectedMainDicModel: function(){
            if(_.isEqual(this.usageType, 'combine')){
                var dropdown = $(this.el).find('#selectMainDictionary .btn');
                return this.list.getByDataKey(dropdown.attr('selDic'));
            }
        },

        /**
         * selects main model if usageType is 'combine'
         * @param dataKey
         */
        setSelectedMainDicModel: function(dataKey){
            if(_.isEqual(this.usageType, 'combine') && _.isString(dataKey)){
                var dropdown = $(this.el).find('#selectMainDictionary .btn');

                dropdown.text(this.list.getByDataKey(dataKey).get('ruValue') + ' ');
                dropdown.append('<span class="caret"></span>');
                dropdown.attr('selDic', dataKey);

                this.trigger('changeMainDic', {selDic: this.list.getByDataKey(dataKey)})
            }
        },

        /**
         * Removes sort on all columns
         */
        clearSort: function(){
            $(this.el).find('.filteredHeader i').removeClass();
        },

        /**
         * Marked column sorted by model field name
         * @param name name of the field
         * @param order 'desc' or 'asc
         */
        setSortedFieldByName: function(name, order){
            if(name && order){
                this.clearSort();
                var column = $(this.el).find('th[name=' + name + ']');
                if(column.is('th')){
                    if(_.isEqual(order, "asc")){
                        column.find('i').addClass('icon-chevron-up')
                        this.list.setSortProperties(name, 'asc');
                    }
                    else if(_.isEqual(order, "desc")){
                        column.find('i').addClass('icon-chevron-down');
                        this.list.setSortProperties(name, 'desc');
                    }
                }
            }
        }
    });
});
