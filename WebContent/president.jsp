<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>President Web App</title>
  <link rel="stylesheet" href="master.css">
</head>
<body>
	<h2>The Presidents of the United States</h2>
	<form action="getPresident.do" method="get">
	Enter term number: <input type="text" name="termNumber"/>
	<input type="submit" value="Submit"/>
	</form>
	<hr>
	

	
	<c:if test="${president != null}">
		<img src="${president.url}" alt="Image of president"/>
		<ul>
		<li>Name: ${president.firstName} ${president.lastName}</li>
		<li>Term: ${president.termNumber}</li>
		<li>${president.startTerm} - ${president.endTerm}</li>
		<li>Presidential pet: ${president.pet}</li>
		</c:if>
		
	<c:if test="${president.termNumber != 45}">
	<form action="getPresident.do" method="get">
		<c:if test="${president.termNumber != 1}">
				<!-- 	<form action="getPresident.do" method="get">
 -->
				<input type="hidden" name="term" value="${president.termNumber}" />
	<input type="submit" name="previous" value="Previous President" />
	<!-- </form> -->
	</c:if>
	<input type="hidden" name="term" value="${president.termNumber}" />
	<input type="submit" name="next" value="Next President" />
				<select name="filterParty">
			<c:forEach var="filter" items="${filterList}">
				<option value="${filter}" <c:if test="${filterParty != null && filterParty == filter}">selected</c:if>>${filter}</option>
			</c:forEach>
		</select> 
	<input type="submit" value="Filter"/>
	</form>
	</c:if>
	
<!-- 	<form action="presFilter.do" method="get">

	</form> -->
</body>
</html>