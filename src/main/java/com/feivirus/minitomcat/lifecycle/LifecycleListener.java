package com.feivirus.minitomcat.lifecycle;

public interface LifecycleListener {
    void fireLifecycleEvent(LifecycleEvent event);
}
