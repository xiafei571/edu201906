<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>首页</title>
</head>
<body>
	<h1>Hello</h1>
	<h2>World</h2>
	<h3>${msg}</h3>
	<h3>${abc}</h3>
	<h4>${list}</h4>

	<table border="1">
		<thead>
			<tr>
				<th>1.PID</th>
				<th>2.PNAME</th>
				<th>3.PHOTO</th>
				<th>4.FLAG</th>
				<th>5.LOGO</th>
				<th>6.OVERALL</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="p">
				<tr>
					<td>${p.pid}</td>
					<td>${p.pname}</td>
					<td><img alt="photo" src="${p.photo}" /></td>
					<td><img alt="photo" src="${p.club.logo}" /></td>
					<td><img alt="photo" src="${p.nation.flag}" /></td>
					<td>${p.overall}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


	<div class="container">
		<!-- Content here -->
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="#">导航</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
						role="button" aria-haspopup="true" aria-expanded="false"
						target="main_iframe">球员信息</a>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="player/list" target="main_iframe">球员列表</a>
							<a class="dropdown-item" href="#" target="main_iframe">添加球员</a>
						</div></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
						role="button" aria-haspopup="true" aria-expanded="false"
						target="main_iframe">俱乐部信息</a>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="#" target="main_iframe">俱乐部列表</a>
							<a class="dropdown-item" href="#" target="main_iframe">添加俱乐部</a>
						</div></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
						role="button" aria-haspopup="true" aria-expanded="false"
						target="main_iframe">国家信息</a>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="#" target="main_iframe">国家列表</a> <a
								class="dropdown-item" href="#" target="main_iframe">添加国家</a>
						</div></li>
				</ul>
				<form class="form-inline my-2 my-lg-0">
					<input class="form-control mr-sm-2" type="search"
						placeholder="Search" aria-label="Search">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
				</form>
			</div>
		</nav>
		<div class="embed-responsive embed-responsive-4by3">
			<iframe name="main_iframe" width="100%" class="embed-responsive-item"
				src="player/list"> </iframe>
		</div>

	</div>
	<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.bootcss.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>

</body>
</html>