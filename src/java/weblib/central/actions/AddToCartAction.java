/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weblib.central.actions;

import be.bt.model.Book;
import be.bt.model.Library;
import be.bt.model.dao.LibraryDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import weblib.central.beans.ShopCart;
import weblib.central.dispatchers.Paths;

/**
 *
 * @author rome10
 */
public class AddToCartAction implements Action{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Boolean op = new Boolean(request.getParameter("op")); 
        String isbn = request.getParameter("isbn");      
        Book b = LibraryDAO.getInstance().getBookByIsbn(isbn);
        
        ShopCart sc = (ShopCart) request.getSession().getAttribute("ShopCart");
        
        if (op) {
            sc.addBook(b); }
        else {sc.removeBook(b);}
        
        return Paths.ROOT+"";
    }
    
}
