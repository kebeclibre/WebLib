/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weblib.central.actions;

import be.bt.model.Book;
import be.bt.model.Library;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import weblib.central.beans.Haricot;
import weblib.central.beans.ShopCart;
import weblib.central.dispatchers.Paths;

/**
 *
 * @author rome10
 */
public class AllBooksAction implements Action{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Library l = (Library) request.getServletContext().getAttribute("Library");
        ShopCart sc = (ShopCart) request.getSession().getAttribute("ShopCart");
        
        
        if ( null == l) {
            l = new Library();
            request.getServletContext().setAttribute("Library",l);
        }
        
        if (null == sc) {
            sc = new ShopCart();
            request.getSession().setAttribute("ShopCart",sc);
        }
        
        List<Book> listBooks = l.getAllBooks();
        request.setAttribute("ListBooks", listBooks);
        
        return Paths.JSP+"display/allBooks.jsp";
    }

}