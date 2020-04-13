<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"></c:import>
</head>
<body>

<c:import url="../template/header.jsp"></c:import>


	<div class="container">
		<div class="row">
			<h1>Notice List Page</h1>
			
			<table class="table table-hover">
				<tr>
					<td>글번호</td>
					<td>제목</td>
					<td>작성자</td>
					<td>날짜</td>
					<td>조회수</td>
				</tr>
				
				<c:forEach items="${list}" var="dto">
					<tr>
						<td>${dto.nnum}</td>
						<td><a href="./noticeSelect?nnum=${dto.nnum}">${dto.title}</a></td>
						<td>${dto.writer}</td>
						<td>${dto.rdate}</td>
						<td>${dto.views}</td>
						
					</tr>
				</c:forEach>
				
				
			</table>
			 <ul class="pagination">
			    <li class="active"><a href="#">1</a></li>
			    <li><a href="#">2</a></li>
			    <li><a href="#">3</a></li>
			    <li><a href="#">4</a></li>
			    <li><a href="#">5</a></li>
			  </ul>
						
	 <c:if test="${member.id eq dto.writer}">
			<a href="./noticeAdd" class="btn btn-primary">Notice Add</a>
 	  </c:if>
			
		
		</div>
	</div>
	
	
	
	

</body>
</html>