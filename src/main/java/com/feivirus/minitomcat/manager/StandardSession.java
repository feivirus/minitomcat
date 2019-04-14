package com.feivirus.minitomcat.manager;

import java.io.Serializable;
import java.util.Map;

import javax.servlet.session.HttpSession;

public class StandardSession implements Session,Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -2068650777803939509L;
    
    private Manager manager;
    
    private Map<String, Object> attributes;
    
    private long lastAccessTime;
    
    private String sessionId;
    
    private boolean isValid;
    
    private long maxActiveInterval;
    
    public StandardSession(Manager manager) {
        this.manager = manager;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public String getId() {
        return sessionId;
    }

    public void setId(String id) {
        this.sessionId = sessionId;
    }

    public void access() {
        // TODO Auto-generated method stub
        
    }

    public long getLastAccessedTime() {
        return lastAccessTime;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valide) {
        isValid = true;
    }

    public void expire() {
        setValid(false);
        
        if (manager != null) {
            manager.removeSession(this);
        }
        
        //遍历属性map，一个个移除，tomcat如此做，不太清楚为啥一个个移除.
    }
    
    public HttpSession getSession() {
        return(HttpSession)this;
    }
}
