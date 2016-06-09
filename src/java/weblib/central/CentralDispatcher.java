/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weblib.central;

import weblib.central.actions.Action;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import weblib.central.actions.AddAuthorAction;
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
        urlsAction.put("AddAuthor",new AddAuthorAction());
        urlsAction.put("AuthorForm",new AuthorFormAction());
        
    }
    
    public void delegate(HttpServletRequest request, HttpServletResponse response) {
        StringBuffer url = request.getRequestURL();
        String[] urlParts = url.toString().split("/");
        
        Action a = urlsAction.get(urlParts[urlParts.length-1]);
        if (null != a) {
            a.execute(request,response);
        } else {
            request.getRequestDispatcher("index.jsp");
        }
    }
    
}
