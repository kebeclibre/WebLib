/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weblib.central.beans;

/**
 *
 * @author Rome10
 */
public class UserAuth {
    private String username;
    private int authStatus=-2;
    private int logCount;

    public int getLogCount() {
        return logCount;
    }

    public String getUsername() {
        return username;
    }

    public void setLogCount(int logCount) {
        this.logCount = logCount;
    }

    public int getAuthStatus() {
        return authStatus;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAuthStatus(int authStatus) {
        this.authStatus = authStatus;
    }
    
    
}
