<%-- 
    Document   : Login
    Created on : Jun 3, 2016, 2:23:08 PM
    Author     : Rome10
--%>

<%@page import="weblib.central.beans.UserAuth"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Proprement Préparé</title>
    </head>
    <body>
        <form action="/logger/grant" method="POST">
            Username : <input name="user" type="text"/></br>
            Password : <input name="password" type="password" /></br>
            <input type="submit" value="send" />
        </form>
    </body>
</html>
