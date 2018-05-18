<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SPMS</title>
<link rel="stylesheet" href="css/style.css" media="all" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(function() {
	$("a.remove").on("click", function() {
		if (confirm("프로젝트를 삭제하시겠습니까?")) {
			return true;
		}
		return false;
	});
});
</script>
</head>
<body>
	<div id="wrapper">
		<jsp:include page="module/top.jsp" flush="false" />
		<section>
			<table class="read">
				<tr>
					<th>프로젝트 이름</th>
					<td>${project.name}</td>
					<th>상태</th>
					<td>${project.state}</td>
				</tr>
				<tr>
					<th>시작날짜</th>
					<td><fmt:formatDate value="${project.startDate}" pattern="yyyy-MM-dd"/></td>
					<th>종료날짜</th>
					<td><fmt:formatDate value="${project.endDate}" pattern="yyyy-MM-dd"/></td>
				</tr>
				<tr>
					<td colspan="4">${project.content}</td>
				</tr>
			</table>
			<p class="read_btn">
				<a href="modify.do?no=${project.no}" class="modify">수정</a>
				<a href="remove.do?no=${project.no}" class="remove">삭제</a>
				<a href="list.do" class="list">목록</a>
			</p>
		</section>
		<jsp:include page="module/bottom.jsp" flush="false" />
	</div>
</body>
</html>