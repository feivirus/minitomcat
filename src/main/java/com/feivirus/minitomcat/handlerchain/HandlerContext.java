package com.feivirus.minitomcat.handlerchain;

public interface HandlerContext {
    String UUID();
    
    /**
     * 是否继续下一个处理
     * @return
     */
    boolean continueNextHandle();
}
