package com.feivirus.minitomcat.container.impl;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import com.feivirus.minitomcat.base.HttpRequest;
import com.feivirus.minitomcat.base.HttpResponse;
import com.feivirus.minitomcat.container.Contained;
import com.feivirus.minitomcat.container.Container;
import com.feivirus.minitomcat.pipeline.Valve;
import com.feivirus.minitomcat.pipeline.ValveContext;

public class SimpleWrapperValve implements Valve, Contained{
    private Container container;

    public void setContainer(Container container) {
        this.container = container;
    }

    public Container getContainer() {
        return container;
    }

    public void invoke(HttpRequest httpRequest, HttpResponse httpResponse, ValveContext valveContext) {
        SimpleWrapper simpleWrapper = (SimpleWrapper)getContainer();
        Servlet servlet = simpleWrapper.allocate();
        
        try {
            System.out.println("简单servlet处理");
            if (servlet != null) {
                servlet.service(httpRequest, httpResponse);
            }
        } catch (ServletException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
