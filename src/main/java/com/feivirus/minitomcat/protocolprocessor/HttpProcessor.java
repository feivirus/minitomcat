package com.feivirus.minitomcat.protocolprocessor;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import com.feivirus.minitomcat.base.HttpRequest;
import com.feivirus.minitomcat.base.HttpResponse;
import com.feivirus.minitomcat.connector.Connector;
import com.feivirus.minitomcat.requestprocessor.RequestProcessor;
import com.feivirus.minitomcat.requestprocessor.ServletProcessor;
import com.feivirus.minitomcat.requestprocessor.StaticResourceProcessor;
import com.feivirus.minitomcat.util.BusinessConstant;

/**
 * tomcat通过适配器模式处理不同协议?
 * 
 * @author feivirus
 *
 */
public class HttpProcessor implements ProtocolProcessor {
    private Connector connector;
    
    public HttpProcessor(Connector connector) {
        this.connector = connector;
    }

    /**
     * 解析http报文，转发给响应的资源处理器
     */
    public void process(Socket socket) {
        try {
            HttpRequest httpRequest = new HttpRequest(socket.getInputStream());
            HttpResponse httpResponse  = new HttpResponse(socket.getOutputStream());
            
            httpRequest.parse();
            RequestProcessor requestProcessor = buildRequestProcessor(httpRequest.getHttpProtocol().getUrl());            
          
           requestProcessor.process(httpRequest, httpResponse);                        
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    /**
     * 根据url获取对应的servlet处理类
     * @param url
     * @return
     */
    private RequestProcessor buildRequestProcessor(String url) {
        if (url.contains(BusinessConstant.SERVLET_URL_PREFIX)) {
            return new ServletProcessor();
        } else {
            return new StaticResourceProcessor();
        }
    }

}
