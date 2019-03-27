package com.feivirus.minitomcat.requestprocessor;

import com.feivirus.minitomcat.base.HttpRequest;
import com.feivirus.minitomcat.base.HttpResponse;

/**
 * 
 * @author feivirus
 *
 */
@FunctionalInterface
public interface RequestProcessor {
    public void process(HttpRequest httpRequest, HttpResponse httpResponse);
}
