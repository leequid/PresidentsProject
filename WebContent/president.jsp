<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>President Web App</title>
</head>
<body>
	<h2>The Presidents of the United States</h2>
	<form action="getPresident.do" method="get">
	<input type="text" name="termNumber"/>
	<input type="submit" value="Submit"/>
	</form>
	<hr>
	
	<button type="submit" name="previous">Previous President</button> 
	<c:if test="${president != null}">
		${president.info}
		</c:if>
	<button type="submit" name="next">Next President</button> 
</body>
</html>