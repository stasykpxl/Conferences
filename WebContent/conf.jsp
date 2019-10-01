<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Conference info</title>
		<script type="text/javascript" src='<c:url value="/js/main.js"/>'></script>
		<link rel="stylesheet" href='<c:url value="/css/main.css"/>'>
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	</head>
	<body style="background: #202020; color: #808080;">
	<!-- Сохраняем коференцию в скоупе -->
	<div class="alert alert-success">
		<c:set var="conf" value="${conferences[indexConf]}" scope="page"/>
		<h4 class="alert-heading">${conf.title}</h4>
		<p>Place: ${conf.place}</p>
		<p>Date: ${conf.date}</p>
		<hr>		
		<h3 class="card-title text-center">Conference program</h3>
		<table class="table table-bordered table-dark">
			<thead>
				<tr>
					<th>Time</th>
					<th>Event</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="event" items="${conf.events}">
					<tr>
						<td>${event.time}</td>
						<td>${event.title}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>	
		
		</div>
		<h4><a class="badge badge-secondary" href="<c:url value="/home.jsp"/>">Back</a></h4>
	</body>
</html>