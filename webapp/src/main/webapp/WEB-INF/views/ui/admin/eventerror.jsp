<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

    <jsp:include page="../../includes/header.jsp">
        <jsp:param name="dashboardClass" value="" />
    </jsp:include>

    <div class="main">
    
        <h3>
            <img src="resources/img/medicoicons/medkit.png" style="height: 32px; width: 32px; margin-top:-5px">
            <span><a class="a-bread" href="ui/admin">Administration</a></span>
            &gt;
            <img src="resources/img/medicoicons/bandaid.png" style="height: 32px; width: 32px; margin-top:-5px">
            <span>Events monitor</span>
        </h3>
        
        <c:if test="${not empty regMessage}">
            <div class="alert alert-success">  
              <a class="close" data-dismiss="alert">×</a>  
              ${regMessage}  
            </div>
        </c:if>

        <c:if test="${not empty errorMessage}">
            <div class="alert alert-error">  
              <a class="close" data-dismiss="alert">×</a>  
              ${errorMessage}
            </div>
        </c:if>

        <p>This table contains all the events that have failed. (For example, a PREHMIS save prescription could not be saved). You can retry them below.</p>
        <form>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th></th>
                            <th>Date</th>
                            <th>Event type</th>
                            <th>UUID</th>
                            <th>Retries</th>
                            <th>Error Message</th>
                        </tr>
                    </thead>
                    <tbody>
                        <jsp:useBean id="dateValue" class="java.util.Date" />
                        <c:forEach items="${eventErrors}" var="eventError">
                            <tr>
                                <td><input type="checkbox" name="pk" value="${eventError.pk}"></td>
                                <jsp:setProperty name="dateValue" property="time" value="${eventError.datetime}" />
                                <td><fmt:formatDate type="both" dateStyle="medium" timeStyle="medium" value="${dateValue}" /></td>
                                <td>${eventError.eventType}</td>
                                <td>${eventError.eventUuid}</td>
                                <td>${eventError.retryCount}</td>
                                <td>${eventError.errorMessage}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <button id="reprocess-btn" class="btn btn-default" type="submit">Reprocess</button>
                <button id="delete-btn" class="btn btn-default" type="submit">Delete</button>
        </form>
    </div>

    <jsp:include page="../../includes/footer.jsp"/>

</div>

<script src="resources/js/jquery-1.8.2.js" type="text/javascript"></script>
<script src="resources/js/bootstrap-3.0.2.js" type="text/javascript"></script>
<script>
	// if the reprocess button is clicked
    $("#reprocess-btn").click(function () {    	
    	// go through all the ticked checkboxes
    	$('input[type=checkbox]').each(function () {
            if (this.checked) {
            	// call reprocess REST service
            	$.get("eventerrors/"+$(this).val()+"/reprocess"); 
            }
	     });
    });
	// if the delete button is clicked
    $("#delete-btn").click(function () {    	
    	// go through all the ticked checkboxes
    	$('input[type=checkbox]').each(function () {
            if (this.checked) {
            	// call delete REST service
            	$.ajax({
                    url: "eventerrors/"+$(this).val(),
                    type: "DELETE"
                })
            }
	     });
    });
</script>

</body>
</html>