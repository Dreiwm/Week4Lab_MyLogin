<%-- 
    Document   : login
    Created on : Oct 11, 2020, 7:54:16 PM
    Author     : Chris
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Week 4 MyLogin</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="login" method="post">
            <label>Username: </label><input type="text" name="user" value="${user}">
            <br>
            <label>Password: </label><input type="password" name="password" value="${password}">
            <br>
            <label>${message}</label>
            <br>      
            <input type="submit" value="Login">
        </form>
        
    </body>
</html>
