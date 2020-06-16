<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

</head>
<body>


	<div class="container">
		<div class="d-flex">
			<table class="table table-hover mr-1">
				<thead>
					<tr>
						<th colspan="2">팀 목록</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="teamlists" items="${teamlists }">
					<tr>
						<td onclick="allPlayerList('${teamlists.teamid }')">${teamlists.teamid }</td>
						<td onclick="allPlayerList('${teamlists.teamid }')">${teamlists.teamname }</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>

			<table class="table table-bordered mr-1">
				<thead>
					<tr>
						<th>등번호</th>
						<th>선수 목록</th>
					</tr>
				</thead>
				<tbody id="playerlist">
					<tr>
						
					</tr>
				</tbody>
			</table>
			<table class="table table-bordered mr-1">
				<thead>
					<tr>
						<th>번호</th>
						<th>이름</th>
						<th>포지션</th>
					</tr>
				</thead>
				<tbody id="playerdetaillist">
					<tr>
	
					</tr>
				</tbody>
			</table>
		</div>
		
	</div>

<script src="js/func.js"></script>
</body>

</html>