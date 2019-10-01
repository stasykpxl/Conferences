<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c" %>

<h3 class="card-title text-center">List  conferences</h3>
<c:if test="${not empty conferences}">
	<table class="table table-bordered table-dark">
		<thead>
			<tr>
				<th>Conference</th>
				<th>Place</th>
				<th>Date</th>
				<th>Choose</th>
			</tr>
	    </thead>
	    <tbody>
			<c:forEach var="conf" items="${conferences}">
				<tr>
					<td id="idConf">${conf.id}</td>
					<td>
						<a href="JavaScript:getConf('${conf.id}')">${conf.title}</a> 
						<br>
						<span>${conf.descr}</span>
					</td>
					<td >${conf.place}</td>
					<td >${conf.date}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>
