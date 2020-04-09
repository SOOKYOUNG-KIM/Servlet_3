<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- BootStrap API -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<!-- BootStrap API -->  
</head>
<body>
	

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