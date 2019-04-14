package com.feivirus.minitomcat.container.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;

import com.feivirus.minitomcat.base.HttpRequest;
import com.feivirus.minitomcat.base.HttpResponse;
import com.feivirus.minitomcat.container.Container;
import com.feivirus.minitomcat.container.Context;
import com.feivirus.minitomcat.container.Mapper;
import com.feivirus.minitomcat.container.Wrapper;
import com.feivirus.minitomcat.manager.Manager;
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
    
    /**
     * 不同协议对应的真正的mapper，这个mapper理解为真实的Context
     */
    private Map<String, Mapper> protocolMapper;
    
    private Manager manager;
    
    public SimpleContext() {
        pipeline.setBasic(new SimpleContextValve());
        if (children == null) {
            children = new HashMap<String, Container>();
        }
        if (servletMapping == null) {
            servletMapping = new HashMap<String, String>();
        }
        if (protocolMapper == null) {
            protocolMapper = new HashMap<String, Mapper>();
        }
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
        pipeline.addValve(valve);
    }

    public void removeValve(Valve valve) {
        // TODO Auto-generated method stub
        
    }

    public Valve getBasic() {
        return pipeline.getBasic();
    }

    public void setBasic(Valve valve) {
        pipeline.setBasic(valve);
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

    public void setName(String name) {
        // TODO Auto-generated method stub
        
    }

    public void addServletMapping(String url, String servletName) {
        servletMapping.put(url, servletName);
    }
    
    private Mapper findMapper(String protocol) {
        if (protocol == null) {
            return null;
        }
        return protocolMapper.get(protocol);
    }
    
    /**
     * 1.由协议找到mapper
     * 2.由mapper找到servlet
     * @param request
     * @return
     */
    public Container map(ServletRequest request) {
        HttpRequest httpRequest = (HttpRequest)request;
        Mapper mapper = findMapper(httpRequest.getHttpProtocol().getProtocol());
        
        return mapper.map(httpRequest);
    }

    public void addMapper(Mapper mapper) {
        mapper.setContainer(this);
        protocolMapper.put(mapper.getProtocol(), mapper);
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Container getContainer() {
        // TODO Auto-generated method stub
        return null;
    }

    public Container getParent() {
        // TODO Auto-generated method stub
        return null;
    }

    public Manager getManager() {
        return this.manager;
    }
    
    
}
