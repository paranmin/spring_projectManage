<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로젝트 등록</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/style.css" media="all" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/jquery-ui.min.css" media="all" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/jquery-ui.theme.css" media="all" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/resources/js/jquery-ui.min.js"></script>
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
	$("#startDate").datepicker({ dateFormat: "yy-mm-dd"});
	$("#endDate").datepicker({ dateFormat: "yy-mm-dd"});
});
</script>
</head>
<body>
	<div id="wrapper">
		<jsp:include page="module/top.jsp" flush="false" />
		<section>
			<form action="register" method="post">
			<table class="register">
				<tr>
					<th><label for="name">프로젝트 이름</label></th>
					<td><input type="text" name="name" id="name" class="register_form" /></td>
				</tr>
				<tr>
					<th><label for="content">프로젝트 내용</label></th>
					<td><textarea name="content" id="content" cols="100" rows="10" class="register_form"></textarea></td>
				</tr>
				<tr>
					<th><label for="name">시작날짜</label></th>
					<td><input type="text" name="startDate" id="startDate" class="register_form" /></td>
				</tr>
				<tr>
					<th><label for="name">마감날짜</label></th>
					<td><input type="text" name="endDate" id="endDate" class="register_form" /></td>
				</tr>
				<tr>
					<th><label for="state">상태</label></th>
					<td><select name="state" id="state" class="register_form">
						<option value="준비">준비</option>
						<option value="진행중">진행중</option>
						<option value="종료">종료</option>
						<option value="보류">보류</option>
					</select></td>
				</tr>
			</table>
			<p class="register_btn">
				<input type="submit" value="저장" />
				<a href="${pageContext.request.contextPath }">취소</a>
			</p>
			</form>
		</section>
		<jsp:include page="module/bottom.jsp" flush="false" />
	</div>
</body>
</html>