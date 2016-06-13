<%-- 
    Document   : allBooks
    Created on : Jun 13, 2016, 10:10:13 AM
    Author     : rome10
--%>

<%@page import="weblib.central.dispatchers.Paths"%>
<%@page import="be.bt.model.Book"%>
<%@page import="java.util.ArrayList"%>
<%@page import="weblib.central.dispatchers.Paths.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="ListBooks" scope="request" type="java.util.ArrayList<Book>" ></jsp:useBean>
<jsp:useBean id="ShopCart" scope="session" class="weblib.central.beans.ShopCart" ></jsp:useBean>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Books Bitch !</title>
    </head>
    <body>
        <h1>All Books Bitch !</h1>
        <div class="wrapper">
            <span id="seeCart">See Cart></span>
            <table>
                <tr></tr>
                <% for (Book b : ListBooks) { %>              
                <tr><td><%= b.getTitle()%></td> 
                    <td><%= b.getIsbn()%></td>
                    <td><%= b.getPrice()%></td>
                    
                    <td>
                        <% if (ShopCart.inCart(b)) { %>
                        <a href="<%= Paths.ROOT %>main/AddToCart?op=false&isbn=<%= b.getIsbn()%>" >Remove From Cart</a>
                        <% } else { %>
                        <a href="<%= Paths.ROOT %>main/AddToCart?op=true&isbn=<%= b.getIsbn()%>" >Add To Cart</a>
                        <% } %>
                    </td>
                    
                </tr>
                <% } %>            
                
            </table>
            
            
        </div>
        
        
    </body>
</html>
