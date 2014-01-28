<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<script type="text/javascript" src="/resources/js/app/dictionary/DictionaryModel.js"></script>
<script type="text/javascript" src="/resources/js/app/dictionary/DictionaryTableView.js"></script>
<script type="text/javascript" src="/resources/js/app/dictionary/DictionaryCombinerView.js"></script>
<script type="text/javascript" src="/resources/js/app/dictionary/DictionaryCombinePageView.js"></script>

<div id="dictionaryCombineContainer">
    <div id="combineSaveBlock" class="row-fluid">
        <div class="alertBox span7"></div>
        <div class="span5" id="combineMainButtons">
            <div class="form-inline pull-right">
                <div id="selectCombinerBox" class="btn-group">
                    <a class="btn btn-large dropdown-toggle" data-toggle="dropdown"></a>
                    <ul class="dropdown-menu"></ul>
                </div>
                <button name="saveChanges" class="btn btn-primary">Сохранить</button>
                <button name="revertChanges" class="btn">Отменить</button>
            </div>
        </div>
    </div>
    <hr/>
    <div id="combineTmpl"></div>
</div>