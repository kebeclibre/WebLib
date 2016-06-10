/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weblib.central.dispatchers;

public enum Paths {
        ROOT("/WebLib/"),
        LOGGER(ROOT.toString()+"logger/"),
        LOGGED(ROOT+"main/"),
        JSP("/WEB-INF/jsp/"),
        
        ;
        private String path;
        
        Paths(String st){
            this.path = st;
        }
        
        public String toString() {
            return this.path;
        }
        
    }