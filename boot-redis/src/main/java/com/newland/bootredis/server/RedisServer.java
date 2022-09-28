package com.newland.bootredis.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Author: leell
 * Date: 2022/9/28 13:29:48
 */
public class RedisServer {
    public static void main(String[] args) throws IOException {
        //创建本机端口6379的服务器
        ServerSocket serverSocket = new ServerSocket(6379);
        while (true) {
            Socket socket = serverSocket.accept();
            try{
                while(true){
                    //获取写进服务器的数据
                    InputStream inputStream = socket.getInputStream();
                    byte b[] = new byte[1024];
                    int length=inputStream.read(b);
                    System.out.println(new String(b,0,length));
                    System.out.println();
                    socket.getOutputStream().write("+OK".getBytes());
                    socket.getOutputStream().flush();
                }

//                socket.close();
            }catch (Exception e){

            }
        }
    }

}
