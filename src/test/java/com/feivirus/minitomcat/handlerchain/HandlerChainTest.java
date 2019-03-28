package com.feivirus.minitomcat.handlerchain;

import org.junit.Test;

public class HandlerChainTest {
    @Test
    public void testHandlerChain() {
        HandlerChain<HandlerContextTest> handlerChain = new HandlerChainImpl<HandlerContextTest>();
        
        Handler<HandlerContextTest> handler1 = buildHandlerTest1(1);
        Handler<HandlerContextTest> handler2 = buildHandlerTest1(2);
        Handler<HandlerContextTest> handler3 = buildHandlerTest1(2);
        
        handlerChain.addHandler(handler1);
        handlerChain.addHandler(handler2); 
        handlerChain.addHandler(handler3);
        
        HandlerContextTest  context = new HandlerContextTest();
        
        handlerChain.startHandle(context);
    }
    
    public Handler<HandlerContextTest> buildHandlerTest1(int order) {
        Handler<HandlerContextTest> handler = null;
        
        if (order == 1) {
            handler = new HanlderTest1();
        }
        if (order == 2) {
            handler = new HanlderTest2();
        }       
        return handler;
    }
}
