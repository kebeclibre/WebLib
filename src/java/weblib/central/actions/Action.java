/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weblib.central.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import weblib.central.beans.Haricot;

/**
 *
 * @author rome10
 */
public interface Action {
    
   
    public String execute(HttpServletRequest request, HttpServletResponse response);
}
