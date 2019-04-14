package com.feivirus.minitomcat;

import com.feivirus.minitomcat.connector.HttpConnector;
import com.feivirus.minitomcat.container.Context;
import com.feivirus.minitomcat.container.Mapper;
import com.feivirus.minitomcat.container.Wrapper;
import com.feivirus.minitomcat.container.impl.ClientIPLogValve;
import com.feivirus.minitomcat.container.impl.SimpleContext;
import com.feivirus.minitomcat.container.impl.SimpleContextMapper;
import com.feivirus.minitomcat.container.impl.SimpleWrapper;
import com.feivirus.minitomcat.manager.Manager;
import com.feivirus.minitomcat.manager.StandardManager;
import com.feivirus.minitomcat.pipeline.Pipeline;
import com.feivirus.minitomcat.pipeline.Valve;

/**
 * TODO
 * 1.manager(session,cookie)
 * 2.log
 * 3.detailed lifecycle
 * 4.class loader
 * 5. multi io model support
 * @author feivirus
 *
 */
public class Bootstrap {
    public static void main(String[] args) {
        System.out.println("Tomcat starting ");
        
        HttpConnector connector = new HttpConnector();
        
        /**   
        Wrapper wrapper = new SimpleWrapper();
        Valve clientIPLogValve = new ClientIPLogValve();
        Pipeline wrapperPipeline = (Pipeline)wrapper;
        wrapperPipeline.addValve(clientIPLogValve);        
        connector.setContainer(wrapper);
        */
        
        Wrapper wrapper1 = new SimpleWrapper();
        wrapper1.setName("servlet1");              
        Wrapper wrapper2 = new SimpleWrapper();
        wrapper2.setName("servlet2");
        
        Context context = new SimpleContext();        
        context.addChild(wrapper1);
        context.addChild(wrapper2);
        Valve clientIPLogValve = new ClientIPLogValve();
        ((Pipeline)context).addValve(clientIPLogValve);        
        context.addServletMapping("/servlet1", "servlet1");
        context.addServletMapping("/servlet2", "servlet2");    
        
        Mapper mapper = new SimpleContextMapper();
        mapper.setProtocol("http");
        context.addMapper(mapper);
        
        Manager manager = new StandardManager();
        context.setManager(manager);
        
        connector.setContainer(context);
        connector.start();
    }
}
