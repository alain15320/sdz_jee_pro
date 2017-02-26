<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Test JDBC</title>
<link type="text/css" rel="stylesheet" href="<c:url value="/inc/form.css"/>" />
</head>
<body>
<h1>Test JDBC</h1>
<c:forEach items="${messages}" var="message" varStatus="boucle">
	<p>${boucle.count}. ${message}</p>
</c:forEach>
</body>
</html>

