<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
    <title>Login</title>
</head>
<body>
<div class="container">
  <h2>Login</h2>
    <form action="login" method="post">
        <label for="UserName">UserName:</label>
        <input type="text"  id="username"  name="Name" required>
        <br>
         <label for="password">Password:</label>
        <input type="password"  id="password" name="Password" required>
        <br>

      <button type="submit">Login</button>
    </form>
    <p><a href="Fast.html">Back to Home</a></p>
    <p style="color: red">
             
            <% 
            // Display error message if parameter 'error' is set to '1'
            String error = request.getParameter("error");
            if(error != null && error.equals("1")) {
                out.println("Incorrect username or password. Try again.");
            }
            %>
        </p>
</div>


</body>
</html>