package com.feivirus.minitomcat.container;

import com.feivirus.minitomcat.base.HttpRequest;
import com.feivirus.minitomcat.base.HttpResponse;

public interface Container {
    void addChild(Container container);
    
    Container findChild(String name);
    
    Container[] findChildren();
    
    void removeChild(Container container);
    
    void invoke(HttpRequest httpRequest, HttpResponse httpResponse);
    
    void setParent(Container container);
    
    String getName();
    
    void setName(String name);
}
