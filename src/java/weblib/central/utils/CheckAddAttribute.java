/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weblib.central.utils;

import javax.servlet.http.HttpServletRequest;
import weblib.central.beans.Haricot;

/**
 *
 * @author rome10
 */
public class CheckAddAttribute {
    public static <T> void inSession(HttpServletRequest r, String attName, T object) {
        T check = (T) r.getSession().getAttribute(attName);
        
        if (null == check) {
           
        }
    }
}
