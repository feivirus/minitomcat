package com.feivirus.minitomcat.handlerchain;

public class HanlderTest2 implements Handler<HandlerContextTest>{

    public void handle(HandlerContextTest context) {      
        context.setValue("test2");
        System.out.print(context.getValue());
        if (context.getValue().equals("test2")) {
            context.setContinueNextHandler(false);
        }
    }
}
