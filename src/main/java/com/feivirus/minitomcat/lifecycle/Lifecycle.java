package com.feivirus.minitomcat.lifecycle;

public interface Lifecycle {
    void start();
    
    void stop();
    
    void addListener(LifecycleListener lifecycleListener);
    
    void removeListener(LifecycleListener lifecycleListener);
    
    LifecycleListener[] findListeners();
}
