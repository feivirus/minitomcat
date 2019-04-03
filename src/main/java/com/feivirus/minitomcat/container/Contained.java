package com.feivirus.minitomcat.container;

public interface Contained {
    void setContainer(Container container);
    
    Container getContainer();
}
