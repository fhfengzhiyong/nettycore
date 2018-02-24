package com.straw.nettycore.test.cli2netty.from;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * 发送一个zip文件到nerry的服务器,使用http协议
 *
 * @author fengzy
 * @date 2/24/2018
 */
public class Client {
    public static void main(String[] args) throws IOException, URISyntaxException {
        SendService<File> send = new FileSendService();
        File file = new File("D:\\utf.zip");
        send.send(file);
    }
}
