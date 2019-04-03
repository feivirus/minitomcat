package com.feivirus.minitomcat.pipeline;

import com.feivirus.minitomcat.base.HttpRequest;
import com.feivirus.minitomcat.base.HttpResponse;

public interface Valve {
    void invoke(HttpRequest httpRequest, HttpResponse httpResponse, ValveContext valveContext);
}
