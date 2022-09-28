package com.newland.bootredis.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

/**
 * Author: leell
 * Date: 2022/9/28 13:29:48
 */
public class RedisClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("localhost", 6379);
        while (true) {
            //创建一个流套接字并将其连接到指定主机上的指定端口号


            //读取服务器端数据
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //向服务器端发送数据
            PrintStream out = new PrintStream(socket.getOutputStream());
            System.out.print("请输入: \t");
            String content = new BufferedReader(new InputStreamReader(System.in)).readLine();
            String[] strs = content.split("\\s");
            StringBuilder sb=new StringBuilder();
            sb.append("*");
            sb.append(strs.length);
            Arrays.stream(strs).forEach(str->{
                sb.append(System.lineSeparator());
                sb.append("$");
                sb.append(str.length());
                sb.append(System.lineSeparator());
                sb.append(str);
            });
            out.println(sb.toString());
            out.flush();
            String ret = input.readLine();
            System.out.println("服务器端返回过来的是: " + ret);
        }
    }

}
