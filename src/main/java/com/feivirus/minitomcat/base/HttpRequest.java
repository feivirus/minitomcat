package com.feivirus.minitomcat.base;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletRequest;

import com.feivirus.minitomcat.base.protocolparser.HttpParser;
import com.feivirus.minitomcat.base.protocolparser.HttpProtocol;
import com.feivirus.minitomcat.util.BusinessConstant;

import lombok.Data;

/**
 *TODO 实现HttpServletRequest ,参考 Servlet规范
 * @author feivirus
 *
 */
@Data
public class HttpRequest implements ServletRequest{
    /**
     * http请求的输入流
     */
    private InputStream inputStream;
    
    
    /**
     * Http的协议内容
     */
    private HttpProtocol httpProtocol;
    
    
    public HttpRequest(InputStream inputStream) {
        this.inputStream = inputStream;
    }
    
    public void parse() {
        byte[] buffer = new byte[BusinessConstant.HTTP_REQUEST_SIZE];
        int size = 0;
        
        try {
            size = inputStream.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        if (size == BusinessConstant.ZERO_VALUE) {
            return;
        }        
        
        StringBuffer stringBuffer = new StringBuffer();
        
        for(int i = 0; i < size; i++) {
            stringBuffer.append((char)buffer[i]);
        }
       
        internalParse(stringBuffer);
    }
    
    public void internalParse(StringBuffer buffer) {
        HttpParser parser = new HttpParser();
        
        httpProtocol = parser.parse(buffer.toString());
    }
}
