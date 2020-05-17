package com.xupt.read.pageCapture;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

/**
 * @description： http客户端管理器
 */
public class HttpClientManger {
    private static CloseableHttpClient httpClient = HttpClients.createDefault();

    public static CloseableHttpClient getHttpClient(){
        return httpClient;
    }

    public static void closeClient(){
        if(httpClient != null){
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
