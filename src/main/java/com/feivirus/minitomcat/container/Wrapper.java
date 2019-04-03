package com.feivirus.minitomcat.container;

import javax.servlet.Servlet;

public interface Wrapper extends Container{
    Servlet allocate();
}
