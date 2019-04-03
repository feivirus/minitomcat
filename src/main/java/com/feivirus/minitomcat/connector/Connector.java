package com.feivirus.minitomcat.connector;

import com.feivirus.minitomcat.container.Container;

public interface Connector {
    void setContainer(Container container);
    
    Container getContainer();
}
