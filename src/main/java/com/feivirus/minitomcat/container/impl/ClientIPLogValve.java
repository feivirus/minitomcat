package com.feivirus.minitomcat.container.impl;

import com.feivirus.minitomcat.base.HttpRequest;
import com.feivirus.minitomcat.base.HttpResponse;
import com.feivirus.minitomcat.pipeline.Valve;
import com.feivirus.minitomcat.pipeline.ValveContext;

public class ClientIPLogValve implements Valve{

    public void invoke(HttpRequest httpRequest, HttpResponse httpResponse, ValveContext valveContext) {
        System.out.println("记录客户端ip前");
        valveContext.invokeNext(httpRequest, httpResponse);
        System.out.println("记录客户端ip后");
    }    
}
