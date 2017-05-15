<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>President Web App</title>
<link rel="stylesheet" href="master.css">
<link href="https://fonts.googleapis.com/css?family=Roboto+Slab" rel="stylesheet">
</head>
<body>
<div id="wrap">
	<h2>The Presidents of the United States</h2>
	<div id="left_panel">
		<form action="getPresident.do" method="get">
			Enter term number: <input type="text" name="termNumber" /> 
			<input id="submitButton" type="submit" value="Submit" />
		</form>
	</div>

	<div id="middle_panel">
		<c:if test="${president == null}">
			<img src="https://www.govloop.com/blogs/6001-7000/6061-presidentialseal.png" alt="default image for president" />
		</c:if>
		<c:if test="${president != null}">
			<img src="${president.url}" alt="Image of president" />
			<ul>
				<li><strong>${president.firstName} ${president.lastName}</strong></li>
				<li>Term: ${president.termNumber}</li>
				<li>${president.startTerm} - ${president.endTerm}</li>
				<li>Presidential pet: ${president.pet}</li>
		</c:if>
	</div>

	<div id="right_panel">
			<form action="getPresident.do" method="get">
				<c:if test="${president.termNumber != 1 && president != null}">
					<!-- 	<form action="getPresident.do" method="get">
 -->

				<input type="hidden" name="term" value="${president.termNumber}" />
	<input type="submit" name="previous" value="Previous President" />
	<!-- </form> -->
	</c:if>
		<c:if test="${president.termNumber != 45}">
	<input type="hidden" name="term" value="${president.termNumber}" />
	<input type="submit" name="next" value="Next President" />
	</c:if>
				<select name="filterParty">
			<c:forEach var="filter" items="${filterList}">
				<option value="${filter}" <c:if test="${filterParty != null && filterParty == filter}">selected</c:if>>${filter}</option>
			</c:forEach>
		</select> 
	<input type="submit" value="Filter"/>
	</form>
	
	
</body>
</html>