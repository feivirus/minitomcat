package com.feivirus.minitomcat.handlerchain;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import lombok.Data;

@Data
public class HandlerChainImpl<T extends HandlerContext> implements HandlerChain<T> {

    private Lock lock;

    private HandlerNode<T> head;

    private HandlerNode<T> tail;

    public HandlerChainImpl() {
        lock = new ReentrantLock();
    }

    public void startHandle(T context) {
        lock.lock();
        HandlerNode<T> node = head;

        while (node != null) {
            Handler<T> handler = node.getHandler();

            handler.handle(context);
            if (!context.continueNextHandle()) {
               break;
            } 
            node = node.getNextHandlerNode();
        }

        lock.unlock();
    }

    public void addHandler(Handler<T> handler) {
        lock.lock();

        if (head == null) {
            head = new HandlerNode<T>();
            head.setHandler(handler);
            head.setNextHandlerNode(null);
            tail = head;
        } else {
            HandlerNode<T> node = new HandlerNode<T>();
            node.setHandler(handler);

            tail.setNextHandlerNode(node);
            tail = node;
        }
        lock.unlock();
    }

    /**
     * 删除节点 TODO
     */
    public void removeHandler(Handler<T> handler) {
        lock.lock();
        if (head != null) {

        }

        lock.unlock();
    }

}
