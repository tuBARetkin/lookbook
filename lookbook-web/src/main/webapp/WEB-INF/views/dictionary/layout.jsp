<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:importAttribute/>
<tiles:useAttribute name="activeTab" ignore="true"/>
<div id="dic-header">
    <div class="navbar">
        <div class="navbar-inner">
            <ul class="nav">
                <li class="dic-edit <c:if test="${activeTab=='dic-edit'}">active</c:if>">
                    <a href="../dictionary/edit">Редактирование</a>
                </li>
                <li class="dic-combine <c:if test="${activeTab=='dic-combine'}">active</c:if>">
                    <a href="../dictionary/combine">Компоновка</a>
                </li>
            </ul>
        </div>
    </div>
</div>

