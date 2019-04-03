package com.feivirus.minitomcat;

import com.feivirus.minitomcat.connector.HttpConnector;
import com.feivirus.minitomcat.container.Context;
import com.feivirus.minitomcat.container.Wrapper;
import com.feivirus.minitomcat.container.impl.ClientIPLogValve;
import com.feivirus.minitomcat.container.impl.SimpleContext;
import com.feivirus.minitomcat.container.impl.SimpleWrapper;
import com.feivirus.minitomcat.pipeline.Pipeline;
import com.feivirus.minitomcat.pipeline.Valve;

public class Bootstrap {
    public static void main(String[] args) {
        System.out.println("Tomcat starting ");
        
        HttpConnector connector = new HttpConnector();
        
//        Wrapper wrapper = new SimpleWrapper();
//        Valve clientIPLogValve = new ClientIPLogValve();
//        Pipeline wrapperPipeline = (Pipeline)wrapper;
//        wrapperPipeline.addValve(clientIPLogValve);        
//        connector.setContainer(wrapper);
        
        Context context = new SimpleContext();
        
        
        
        connector.start();
    }
}
