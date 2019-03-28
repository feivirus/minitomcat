package com.feivirus.minitomcat.handlerchain;

import lombok.Data;

@Data
public class HandlerNode<T extends HandlerContext> {
    
    private Handler<T> handler;
    
    private HandlerNode<T> nextHandlerNode;
}
