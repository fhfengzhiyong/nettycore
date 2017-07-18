package com.straw.nettycore.c1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrator on 2017/7/14.
 */
public class TimeServer {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        if(args !=  null && args.length > 0){
            try {
                port = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("The time server is starting in port :"+ port);
            Socket socket = null;
            while (true){
                socket = serverSocket.accept();
                System.out.println("接受到新请求！");
                new Thread(new TimeServerHandler(socket)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (serverSocket != null){
                System.out.println("The time server close");
                serverSocket.close();
                serverSocket = null;
            }
        }

    }
}
