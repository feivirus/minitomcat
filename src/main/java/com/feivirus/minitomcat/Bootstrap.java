package com.feivirus.minitomcat;

import com.feivirus.minitomcat.connector.Connector;

public class Bootstrap {
    public static void main(String[] args) {
        System.out.println("Tomcat starting ");
        
        Connector connector = new Connector();
        connector.start();
    }
}
