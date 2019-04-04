package com.feivirus.minitomcat.container.impl;

import com.feivirus.minitomcat.base.HttpRequest;
import com.feivirus.minitomcat.base.HttpResponse;
import com.feivirus.minitomcat.container.Contained;
import com.feivirus.minitomcat.container.Container;
import com.feivirus.minitomcat.container.Context;
import com.feivirus.minitomcat.container.Wrapper;
import com.feivirus.minitomcat.pipeline.Valve;
import com.feivirus.minitomcat.pipeline.ValveContext;

public class SimpleContextValve implements Valve, Contained {
    private Container container;    

    /**
     * 1.通过url的协议找到context的mapper
     * 2.通过mapper的context找到对应的servlet
     * 3.调用servlet的invoke
     */
    public void invoke(HttpRequest httpRequest, HttpResponse httpResponse, ValveContext valveContext) {
        Context context = (Context)getContainer();
        
        if (context.map(httpRequest) != null) {
            Wrapper wrapper = (Wrapper)context.map(httpRequest);
            wrapper.invoke(httpRequest, httpResponse);
        }        
    }

    public void setContainer(Container container) {
        this.container = container;
    }

    public Container getContainer() {
        return container;
    }

}
