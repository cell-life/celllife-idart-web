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
        <jsp:param name="dashboardClass" value="active" />
    </jsp:include>

    <div class="main">

        <div class="list-group" style="max-width: 400px;">
            <a href="ui" class="list-group-item">
                <h3><img src="resources/img/medicoicons/heart.png"
                         style="height: 32px; width: 32px; margin-top:-5px">
                    <span class="pull-right">Patients</span>
                </h3></a>
            <a href="ui" class="list-group-item">
                <h3><img src="resources/img/medicoicons/prescription.png"
                         style="height: 32px; width: 32px; margin-top:-5px">
                    <span class="pull-right">Prescriptions</span>
                </h3></a>
            <a href="ui" class="list-group-item">
                <h3><img src="resources/img/medicoicons/bottle.png"
                         style="height: 32px; width: 32px; margin-top:-5px">
                    <span class="pull-right">Dispensations</span>
                </h3></a>
            <a href="ui" class="list-group-item">
                <h3><img src="resources/img/medicoicons/sthetoscope.png"
                         style="height: 32px; width: 32px; margin-top:-5px">
                    <span class="pull-right">Practitioners</span>
                </h3></a>
            <a href="ui" class="list-group-item">
                <h3><img src="resources/img/medicoicons/hospital.png"
                         style="height: 32px; width: 32px; margin-top:-5px">
                    <span class="pull-right">Facilities</span>
                </h3></a>
            <a href="ui" class="list-group-item">
                <h3><img src="resources/img/medicoicons/syrup.png"
                         style="height: 32px; width: 32px; margin-top:-5px">
                    <span class="pull-right">Medications</span>
                </h3></a>
            <a href="ui/admin" class="list-group-item">
                <h3><img src="resources/img/medicoicons/medkit.png"
                         style="height: 32px; width: 32px; margin-top:-5px">
                    <span class="pull-right">Administration</span>
                </h3></a>
        </div>
    </div>
    
    <jsp:include page="../includes/footer.jsp"/>

</div>

<script src="resources/js/jquery.1.8.2.js" type="text/javascript"></script>
<script src="resources/js/bootstrap.3.0.2.js" type="text/javascript"></script>
<script>
    $(document).ready(function () {
    });
</script>

</body>
</html>