package com.feivirus.minitomcat.base;

import java.io.OutputStream;

import javax.servlet.ServletResponse;

import lombok.Data;

@Data
public class HttpResponse implements ServletResponse{
    private OutputStream outputStream;
    
    public HttpResponse(OutputStream outputStream) {
        this.outputStream = outputStream;
    }
}
