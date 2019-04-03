package com.feivirus.minitomcat.connector;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import com.feivirus.minitomcat.container.Container;
import com.feivirus.minitomcat.enums.ErrorEnum;
import com.feivirus.minitomcat.protocolprocessor.HttpProcessor;
import com.feivirus.minitomcat.protocolprocessor.ProtocolProcessor;
import com.feivirus.minitomcat.util.BusinessConstant;

/**
 * 在connector还是endpoint层面,处理bio,aio,nio问题, is a quetion
 * @author feivirus
 *
 */
public class HttpConnector implements Runnable, Connector{    
    /**
     * 连接超时时间
     */
    private Integer timeout;
    
    /**
     * 停止
     */
    private boolean stoped = false;
    
    private Container container;    
    
    public void start() {       
        Thread thread = new Thread(this);
        thread.start();
    }       
    
    /**
     * 创建socket,接受连接
     */
    public void run() {
        ServerSocket serverSocket = null;
        try {
            InetAddress address = InetAddress.getByName(BusinessConstant.LOCAL_ADDRESS);
            
            serverSocket = new ServerSocket(BusinessConstant.PORT,
                    BusinessConstant.BACKUPLOG,
                    address);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(ErrorEnum.SOCKET_ERROR.getCode());
        }
        
        while(!stoped) {
            Socket socket = null;
            
            try {
                socket = serverSocket.accept();               
            } catch (IOException e) {
                e.printStackTrace();
            }        
            
            //TODO 这里通过IOC注入
            ProtocolProcessor processor = new HttpProcessor(this);
            processor.process(socket);           
        }
    }
    
    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public void setContainer(Container container) {
        this.container = container;
    }

    public Container getContainer() {
        return container;
    }    
}
