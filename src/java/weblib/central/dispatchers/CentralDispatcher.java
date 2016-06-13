/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weblib.central.dispatchers;

import java.io.IOException;
import weblib.central.actions.Action;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import weblib.central.actions.AddAuthorAction;
import weblib.central.actions.AddToCartAction;
import weblib.central.actions.AllBooksAction;
import weblib.central.actions.AuthorFormAction;

/**
 *
 * @author rome10
 */
public class CentralDispatcher {
    private Map<String,Action> urlsAction = new HashMap<String,Action>();
    private static CentralDispatcher instance;
    
    private CentralDispatcher() {
        populate();
    }
    
    public static CentralDispatcher getInstance() {
        if (instance == null) {
            return instance = new CentralDispatcher();
        } else {
            return instance;
        }
    }
    
    private void populate() {
        urlsAction.put(Paths.LOGGED+"",new AllBooksAction());
        urlsAction.put(Paths.LOGGED+"AddToCart",new AddToCartAction());
        
        
        
    }
    
    public void delegate(HttpServletRequest request, HttpServletResponse response) {
        String url = request.getRequestURI();
        Action a = urlsAction.get(url);
        String forward = null;
        
        if (null != a) {
            forward = a.execute(request, response);
        } else {
            forward = "/main/";
        }
        
        try {
            request.getRequestDispatcher(forward).forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(LoggerDispatcher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LoggerDispatcher.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}