<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SPMS</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/style.css" media="all" />
</head>
<body>
	<div id="wrapper">
		<jsp:include page="module/top.jsp" flush="false" />
		<section>
			<p class="register">
				<a href="${pageContext.request.contextPath }/register">[새 프로젝트 등록]</a>
			</p>

			<p class="page_cnt">${pageMaker.criteria.page } / ${pageMaker.endPage}</p>
			<table class="list">
				<tr>
					<th>프로젝트 이름</th>
					<th>시작날짜</th>
					<th>종료날짜</th>
					<th>상태</th>
				</tr>
		<c:choose>
			<c:when test="${list.size() > 0}">
				<c:forEach var="item" items="${list}">
				<tr>
					<td><a href="read?no=${item.no}">${item.name}</a></td>
					<td class="text_center"><fmt:formatDate value="${item.startDate}" pattern="yyyy-MM-dd"/></td>
					<td class="text_center "><fmt:formatDate value="${item.endDate}" pattern="yyyy-MM-dd"/></td>
					<td class="text_center">${item.state}</td>
				</tr>
				</c:forEach>
				
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="4" class="no_project">등록된 프로젝트가 없습니다.</td>
				</tr>
			</c:otherwise>
		</c:choose>
			</table>
			<p class="paging">
				<c:if test="${pageMaker.prev }">
					<a href="list?page=${pageMaker.startPage-1}">이전</a>
				</c:if>
				<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
					<a href="list?page=${idx}">${idx}</a>
				</c:forEach>
				<c:if test="${pageMaker.next }">
					<a href="list?page=${pageMaker.endPage+1}">다음</a>
				</c:if>
			</p>
		</section>
		<jsp:include page="module/bottom.jsp" flush="false" />
	</div>
</body>
</html>