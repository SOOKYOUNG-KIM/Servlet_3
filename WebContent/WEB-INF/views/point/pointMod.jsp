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
  <h2>Point Mode</h2>
  <form class="form-horizontal" action="./pointMod" method="post">
   <div class="form-group">
      <label for="name">Name:</label>
      <input type="text" class="form-control" id="name" name="name" value="${dto.name}">
    </div>
    
    <div class="form-group">
      <label for="num">Num:</label>
      <input type="text" class="form-control" id="num" name="num" value="${dto.num}" readonly="readonly">
    </div>
    
    <div class="form-group">
      <label for="num">Kor:</label>
      <input type="text" class="form-control" id="kor" name="kor" value="${dto.kor}">
    </div>
    
     <div class="form-group">
      <label for="num">Eng:</label>
      <input type="text" class="form-control" id="eng" name="eng" value="${dto.eng}">
    </div>
    
    <div class="form-group">
      <label for="num">Math:</label>
      <input type="text" class="form-control" id="math" name="math" value="${dto.math}">
    </div>

   
        <button type="submit" class="btn btn-default">Submit</button>

 
  </form>
</div>


</body>
</html>