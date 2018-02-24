package com.straw.nettycore.httpclient.base;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHttpResponse;
import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author fengzy
 * @date 2/23/2018
 */
public class TestClient {

    @Test
    public void t1() throws URISyntaxException {
        String q = "httpclient";
        URI uri = new URIBuilder()
                .setHost("https://www.baidu.com/s")
                .setParameter("wd", q)
                .build();

        HttpGet httpGet = new HttpGet(uri);
        System.out.println(httpGet.getURI());
        System.out.println(httpGet.getURI().getHost());

        HttpResponse httpResponse = new BasicHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_OK, "OK");
        System.out.println(httpResponse.getProtocolVersion());
        httpResponse.addHeader("h1", "localhost");
        System.out.println(httpResponse.getFirstHeader("h1"));
        StringEntity stringEntity = new StringEntity("important message", ContentType.create("text/plain", "UTF-8"));
        System.out.println(stringEntity.getContentLength());
        System.out.println(stringEntity.getContentType());

    }
}
