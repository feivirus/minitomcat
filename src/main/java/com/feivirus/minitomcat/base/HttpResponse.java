package com.feivirus.minitomcat.base;

import java.io.OutputStream;

import lombok.Data;

@Data
public class HttpResponse {
    private OutputStream outputStream;
    
    public HttpResponse(OutputStream outputStream) {
        this.outputStream = outputStream;
    }
}
