package com.straw.nettycore.c1;

import java.io.*;
import java.net.Socket;

/**
 * Created by fengzy on 7/14/2017.
 */
public class TimeClient {
    public static void main(String[] args) {
        Integer threads = 1000000;
        for (int i=0;i<threads;i++){
            System.out.println("第"+i+"次循环");
            new Thread(new TimeClientThread(i)).start();
        }
    }

    static class TimeClientThread implements Runnable{
        int i;

        public TimeClientThread(int i) {
            this.i = i;
        }

        public void run() {
            Socket socket = null;
            BufferedReader in = null;
            PrintWriter out = null;
            try{
                socket = new Socket("localhost",8080);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(),true);
                out.println("QUERY TIME ORDER");
                String resp = in.readLine();
                System.out.println("this is "+i+" request:"+resp);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                if (in != null ){
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (out != null ){
                    out.close();
                }
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
