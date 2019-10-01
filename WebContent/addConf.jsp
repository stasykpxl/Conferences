<%@page import="by.spartakzatawit.constants.Constants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>New conference</title>
		<script type="text/javascript" src='<c:url value="/js/main.js"/>'></script>	
		<link rel="stylesheet" href='<c:url value="/css/main.css"/>'>
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	</head>
	<body style="background: #202020; color: #808080;">
		<div class="container">
		    <div class="row">
		      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
		        <div style="background: #DCDCDC;" class="card card-signin my-5">
		          <div class="card-body">
		            <h5 class="card-title text-center">Conference</h5>
		            <form class="form-signin" id="addConf" method="post" action='<c:url value="addConf"/>'>
			              <div class="form-label-group">
			              	<input class="form-control" type="text" name="<%= Constants.TITLE %>" placeholder="name" autofocus>            
			              </div>
			              <br>
			              <div class="form-label-group">
			              	  <input class="form-control" type="text" name="<%= Constants.DESCR %>" placeholder="description">
			              </div>
			              <br>
			              <div class="form-label-group">
			              	  <input class="form-control" type="text" name="<%= Constants.PLACE %>" placeholder="place">
			              </div>
			              <br>
			              <div class="form-label-group">
			              	  <input class="form-control" type="date" name="<%= Constants.DATE %>" placeholder="Second name">
			              </div>
			              <br>       
			              <h5 class="card-title text-center">Events</h5>
						  <div class="form-label-group" id="event">
			              	  <input class="form-control" type="text" name="<%= Constants.TITLE_EVENT %>" placeholder="title" required>
							  <input class="form-control" type="time" name="<%= Constants.TIME %>" placeholder="time" required>
			              </div>
					   	  <a href="JavaScript:addEvent()">Add event</a>
		            </form>
		            <button class="btn btn-lg btn-secondary btn-block text-uppercase" type="submit" value="Create" form="addConf">Create</button>   
		          </div>
		        </div>
		      </div>
		    </div>
	     </div>	
	</body>
</html>