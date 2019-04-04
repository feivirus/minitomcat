package com.feivirus.minitomcat.container;

import javax.servlet.ServletRequest;

public interface Mapper {
    String getProtocol();
    
    void setProtocol(String protocol);
    
    Container getContainer();
    
    void setContainer(Container container);
    
    Container map(ServletRequest request);
}
