<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:importAttribute/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script type="text/javascript" src="/resources/js/libs/jquery-1.8.0.js"></script>
    <script type="text/javascript" src="/resources/js/libs/jquery.tmpl.js"></script>
    <script type="text/javascript" src="/resources/js/libs/underscore.js"></script>
    <script type="text/javascript" src="/resources/js/libs/backbone.js"></script>
    <script type="text/javascript" src="/resources/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript" src="/resources/js/app/utils.js"></script>
    <link href="/resources/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="/resources/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
    <link href="/resources/css/base-styles.css" rel="stylesheet">
    <title><tiles:insertAttribute name="title"/></title>
</head>
<body>
<tiles:insertAttribute name="navbar">
    <tiles:putAttribute name="activeTab" value="${activeTab}" />
</tiles:insertAttribute>
<tiles:insertAttribute name="page"/>
</body>
</html>