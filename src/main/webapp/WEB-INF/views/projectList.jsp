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
			
			<p class="page_cnt">${page } / ${cnt}</p>
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
					<td><a href="read.do?no=${item.no}">${item.name}</a></td>
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
			<div class="text-center">
				<ul class="pagination justify-content-center">
					<c:if test="${pageMaker.prev }">
						<li class="page-item">
							<a class="page-link" href="listPage?page=${pageMaker.startPage-1}&searchType=${pageMaker.criteria.searchType}&keyword=${pageMaker.criteria.keyword}" aria-label="Previous">
								<span aria-hidden="true">&laquo;</span>
								<span class="sr-only">Prev</span>
							</a>
						</li>
					</c:if>
					
					<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
						<li class="page-item${pageMaker.criteria.page == idx ? ' active': '' }"><a class="page-link" href="listPage?page=${idx}&searchType=${criteria.searchType}&keyword=${criteria.keyword}">${idx}</a></li>
					</c:forEach>
					<c:if test="${pageMaker.next }">
						<li class="page-item">
							<a class="page-link" href="listPage?page=${pageMaker.endPage+1}&searchType=${pageMaker.criteria.searchType}&keyword=${pageMaker.criteria.keyword}" aria-label="Next">
								<span aria-hidden="true">&raquo;</span>
								<span class="sr-only">Next</span>
							</a>
						</li>
					</c:if>
				</ul>
			</div>
		</section>
		<jsp:include page="module/bottom.jsp" flush="false" />
	</div>
</body>
</html>