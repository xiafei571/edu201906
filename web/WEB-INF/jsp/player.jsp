<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html>
<head>
<script src="${pageContext.request.contextPath}/js/echarts.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>部门信息</title>
</head>
<body>
	<div class="container">
		<div class="row" style="height: 400px;">
			<table class="table table-striped">
				<thead>
					<tr>球员列表/共有 ${result.pagination.totalCount} 条数据
					</tr>
					<tr>
						<th scope="col">#</th>
						<th scope="col">球员名称</th>
						<th scope="col">照片</th>
						<th scope="col">能力</th>
						<th scope="col">操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${result.pageData}" var="list">
						<tr>
							<th scope="row">${list.rowid}</th>
							<td>${list.pname}</td>
							<td><img src="${list.photo}" alt="${list.pname}" /></td>
							<td>${list.overall}</td>
							<td><a href="${list.pid}/show">查看</a> <a href="#">修改</a> <a
								href="#" onClick="return confirm('确定删除${list.pname}吗?');">删除</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<nav aria-label="...">
				<ul class="pagination">
					<!-- 如果当前页是第一页的话，上一页置灰 -->
					<li class="page-item" id="page_pre"><a class="page-link"
						href="list?pageIndex=${result.pagination.pageIndex-1}&pageSize=${result.pagination.pageSize}"
						tabindex="-1">上一页</a></li>

					<!-- 循环生成页签 改成用jquery实现  
					
					<!-- 如果当前页是最后一页的话，下一页置灰 -->
					<li class="page-item" id="page_next"><a class="page-link"
						href="list?pageIndex=${result.pagination.pageIndex+1}&pageSize=${result.pagination.pageSize}"
						tabindex="-1">下一页</a></li>

				</ul>
			</nav>
		</div>
		<div class="row">
			<div id="dept_main_1" class="col" style="height: 400px;"></div>
			<div id="dept_main_2" class="col" style="height: 400px;"></div>
		</div>
	</div>
	</div>
	<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
	<script
		src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.bootcss.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/player.js"></script>
	<script type="text/javascript">
		window.onload = function() {
			initPage('${result.pagination.pageIndex}',
					'${result.pagination.pageSize}',
					'${result.pagination.totalCountPage}');

			//initChat();
		}
	</script>
</body>
</html>