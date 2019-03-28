package com.feivirus.minitomcat.handlerchain;

public interface Handler<T extends HandlerContext> {
    void handle(T context);
}
