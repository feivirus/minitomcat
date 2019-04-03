package com.feivirus.minitomcat.container;

public interface Context extends Container {
    void addWrapper(Wrapper wrapper);
    
    Wrapper createWrapper();    
    
}
