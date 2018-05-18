<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로젝트 수정</title>
<link rel="stylesheet" href="css/style.css" media="all" />
<link rel="stylesheet" href="css/jquery-ui.min.css" media="all" />
<link rel="stylesheet" href="css/jquery-ui.theme.css" media="all" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="js/jquery-ui.min.js"></script>
<script>
$(function() {
	$("input:submit").on("click",function() {
		var error = false;
		
		$("table.register .register_form").css("border", "1px solid #E8E5E5");
		$("table.register .register_form").each(function(i, obj) {
			if ($(obj).val().trim() == "") {
				$(obj).css("border", "2px solid #D12921");
				error = true;
			}
		});
		if (error) {
			return false;
		}
		return true;
	});
	$("#startdate").datepicker({ dateFormat: "yy-mm-dd"});
	$("#enddate").datepicker({ dateFormat: "yy-mm-dd"});
});
</script>
</head>
<body>
	<div id="wrapper">
		<jsp:include page="module/top.jsp" flush="false" />
		<section>
			<form action="modify.do" method="post">
			<input type="hidden" name="no" value="${project.no}" />
			<table class="register">
				<tr>
					<th><label for="name">프로젝트 이름</label></th>
					<td><input type="text" name="name" id="name" class="register_form" value="${project.name }" /></td>
				</tr>
				<tr>
					<th><label for="content">프로젝트 내용</label></th>
					<td><textarea name="content" id="content" cols="100" rows="10" class="register_form">${project.content}</textarea></td>
				</tr>
				<tr>
					<th><label for="name">시작날짜</label></th>
					<td><input type="text" name="startdate" id="startdate" class="register_form" value="<fmt:formatDate value="${project.startDate}" pattern="yyyy-MM-dd"/>" /></td>
				</tr>
				<tr>
					<th><label for="name">마감날짜</label></th>
					<td><input type="text" name="enddate" id="enddate" class="register_form" value="<fmt:formatDate value="${project.endDate}" pattern="yyyy-MM-dd"/>" /></td>
				</tr>
				<tr>
					<th><label for="state">상태</label></th>
					<td><select name="state" id="state" class="register_form">
						<option value="준비" <c:if test="${project.state == '준비'}">selected="selected"</c:if> >준비</option>
						<option value="진행중" <c:if test="${project.state == '진행중'}">selected="selected"</c:if> >진행중</option>
						<option value="종료" <c:if test="${project.state == '종료'}">selected="selected"</c:if> >종료</option>
						<option value="보류" <c:if test="${project.state == '보류'}">selected="selected"</c:if> >보류</option>
					</select></td>
				</tr>
			</table>
			<p class="register_btn">
				<input type="submit" value="수정" />
				<a href="read.do?no=${project.no}">취소</a>
			</p>
			</form>
		</section>
		<jsp:include page="module/bottom.jsp" flush="false" />
	</div>
</body>
</html>