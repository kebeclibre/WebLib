/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weblib.central.dispatchers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.jasper.tagplugins.jstl.core.Out;
import weblib.central.actions.Action;
import weblib.central.actions.AddAuthorAction;
import weblib.central.actions.AuthorFormAction;
import weblib.central.actions.GrantAccessAction;
import weblib.central.actions.logger.IllegalAction;
import weblib.central.actions.logger.LoggerIndexAction;
import weblib.central.dispatchers.Paths;

/**
 *
 * @author rome10
 */
public class LoggerDispatcher {
    private Map<String,Action> urlsAction = new HashMap<String,Action>();
    private static LoggerDispatcher instance;
    
    private LoggerDispatcher() {
        populate();
    }
    
    public static LoggerDispatcher getInstance() {
        if (instance == null) {
            return instance = new LoggerDispatcher();
        } else {
            return instance;
        }
    }
    
    private void populate() {
        urlsAction.put(Paths.LOGGER+"IllegalUrl",new IllegalAction());
        urlsAction.put(Paths.ROOT+"",new LoggerIndexAction());
        urlsAction.put(Paths.ROOT+"index.jsp",new LoggerIndexAction());
        urlsAction.put(Paths.ROOT+"index.html",new LoggerIndexAction());
        urlsAction.put(Paths.LOGGER+"",new LoggerIndexAction());
        urlsAction.put(Paths.LOGGER+"requestMembership",new AuthorFormAction());
        urlsAction.put(Paths.LOGGER+"requestMembership/send",new AuthorFormAction());
        urlsAction.put(Paths.LOGGED+"",new LoggerIndexAction());
        urlsAction.put(Paths.LOGGER+"grant",new GrantAccessAction());
        urlsAction.put(Paths.LOGGER+"maxAttemps",new GrantAccessAction());
        
    }
    
    public void delegate(HttpServletRequest request, HttpServletResponse response) {
        String url = request.getRequestURI();
        Action a = urlsAction.get(url);
        System.out.println(urlsAction.toString());
        String forward = "";
        System.out.println(url);
        System.out.println(a);
        if (null != a) {
            forward = a.execute(request, response);
        } else {
            forward = "/logger/";
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
