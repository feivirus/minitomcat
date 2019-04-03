package com.feivirus.minitomcat.container.impl;

import javax.servlet.Servlet;

import com.feivirus.minitomcat.base.HttpRequest;
import com.feivirus.minitomcat.base.HttpResponse;
import com.feivirus.minitomcat.container.Container;
import com.feivirus.minitomcat.container.Wrapper;
import com.feivirus.minitomcat.pipeline.Pipeline;
import com.feivirus.minitomcat.pipeline.Valve;

public class SimpleWrapper implements Wrapper, Pipeline {
    private Pipeline pipeline;
    
    public SimpleWrapper() {
        pipeline = new SimplePipeline(this);
        pipeline.setBasic(new SimpleWrapperValve());
    }

    public void invoke(HttpRequest httpRequest, HttpResponse httpResponse) {
        pipeline.invoke(httpRequest, httpResponse);
    }

    public void addValve(Valve valve) {
        pipeline.addValve(valve);
    }

    public void removeValve(Valve valve) {
        pipeline.removeValve(valve);
    }

    public Valve getBasic() {
        return pipeline.getBasic();
    }

    public void setBasic(Valve valve) {
        pipeline.setBasic(valve);
    }

    public void addChild(Container container) {
        // TODO Auto-generated method stub
        
    }

    public Container findChild(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    public Container[] findChildren() {
        // TODO Auto-generated method stub
        return null;
    }

    public void removeChild(Container container) {
        // TODO Auto-generated method stub
        
    }

    public Servlet allocate() {
        // TODO Auto-generated method stub
        return null;
    }

    public void setParent(Container container) {
        // TODO Auto-generated method stub
        
    }

    public String getName() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
