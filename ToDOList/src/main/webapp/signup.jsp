<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="sign.css">
</head>
<body>
<div class="fc">
<form action="s1" method="post" enctype="multipart/form-data">
<div>
<div id="ld">
<label>USER ID</label><br>
</div>
<input type="text" name="id" placeholder="Enter your Id">
</div>
<br>
<div>
<div id="ld">
<label>USER NAME</label><br>
</div>
<input type="text" name="name" placeholder="Enter your Name">
</div>
<br>
<div>
<div id="ld">
<label>USER EMAIL</label><br>
</div>
<input type="text" name="email" placeholder="Enter your Email">
</div>
<br>
<div>
<div id="ld">
<label>USER CONTACT</label><br>
</div>
<input type="tel" name="contact" placeholder="Enter your MobileNo">
</div>
<br>
<div>
<div id="ld">
<label>USER PASSWORD</label><br>
</div>
<input type="password" name="password" placeholder="Enter your Password">
</div>
<br>
<div>
<div id="ld">
<label>USER IMAGE</label><br>
</div>
<input type="file" name="image" placeholder="Choose an image">
</div>
<br>
<div id="sub">
<input type="submit">
</div>
<a href="login.jsp">Login</a>
<a href="signup.jsp">SignUp</a>
</form>
</div>


</body>
</html>