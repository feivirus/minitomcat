package com.feivirus.minitomcat.lifecycle;

public class LifecycleSupport {
    private Lifecycle lifecycle;
    
    private LifecycleListener listeners[] = new LifecycleListener[0];
    
    public LifecycleSupport(Lifecycle lifecycle) {
        this.lifecycle = lifecycle;
    }
    
    public void addListener(LifecycleListener lifecycleListener) {
        synchronized(listeners) {
            LifecycleListener[] result = new LifecycleListener[listeners.length + 1];
            for(int i = 0; i < listeners.length; i++) {
                result[i] = listeners[i];
            }
            result[listeners.length] = lifecycleListener;
            listeners = result;
        }
    }
    
    public void removeListener(LifecycleListener lifecycleListener) {
        
    }
    
    public LifecycleListener[] findListeners() {
        return listeners;
    }
    
    public void fireLifecycleEvent(String type, Object target) {
        LifecycleEvent lifecycleEvent = new LifecycleEvent(lifecycle, type, target);
        LifecycleListener[] interested = null;
        
        synchronized(listeners) {
            interested = listeners.clone();
        }
        for (LifecycleListener listener : interested) {
            listener.fireLifecycleEvent(lifecycleEvent);
        }
    }

}
