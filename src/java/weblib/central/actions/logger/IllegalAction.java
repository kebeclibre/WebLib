/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weblib.central.actions.logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import weblib.central.actions.Action;
import weblib.central.dispatchers.Paths;

/**
 *
 * @author rome10
 */
public class IllegalAction implements Action{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return Paths.JSP+"IllegalUrl.jsp";
    }
    
}
