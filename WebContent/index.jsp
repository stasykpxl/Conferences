<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Home page</title>
		<script type="text/javascript" src='<c:url value="/js/main.js"/>'></script>	
		<link rel="stylesheet" href='<c:url value="/css/main.css"/>'>
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	</head>
	<body style="background: #202020; color: #808080;">
		<c:if test="${not empty user}">   
			<div style="float: right; margin-right: 50px;">		
				<h4>${user.login}</h4>			  
				<h5><a href="JavaScript:sendData('conf_by_user')">Account</a></h5>
				<h5><a href='<c:url value="/logout"/>'>LogOut</a></h5>
			</div>	 
		</c:if>		
		<c:if test="${empty user}">
			<div style="float: right; margin-right:110px;">				  
				<h5><a href='<c:url value="/login.jsp"/>'>LogIn</a></h5>
				<h5><a href='<c:url value="/regist.jsp"/>'>Registration</a></h5>
			</div>	 
		</c:if>		
		<table>
			<tr>
				<th><h5><a href="JavaScript:sendData('all')" style="padding: 5px;">All</a></h5></th>
				<th><h5><a href="JavaScript:sendData('today')" style="padding: 5px;">Today</a></h5></th>
				<th><h5><a href="JavaScript:sendData('tomorrow')" style="padding: 5px;">Tomorrow</a></h5></th>
				<th><h5><a href="JavaScript:sendData('soon')" style="padding: 5px;">Soon</a></h5></th>
				<th><h5><a href="JavaScript:sendData('past')" style="padding: 5px;">Past</a></h5></th>
			</tr>
		</table>
		<jsp:include page="/confList.jsp"/>
	</body>
</html>
