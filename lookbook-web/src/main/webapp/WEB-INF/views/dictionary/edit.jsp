<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<script type="text/javascript" src="/resources/js/app/dictionary/DictionaryModel.js"></script>
<script type="text/javascript" src="/resources/js/app/dictionary/DictionaryTableView.js"></script>
<script type="text/javascript" src="/resources/js/app/dictionary/DictionaryEditPageView.js"></script>

<div id="dictionaryEditContainer" class="container">
    <div id="selectDictionary" class="btn-group">
        <a class="btn btn-large dropdown-toggle" data-toggle="dropdown"></a>
        <ul class="dropdown-menu"></ul>
    </div>
    <div id="dic-edit-body"></div>
</div>


