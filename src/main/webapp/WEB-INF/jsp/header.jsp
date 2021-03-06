<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"
"http://www.w3.org/TR/html4/strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  
  <link rel="wadl" type="application/wadl" href="<c:url value="/static/wadl/sIMLE.wadl"/>">

  <link rel='stylesheet' type='text/css' media="screen" href='<c:url value="/static/styles/no-theme/jquery-ui-1.7.custom.css"/>'>
  <link rel='stylesheet' type='text/css' media="screen" href='<c:url value="/static/styles/simle.css"/>'>  
  
  <script type="text/javascript" src="<c:url value="/static/js/jquery-1.3.2.min.js"/>"></script>
  <script type="text/javascript" src="<c:url value="/static/js/jquery-ui-1.7.custom.min.js"/>"></script>
  <script type="text/javascript" src="<c:url value="/static/js/jquery.form.js"/>"></script>
  <script type="text/javascript" src="<c:url value="/static/js/jquery.dataTables.min.js"/>"></script>
  <script type="text/javascript" src="<c:url value="/static/js/jquery.tooltip.js"/>"></script>
  <script type="text/javascript" src="<c:url value="/static/js/simle.js"/>"></script>
  
  <title>sIMLE</title>	 
</head>

<body class="tundra spring">	

  <div id="wrap">
  
  	<div id="logo">
  		<img src="<c:url value="/static/images/simle-logo.png"/>" alt="sIMLE"/>
  	</div>
  
  	<div id="menu">
    	<%@ include file="/WEB-INF/jsp/menu.jsp" %>
    </div>
    
    <div id="remoteErrors" class="errors" style="display:none"></div>
    
    <div id="main">