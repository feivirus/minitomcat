package com.feivirus.minitomcat.container.impl;

import javax.servlet.ServletRequest;

import com.feivirus.minitomcat.base.HttpRequest;
import com.feivirus.minitomcat.container.Container;
import com.feivirus.minitomcat.container.Mapper;
import com.feivirus.minitomcat.container.Wrapper;

public class SimpleContextMapper implements Mapper {
    private String protocol;
    
    private SimpleContext context;

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public Container getContainer() {
        return context;
    }

    public void setContainer(Container container) {
        if (container instanceof SimpleContext) {
            this.context = (SimpleContext) container;
        }
    }
    
    /**
     * 根据servlet-mapping的url到servlet的映射
     * @param request
     * @return
     */
    public Container map(ServletRequest request) {
        HttpRequest httpRequest = (HttpRequest)request;
        String url = httpRequest.getHttpProtocol().getUrl();
        String servletName = context.findServletMapping(url);
        
        if (servletName != null) {
            Wrapper wrapper = (Wrapper)context.findChild(servletName);
            return wrapper;
        }
        return null;
    }
    
}
