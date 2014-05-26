<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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

<div class="row">
  <div class="center-block text-center" style="width:326px">
        <img src="resources/img/idart_logo.png" width="326" height="326" alt="iDART">
    <h1>iDART</h1>
    <h2>An easy to use and robust Pharmacy Management System</h2>
    <p><small><a href="http://www.cell-life.org/systems/dispense-idart/">Find out more</a>.</small></p>
    <p></p>
    <p>
      <a class="btn btn-primary" href="ui/dashboard">Dashboard</a></li>
          <a  class="btn btn-default" href="j_spring_cas_security_logout">Logout</a>
        </p>
    <a href="http://www.cell-life.org/"><img src="resources/img/celllife_logo.png" width="209" height="94" alt="Cell-Life"></a>
  </div>
</div>


</body>
</html>