package com.feivirus.minitomcat.requestprocessor;

import com.feivirus.minitomcat.base.HttpRequest;
import com.feivirus.minitomcat.base.HttpResponse;

public class ServletProcessor implements RequestProcessor {

    /**
     * 1.解析servlet name
     * 2.调用classloader 装载 servlet
     * 3. 调用servlet的service方法
     */
    public void process(HttpRequest httpRequest, HttpResponse httpResponse) {
        System.out.print("请求servlet处理: " + httpRequest);
    }    
   
}
