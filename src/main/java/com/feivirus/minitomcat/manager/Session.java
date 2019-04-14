package com.feivirus.minitomcat.manager;

public interface Session {
    Manager getManager();
    
    void setManager(Manager manager);
    
    String getId();
    
    void setId(String id);
    
    void access();
    
    long getLastAccessedTime();
    
    boolean isValid();
    
    void setValid(boolean valide);
    
    void expire();
}
