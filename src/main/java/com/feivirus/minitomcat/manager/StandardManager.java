package com.feivirus.minitomcat.manager;

import com.feivirus.minitomcat.container.Container;

/**
 * 内存session
 * @author feivirus
 *
 */
public class StandardManager extends ManagerBase{
    
    /**
     * 在start生命周期中调用
     * 启动线程，定时销毁失效的session对象
     * org.apache.catalina.session.ManagerBase.backgroundProcess()实现
     */
    public void run() {
        
    }

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
        // TODO Auto-generated method stub
        return null;
    }

    public void removeSession(Session session) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void add(Session session) {
        // TODO Auto-generated method stub
        super.add(session);
    }

    @Override
    public int getMaxActiveInterval() {
        // TODO Auto-generated method stub
        return super.getMaxActiveInterval();
    }

    @Override
    public void setMaxActiveInterval(int interval) {
        // TODO Auto-generated method stub
        super.setMaxActiveInterval(interval);
    }

    /**
     * 
     */
    @Override
    public void load() {
        // TODO Auto-generated method stub
        super.load();
    }

    /**
     * 在stop的生命周期中
     * 持久化到session.ser文件中
     */
    @Override
    public void unload() {
        // TODO Auto-generated method stub
        super.unload();
    }
    
    

}
