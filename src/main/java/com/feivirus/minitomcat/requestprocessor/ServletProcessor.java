package com.feivirus.minitomcat.requestprocessor;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.feivirus.minitomcat.base.HttpRequest;
import com.feivirus.minitomcat.base.HttpResponse;

public class ServletProcessor implements RequestProcessor {

    /**
     * 1.解析servlet name
     * 2.调用classloader 装载 servlet
     * 3. 调用servlet的service方法
     * 
     * 
     */
    public void process(HttpRequest httpRequest, HttpResponse httpResponse) {
        System.out.print("请求servlet处理: " + httpRequest);
        URL[] urls = new URL[1];
        URLClassLoader urlClassLoader = new URLClassLoader(urls);
        String servletName = "PrimitiveServlet";
        Class servletClass = null;
        Servlet servlet = null;
        
        try {
            servletClass = urlClassLoader.loadClass(servletName);
            servlet = (Servlet)servletClass.newInstance();
            servlet.service((ServletRequest)httpRequest, (ServletResponse)httpResponse);
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }    
   
}
