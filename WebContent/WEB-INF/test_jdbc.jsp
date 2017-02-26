<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Test JDBC</title>
</head>
<body>
<c:forEach items="${messages}" var="message" varStatus="boucle">
	<p>${boucle.count}. ${messages}</p>
</c:forEach>
</body>
</html>