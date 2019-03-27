package com.feivirus.minitomcat.util;

public class BusinessConstant {
    /**
     * tomcat 端口号
     */
    public static final Integer PORT = 8080; 
    /**
     * 网络连接池排队数量
     */
    public static final Integer BACKUPLOG = 10;
    
    public static final String LOCAL_ADDRESS = "127.0.0.1";
    
    public static final String SERVLET_URL_PREFIX = "/servlet/";
    
    public static final Integer HTTP_REQUEST_SIZE = 2048;
    
    public static final int ZERO_VALUE = 0;
    
    public static final String TEST_REQUEST_URL = "http://localhost:8080/servlet/hello";
}
