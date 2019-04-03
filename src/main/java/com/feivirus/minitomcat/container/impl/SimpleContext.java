package com.feivirus.minitomcat.container.impl;

import java.util.Map;

import com.feivirus.minitomcat.base.HttpRequest;
import com.feivirus.minitomcat.base.HttpResponse;
import com.feivirus.minitomcat.container.Container;
import com.feivirus.minitomcat.container.Context;
import com.feivirus.minitomcat.container.Wrapper;
import com.feivirus.minitomcat.pipeline.Pipeline;
import com.feivirus.minitomcat.pipeline.Valve;

public class SimpleContext implements Context, Pipeline {
    private Pipeline pipeline = new SimplePipeline(this);
    
    /**
     * url对应的servlet name
     */
    private Map<String, String> servletMapping;
    
    /**
     * servlet的name对应的wrapper
     */
    private Map<String, Container> children;
    
    public SimpleContext() {
        pipeline.setBasic(new SimpleContextValve());
    }

    public void addWrapper(Wrapper wrapper) {
        
    }

    public Wrapper createWrapper() {
        return null;
    }

    public void addChild(Container container) {
        container.setParent(this);
        children.put(container.getName(), container);
    }

    /**
     * 找到包含的servlet
     */
    public Container findChild(String name) {        
        return children.get(name);
    }

    public Container[] findChildren() {
        return null;
    }

    public void removeChild(Container container) {
        // TODO Auto-generated method stub
        
    }

    public void invoke(HttpRequest httpRequest, HttpResponse httpResponse) {
        pipeline.invoke(httpRequest, httpResponse);
    }

    public void addValve(Valve valve) {
        // TODO Auto-generated method stub
        
    }

    public void removeValve(Valve valve) {
        // TODO Auto-generated method stub
        
    }

    public Valve getBasic() {
        // TODO Auto-generated method stub
        return null;
    }

    public void setBasic(Valve valve) {
        // TODO Auto-generated method stub
        
    }        
    
    public String findServletMapping(String url) {
        return servletMapping.get(url);
    }

    public void setParent(Container container) {
        // TODO Auto-generated method stub
        
    }

    public String getName() {
        // TODO Auto-generated method stub
        return null;
    }
}
