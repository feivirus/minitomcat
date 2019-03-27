package com.feivirus.minitomcat.base.protocolparser;

import com.feivirus.minitomcat.util.BusinessConstant;
import com.feivirus.minitomcat.util.Parser;

public class HttpParser implements Parser<String, HttpProtocol>{

    public HttpProtocol parse(String value) {
        System.out.println("http请求内容: " + value);
        HttpProtocol httpProtocol = new HttpProtocol();
        
        httpProtocol.setUrl(BusinessConstant.TEST_REQUEST_URL);
        return httpProtocol;
    } 

}
