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
  <h2>Point Add Form</h2>
  <form action="./pointAdd" method="post">
    <div class="form-group">
      <label for="name">Name:</label>
      <input type="text" class="form-control" id="name" placeholder="Enter name" name="name" >
    </div>
    
    <div class="form-group">
      <label for="num">Num:</label>
      <input type="text" class="form-control" id="num" placeholder="Enter Number" name="num">
    </div>
    
    <div class="form-group">
      <label for="num">Kor:</label>
      <input type="text" class="form-control" id="kor" placeholder="Enter Number" name="kor">
    </div>
    
     <div class="form-group">
      <label for="num">Eng:</label>
      <input type="text" class="form-control" id="eng" placeholder="Enter Number" name="eng">
    </div>
    
    <div class="form-group">
      <label for="num">Math:</label>
      <input type="text" class="form-control" id="math" placeholder="Enter Number" name="math">
    </div>
    
   
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
</div>

</body>
</html>