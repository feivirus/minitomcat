package com.feivirus.minitomcat.container;

import com.feivirus.minitomcat.base.HttpRequest;
import com.feivirus.minitomcat.base.HttpResponse;
import com.feivirus.minitomcat.manager.Manager;

public interface Container {
    void addChild(Container container);
    
    Container findChild(String name);
    
    Container[] findChildren();
    
    void removeChild(Container container);
    
    void invoke(HttpRequest httpRequest, HttpResponse httpResponse);
    
    Container getContainer();
    
    Container getParent();
    
    void setParent(Container container);
    
    String getName();
    
    void setName(String name);
    
    void setManager(Manager manager);
    
    Manager getManager();
}
