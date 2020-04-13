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
  <form action="./noticeUpdate" method="post">          
  <table class="table table-condensed">
    <thead>
      <tr>
        <th>TITLE</th>
        <th>CONTENTS</th>
        <th>NAME</th>
        <th>DATE</th>
        <th>HIT</th>
      </tr>
    </thead>
    <tbody>
			<tr>
				<td class="con">${dto.title}</td>
				<td class="con">${dto.contenst}</td>
				<td class="name">${dto.writer}</td>
				<td class="date">${dto.rdate}</td>
				<td class="hit">
				<span class="num">${dto.views}</span> 
				</td>
			</tr> 
    
    </tbody>
  </table>

  	<div class="form-group">
      <label for="title">Title:</label>
      <input type="text" class="form-control" id="title" placeholder="Enter Title" name="title" value="${dto.title}">
    </div>
  
    <div class="form-group">
      <label for="comment">Contents:</label>
      <input class="form-control" rows="5" id="contenst" placeholder="Enter Contents" name="contenst" value="${dto.contenst}"></input>
    </div>
</form>
</div>
</body>
</html>