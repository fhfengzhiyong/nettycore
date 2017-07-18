package com.straw.nettycore.c2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by fengzy on 7/14/2017.
 */
public class TimeServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = null;
        Socket socket = null;
        try {
            server = new ServerSocket(8080);
            TimeServerHanlderExecutePool executePool = new TimeServerHanlderExecutePool(50,100000);
            while (true){
                socket = server.accept();
                executePool.execute(new TimeServerHandler(socket));
            }
        } finally {
            if (server != null){
                server.close();
            }
            server = null;
        }
    }
}
