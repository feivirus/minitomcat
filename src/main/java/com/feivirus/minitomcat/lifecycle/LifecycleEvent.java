package com.feivirus.minitomcat.lifecycle;

import java.util.EventObject;

public class LifecycleEvent extends EventObject {
    //事件目标
    private Object target;
    
    private String type;
    
    public LifecycleEvent(Object source, String type, Object target) {
        super(source);
        this.type = type;
        this.target = target;
    }
    
    
}
