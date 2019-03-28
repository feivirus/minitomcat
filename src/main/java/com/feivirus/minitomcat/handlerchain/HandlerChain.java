package com.feivirus.minitomcat.handlerchain;

/**
 * 
 * @author feivirus
 *
 */
public interface HandlerChain<T extends HandlerContext> {
    void startHandle(T context);
    
    void addHandler(Handler<T> handler);
    
    void removeHandler(Handler<T> handler);
}
