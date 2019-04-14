package com.feivirus.minitomcat.manager;

import java.util.Map;

import com.feivirus.minitomcat.container.Container;

public abstract class ManagerBase implements Manager{
    /**
     * key 是sessionid
     */
    protected Map<String, Session> sessionMap;

    public Container getContainer() {
        // TODO Auto-generated method stub
        return null;
    }

    public void setContainer(Container container) {
        // TODO Auto-generated method stub
        
    }

    public Session createSession() {
        // TODO Auto-generated method stub
        return null;
    }

    public Session findSession(String sessionId) {
        if (sessionId == null) {
            return null;
        }
        synchronized (sessionMap) {
            return sessionMap.get(sessionId);
        }
    }

    public void removeSession(Session session) {
        synchronized (sessionMap) {
            sessionMap.remove(session.getId());
        }
    }

    public void add(Session session) {
        synchronized (sessionMap) {
            sessionMap.put(session.getId(), session);
        }
    }

    public int getMaxActiveInterval() {
        // TODO Auto-generated method stub
        return 0;
    }

    public void setMaxActiveInterval(int interval) {
        // TODO Auto-generated method stub
        
    }

    public void load() {
        // TODO Auto-generated method stub
        
    }

    public void unload() {
        // TODO Auto-generated method stub
        
    }
}
