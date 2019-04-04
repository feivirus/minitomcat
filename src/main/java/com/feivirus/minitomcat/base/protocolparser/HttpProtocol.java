package com.feivirus.minitomcat.base.protocolparser;

import lombok.Data;

@Data
public class HttpProtocol {
    /**
     * {@link com.feivirus.minitomcat.enums.RequstMethodEnum}
     */
    private String requestMethod;
    
    
    private String url;
    
    /**
     * http/https
     */
    private String protocol;
    
    /**
     * TODO
     * private Cookie cookie;  
     */ 
}
