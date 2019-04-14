package com.feivirus.minitomcat.manager;

import com.feivirus.minitomcat.container.Container;

public interface Manager {
    Container getContainer();
    
    void setContainer(Container container);
    
    Session createSession();
    
    Session findSession(String sessionId);
    
    void removeSession(Session session);
    
    /**
     * 添加session池
     * @param session
     */
    void add(Session session);
    
    public int getMaxActiveInterval();
    
    public void setMaxActiveInterval(int interval);
    
    /**
     * 持久化
     */
    public void load();
    
    public void unload();
}
