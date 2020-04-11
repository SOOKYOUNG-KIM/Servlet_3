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
  <h2>NOTICE</h2>
  <p>The .table-condensed class makes a table more compact by cutting cell padding in half:</p>            
  <table class="table table-condensed">
    <thead>
      <tr>
        <th>TITLE</th>
        <th>NAME</th>
        <th>DATE</th>
        <th>HIT</th>
      </tr>
    </thead>
    <tbody>
			<tr>
				<td class="con">${dto.contenst}</td>
				<td class="name">${dto.writer}</td>
				<td class="date">${dto.rdate}</td>
				<td class="hit">
				<span class="num">${dto.views}</span> 
				</td>
			</tr> 
    </tbody>
  </table>

			<a href="./noticeList?num=${dto.nnum}" class="btn btn-warning" id="L1">LIST</a>
			
	 <c:if test="${dto.writer eq member.id}">
		<a href="./noticeUpdate?num=${dto.nnum}" class="btn btn-primary" id="up">Update</a>
 	  </c:if>
			
		</div>

</body>
</html>