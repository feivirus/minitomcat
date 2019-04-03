package com.feivirus.minitomcat.container.impl;

import com.feivirus.minitomcat.base.HttpRequest;
import com.feivirus.minitomcat.base.HttpResponse;
import com.feivirus.minitomcat.pipeline.Valve;
import com.feivirus.minitomcat.pipeline.ValveContext;

import lombok.Data;

@Data
public class StandardValveContext implements ValveContext {    
    /**
     * 管道位置
     */
    private Integer stage;   
    
    protected Valve[] valves;
    
    protected Valve basicValve;
    
    
    
    public void invokeNext(HttpRequest httpRequest, HttpResponse httpResponse) {
        int subscript = stage;
        
        stage++;
        
        if (subscript < valves.length) {
            valves[subscript].invoke(httpRequest, httpResponse, this);
        } else if (subscript == valves.length && basicValve != null) {
            basicValve.invoke(httpRequest, httpResponse, this);
        }        
    }        
}
