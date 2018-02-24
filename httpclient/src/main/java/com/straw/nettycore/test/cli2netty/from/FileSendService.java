package com.straw.nettycore.test.cli2netty.from;

import com.straw.nettycore.test.cli2netty.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author fengzy
 * @date 2/24/2018
 */
public class FileSendService implements SendService<File> {

    @Override
    public void send(File file) throws URISyntaxException, IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        String host = "localhost:8045";
        //host = "www.cnblogs.com/mengrennwpu/p/6418114.html";
        URI uri = new URIBuilder().setHost(host).setScheme("http").build();
        HttpPost post = new HttpPost(uri);
        FileBody bin = new FileBody(file);

        StringBody comment = new StringBody("A binary file of some kind", ContentType.TEXT_PLAIN);
        HttpEntity reqEntity = MultipartEntityBuilder.create()
                .addPart("bin", bin)
                .addPart("comment", comment)
                .build();

        post.setEntity(reqEntity);
        HttpResponse response = httpClient.execute(post);
        System.out.println(response.getStatusLine().getStatusCode());
        String contentType = StringUtils.getCharsetFromContentType(response.getEntity().getContentType().getValue());
        String body = EntityUtils.toString(response.getEntity(), contentType);
        System.out.println(body);
        System.out.println("header message ------------------");
        for (Header header : response.getAllHeaders()) {
            System.out.println(header.getName() + " : " + header.getValue());
        }
    }
}
