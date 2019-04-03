package com.feivirus.minitomcat.pipeline;

import com.feivirus.minitomcat.base.HttpRequest;
import com.feivirus.minitomcat.base.HttpResponse;

public interface Pipeline {
    void invoke(HttpRequest httpRequest, HttpResponse httpResponse);
    
    void addValve(Valve valve);
    
    void removeValve(Valve valve);
    
    Valve getBasic();
    
    void setBasic(Valve valve);
}
