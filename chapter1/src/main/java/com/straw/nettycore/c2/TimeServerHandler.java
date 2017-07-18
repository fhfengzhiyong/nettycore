package com.straw.nettycore.c2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

/**
 * Created by Administrator on 2017/7/14.
 */
public class TimeServerHandler implements Runnable {
    Socket socket = null;

    public TimeServerHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        System.out.println("当前处理任务的线程是："+Thread.currentThread().getName());
        BufferedReader in = null;
        PrintWriter out = null;
        try{
            in = new BufferedReader(new InputStreamReader(this.socket.getInputStream(),"utf-8"));
            out = new PrintWriter(this.socket.getOutputStream(),true);
            String currentTime = null;
            String body = null;
            while (true){
                body = in.readLine();
                if (body == null){
                    break;
                }
                System.out.println("The time server receive order:"+body);
                currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body)?new Date(System.currentTimeMillis()).toString():"BAD ORDER";
                Thread.sleep(5000);
                out.println("this response is create by server:"+currentTime);
            }
        }catch (Exception e){
            e.printStackTrace();
            if (in != null){
                try {
                    in.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (out !=null){
                out.close();
                out = null;
            }
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                socket = null;
            }
        }
    }
}























































