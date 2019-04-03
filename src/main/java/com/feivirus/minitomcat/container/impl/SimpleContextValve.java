package com.feivirus.minitomcat.container.impl;

import com.feivirus.minitomcat.base.HttpRequest;
import com.feivirus.minitomcat.base.HttpResponse;
import com.feivirus.minitomcat.pipeline.Valve;
import com.feivirus.minitomcat.pipeline.ValveContext;

public class SimpleContextValve implements Valve {

    public void invoke(HttpRequest httpRequest, HttpResponse httpResponse, ValveContext valveContext) {
        valveContext.invokeNext(httpRequest, httpResponse);
    }

}
