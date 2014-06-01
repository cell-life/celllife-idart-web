<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>iDART</title>

    <c:set var="url">${pageContext.request.requestURL}</c:set>
    <base href="${fn:substring(url, 0, fn:length(url) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}/" />

    <link href="resources/css/bootstrap-3.0.2.css" rel="stylesheet" media="screen">
    <link href="resources/css/bootstrap-theme-3.0.2.css" rel="stylesheet" media="screen">
    <link href="resources/css/application.css" rel="stylesheet">
</head>
<body>

<div class="container">

    <jsp:include page="../includes/header.jsp">
        <jsp:param name="dashboardClass" value="" />
    </jsp:include>
    
    
    <div class="main">
    
    <h3>
        <img src="resources/img/medicoicons/medkit.png" style="height: 32px; width: 32px; margin-top:-5px">
        <span>Administration</span>
    </h3>

        <div class="list-group" style="max-width: 400px;">
            <a href="ui/admin/registration" class="list-group-item">
                <h3><img src="resources/img/medicoicons/cross 1.png"
                         style="height: 32px; width: 32px; margin-top:-5px">
                    <span class="pull-right">Registration</span>
                </h3></a>
            <a href="ui/admin/eventerror" class="list-group-item">
                <h3><img src="resources/img/medicoicons/bandaid.png"
                         style="height: 32px; width: 32px; margin-top:-5px">
                    <span class="pull-right">Event Errors</span>
                </h3></a>
        </div>
    </div>

    <jsp:include page="../includes/footer.jsp"/>

</div>

<script src="resources/js/jquery-1.8.2.js" type="text/javascript"></script>
<script src="resources/js/bootstrap-3.0.2.js" type="text/javascript"></script>

</body>
</html>