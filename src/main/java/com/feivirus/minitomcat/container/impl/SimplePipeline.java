package com.feivirus.minitomcat.container.impl;

import com.feivirus.minitomcat.base.HttpRequest;
import com.feivirus.minitomcat.base.HttpResponse;
import com.feivirus.minitomcat.container.Contained;
import com.feivirus.minitomcat.container.Container;
import com.feivirus.minitomcat.pipeline.Pipeline;
import com.feivirus.minitomcat.pipeline.Valve;
import com.feivirus.minitomcat.pipeline.ValveContext;

import lombok.Data;

@Data
public class SimplePipeline implements Pipeline {
    protected Valve[] valves;
    
    protected Valve basicValve;
    
    protected Container container;

    public SimplePipeline(Container container) {
        valves = new Valve[0];
        setContainer(container);
    }
    
    public void invoke(HttpRequest httpRequest, HttpResponse httpResponse) {
        ValveContext valveContext = new SimplePipelineContext();
        
        valveContext.invokeNext(httpRequest, httpResponse);
    }

    public void addValve(Valve valve) {
        synchronized (valves) {
            Valve[] result = new Valve[valves.length + 1];
            System.arraycopy(valves, 0, result, 0, valves.length);
            result[valves.length] = valve;
            valves = result;
        }
    }

    public void removeValve(Valve valve) {
        // TODO Auto-generated method stub
        
    }

    public Valve getBasic() {
        return basicValve;
    }

    public void setBasic(Valve valve) {
        this.basicValve = valve;
        ((Contained)valve).setContainer(container);
    }
    
    /**
     * 巧妙的设计，内部类实现context
     * @author feivirus
     *
     */
    public class SimplePipelineContext implements ValveContext{
        int stage = 0;
        
        public void invokeNext(HttpRequest httpRequest, HttpResponse httpResponse) {
            int subscript = stage;
            
            stage++;
            
            if (subscript < valves.length) {
                valves[subscript].invoke(httpRequest, httpResponse, this);
            } else if (subscript == valves.length && basicValve != null) {
                basicValve.invoke(httpRequest, httpResponse, this);
            }        
        }        
    }
}
