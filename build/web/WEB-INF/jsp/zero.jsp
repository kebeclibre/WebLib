<%-- 
    Document   : Login
    Created on : Jun 3, 2016, 2:23:08 PM
    Author     : Rome10
--%>

<%@page import="weblib.central.dispatchers.Paths"%>
<%@page import="weblib.central.beans.UserAuth"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="UserAuth" class="weblib.central.beans.UserAuth" scope="session"></jsp:useBean>

<!DOCTYPE html>
<%  String username = null!=UserAuth.getUsername()?UserAuth.getUsername():""; %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Proprement Préparé</title>
    </head>
    <body>
        <form action="<%= Paths.ROOT %>logger/grant" method="POST">
            Username : <input name="user" type="text" value="<%=username%>"/></br>
            Password : <input name="password" type="password" /></br>
            <input type="submit" value="send" /> 
        </form>
            <div>
                <a href="<%=Paths.ROOT%>requestMembership">Register as new user</a>
                
            </div>
    </body>
</html>
