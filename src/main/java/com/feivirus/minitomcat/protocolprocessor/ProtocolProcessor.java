package com.feivirus.minitomcat.protocolprocessor;

import java.net.Socket;

@FunctionalInterface
public interface ProtocolProcessor {
    public void process(Socket socket);
}
