package com.example.grpc.service.impl;

import com.example.grpc.lib.GreeterGrpc;
import com.example.grpc.lib.GreeterOuterClass;
import com.example.grpc.service.IGrpcClientService;
import io.grpc.Channel;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class GrpcClientServiceImpl implements IGrpcClientService {

    @GrpcClient("local-grpc-server")
    private Channel serverChannel;

    /**
     * 通过本地存protocol buffer存根序列化后调用gRPC服务端
     *
     * @param name
     * @return
     */
    @Override
    public String sendMessage(String name) {
        GreeterGrpc.GreeterBlockingStub stub = GreeterGrpc.newBlockingStub(serverChannel);
        GreeterOuterClass.HelloReply response = stub.sayHello(GreeterOuterClass.HelloRequest.newBuilder().setName(name).build());
        return response.getMessage();
    }
}
