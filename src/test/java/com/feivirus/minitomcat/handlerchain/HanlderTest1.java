package com.feivirus.minitomcat.handlerchain;

public class HanlderTest1 implements Handler<HandlerContextTest>{

    public void handle(HandlerContextTest context) {
        context.setValue("test1");
        System.out.println(context.getValue());
    }
}
