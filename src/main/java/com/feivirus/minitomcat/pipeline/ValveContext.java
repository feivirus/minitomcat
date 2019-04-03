package com.feivirus.minitomcat.pipeline;

import com.feivirus.minitomcat.base.HttpRequest;
import com.feivirus.minitomcat.base.HttpResponse;

public interface ValveContext {
    void invokeNext(HttpRequest httpRequest, HttpResponse httpResponse);
}
