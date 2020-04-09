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

<!-- Nav -->
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">WebSiteName</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="${pageContext.request.contextPath}">Home</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Page 1-1</a></li>
          <li><a href="#">Page 1-2</a></li>
          <li><a href="#">Page 1-3</a></li>
        </ul>
      </li>
      <li><a href="${pageContext.request.contextPath}/point/pointList">Point</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="${pageContext.request.contextPath}/member/memberJoin"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="${pageContext.request.contextPath}/member/memberLogin"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>
<!-- Nav -->


<div class="container">
  <h2>Join form</h2>
  <form action="./memberJoin" method="post">
  
     <div class="form-group">
      <label for="id">ID:</label>
      <input type="text" class="form-control" id="id" placeholder="Enter ID" name="id">
    </div>
  
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pw">
    </div>
    
    
    <div class="form-group">
      <label for="name">Name:</label>
      <input type="text" class="form-control" id="name" placeholder="Enter Name" name="name">
    </div>
    
    <div class="form-group">
      <label for="Age">Age:</label>
      <input type="text" class="form-control" id="age" placeholder="Enter Age" name="age">
    </div>
    
     <div class="form-group">
      <label for="num">Number:</label>
      <input type="text" class="form-control" id="number" placeholder="Enter Number" name="phone">
    </div>
    
    <div class="form-group">
      <label for="email">Email:</label>
      <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
    </div>
    
    
    <button type="submit" class="btn btn-default">Submit</button>
    
  </form>
</div>


</body>
</html>