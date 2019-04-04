package com.feivirus.minitomcat.container;

import javax.servlet.ServletRequest;

public interface Context extends Container {
    void addWrapper(Wrapper wrapper);
    
    Wrapper createWrapper();    
    
    void addServletMapping(String url, String servletName);
    
    void addMapper(Mapper mapper);
    
    Container map(ServletRequest request);
}
