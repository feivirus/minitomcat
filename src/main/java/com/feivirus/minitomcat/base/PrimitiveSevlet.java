package com.feivirus.minitomcat.base;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class PrimitiveSevlet implements Servlet{

    public void init(ServletConfig config) {
        System.out.println("Servlet初始化");
    }

    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("请求servlet的service方法");
    }

}
