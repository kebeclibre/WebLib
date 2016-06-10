/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weblib.central.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import weblib.central.beans.Haricot;
import weblib.central.beans.UserAuth;
import weblib.central.dispatchers.Paths;
import weblib.central.utils.Authenticator;

/**
 *
 * @author rome10
 */
public class GrantAccessAction implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
           UserAuth ua = (UserAuth) request.getSession().getAttribute("UserAuth");
           String username = request.getParameter("user");
           String pass = request.getParameter("password");
              
           if (ua.getLogCount() < 3) {
               ua.setLogCount(ua.getLogCount()+1);
               ua.setUsername(username);
               ua.setAuthStatus(Authenticator.verifyCredentials(ua.getUsername(), pass));
               return Paths.LOGGED+"";
           }
           
           return Paths.JSP+"loggerFacility/maxAttemps.jsp";
    }
    
    public String execute(HttpServletRequest request, HttpServletResponse response, Haricot ha) {
        return "";
    }
}