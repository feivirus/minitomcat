package com.feivirus.minitomcat.container;

public interface Mapper {
    String getProtocol();
    
    void setProtocol(String protocol);
    
    Container getContainer();
    
    void setContainer(Container container);
}
