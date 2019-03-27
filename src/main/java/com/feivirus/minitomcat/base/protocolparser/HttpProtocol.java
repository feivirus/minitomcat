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
     * TODO
     * private Cookie cookie;  
     */ 
}
