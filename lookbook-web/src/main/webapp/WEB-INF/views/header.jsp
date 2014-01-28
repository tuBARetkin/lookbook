<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<script type="text/javascript" src="/resources/js/app/home/HeaderView.js"></script>

<div id="mainHeader" class="navbar">
    <div class="navbar-inner">
        <ul class="nav">
            <li class="active"><a href="">{{flow.title}}</a></li>
            <li><a href="/lookbook/dictionary/edit">Справочник</a></li>
        </ul>
        <div class="form-inline pull-right">
            <button name="openAuthWindow" class="btn" data-toggle="modal" data-target="#authWindow">Логин</button>
        </div>
    </div>
</div>
<div class="modal hide" id="authWindow" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h3>Авторизация/регистрация</h3>
    </div>
    <div class="modal-body">
        <form ac>
            <label>Логин</label>
            <input type="text" placeholder="Логин...">
            <label>Пароль</label>
            <input type="password">
        </form>
    </div>
    <div class="modal-footer">
        <button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
        <button class="btn btn-primary">Регистрация</button>
        <button class="btn btn-primary">Авторизация</button>
    </div>
</div>