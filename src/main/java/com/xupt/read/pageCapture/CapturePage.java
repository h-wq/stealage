package com.xupt.read.pageCapture;

import com.xupt.read.agentManger.AgentManger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

/**
 * @description：   页面抓取
 */
public class CapturePage {
    private static String USER_AGENT = "User-Agent";
    private static AgentManger agentManger = new AgentManger();

    public static String getHtml(String url){
        String agent = agentManger.getUserAgent();
        //1.生成httpclient，相当于该打开一个浏览器
        CloseableHttpClient httpClient = HttpClientManger.getHttpClient();
        CloseableHttpResponse response = null;
        //2.创建get请求，相当于在浏览器地址栏输入 网址
        HttpGet request = new HttpGet(url);
        try {
            //3.执行get请求，相当于在输入地址栏后敲回车键
            request.setHeader(USER_AGENT,agent);
            response = httpClient.execute(request);

            //4.判断响应状态为200，进行处理
            if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                //5.获取响应内容
                HttpEntity httpEntity = response.getEntity();
                String html = EntityUtils.toString(httpEntity, "utf-8");

                return html;
            } else {
                //如果返回状态不是200，比如404（页面不存在）等，根据情况做处理，这里略
                System.out.println("返回状态不是200");
                System.out.println(EntityUtils.toString(response.getEntity(), "utf-8"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            //6.关闭
            HttpClientUtils.closeQuietly(response);
        }

        return null;
    }
}
