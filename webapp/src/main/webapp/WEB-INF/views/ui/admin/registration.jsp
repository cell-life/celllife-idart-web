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

    <jsp:include page="../../includes/header.jsp">
        <jsp:param name="dashboardClass" value="" />
    </jsp:include>

    <div class="main">
    
        <h3>
            <img src="resources/img/medicoicons/medkit.png" style="height: 32px; width: 32px; margin-top:-5px">
            <span><a class="a-bread" href="ui/admin">Administration</a></span>
            &gt;
            <img src="resources/img/medicoicons/cross 1.png" style="height: 32px; width: 32px; margin-top:-5px">
            <span>Registration</span>
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

        <h4>Create a User</h4>
        <p>Register a new clinic so that they can login to iDARTweb.</p>
        <form class="well" id="create-user" action="ui/admin/registration/user" method="post">
            <div class="form-group">
                <label for="username">Username</label>
                <input class="form-control" name="username" type="text" placeholder="Username" autofocus required>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input class="form-control" name="password" type="password" placeholder="Password" required>
            </div>
            <button class="btn btn-default" type="submit">Register</button>
        </form>
        
        <h4>Create an Organisation</h4>
        <p>If required, register a new legal entity. Check the Facility form (below) if you are unsure</p>
        <form class="well" id="create-organisation" action="ui/admin/registration/organisation" method="post">
            <div class="form-group">
                <label for="name">Name</label>
                <input class="form-control" name="name" type="text" placeholder="Name" autofocus required>
            </div>        
            <button class="btn btn-default" type="submit">Register</button>
        </form>
    
        <h4>Create a Facility</h4>
        <p>Register a Clinic, Pharmacy or other type of Facility.</p>
        <form class="well" id="create-facility" action="ui/admin/registration/facility" method="post">
            <div class="form-group">
                <label for="name">Name</label>
                <input class="form-control" name="name" type="text" placeholder="Name" autofocus required>
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <input class="form-control" name="description" type="text" placeholder="Description" autofocus>
            </div>
            <div class="form-group">
                <label for="name">PREHMIS identifier</label>
                <input class="form-control" name="prehmisId" type="text" placeholder="Name" autofocus required>
            </div>
            <div class="form-group">
                <label for="organisation">Organisation</label>
                <select class="form-control" name="organisation" required>
                    <c:forEach items="${organisations}" var="organisation">
                        <option value="${organisation.id}">${organisation.name}</option>
                    </c:forEach>
                </select>
                <span class="help-inline">The Organisation to which this Facility belongs</span>
            </div>  
            <button class="btn btn-default" type="submit">Register</button>
        </form>
    
        <h4>Create a System</h4>
        <p>Creates a system login - registers an iDART client that will connect to iDARTweb. Note: if clients share a database, they should also share a system login.</p>
        <form class="well" id="create-system" action="ui/admin/registration/system" method="post">
            <div class="form-group">
                <label for="applicationKey">Application Key</label>
                <input class="form-control" id="applicationKey" name="applicationKey" type="text" placeholder="Application Key" autofocus required>
                <span class="help-inline">Please copy this value as it is required for the system to authenticate</span>
            </div>
            <div class="form-group">
                <label for="facility">Facility</label>
                <select class="form-control" name="facility" required>
                    <c:forEach items="${facilities}" var="facility">
                        <option value="${facility.id}">${facility.name}</option>
                    </c:forEach>
                </select>
                <span class="help-inline">The Facility to which this System belongs</span>
            </div>
            <button class="btn btn-default" type="submit">Register</button>
        </form>
 
    </div>

    <hr>

    <jsp:include page="../../includes/footer.jsp"/>

</div>

<script src="resources/js/jquery-1.8.2.js" type="text/javascript"></script>
<script src="resources/js/bootstrap-3.0.2.js" type="text/javascript"></script>
<script language="javascript" type="text/javascript">
function randomString() {
	var chars = "0123456789ABCDEF";
	var string_length = 36;
	var randomString = '';
	for (var i = 0; i < string_length; i++) {
		if (i==8 || i==13 || i==17 || i==22) {
			randomString += "-";
		} else {
    		var rnum = Math.floor(Math.random() * chars.length);
    		randomString += chars.substring(rnum, rnum + 1);
		}
	}
	return randomString;
}
</script>
<script>
    $(document).ready(function () {
        var applicationKey = randomString();
        $('input[name="applicationKey"]').val(applicationKey);
    });
</script>

</body>
</html>