package com.example.grpc.server;

import com.example.grpc.lib.GreeterGrpc;
import com.example.grpc.lib.GreeterOuterClass;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

@Slf4j
@GrpcService
public class GreeterService extends GreeterGrpc.GreeterImplBase {

    /**
     * gRPC Server started, listening on address: 0.0.0.0, port: 8800
     *
     * @param request
     * @param responseObserver
     */
    @Override
    public void sayHello(GreeterOuterClass.HelloRequest request, StreamObserver<GreeterOuterClass.HelloReply> responseObserver) {
        String message = "Hello " + request.getName();
        final GreeterOuterClass.HelloReply.Builder replyBuilder = GreeterOuterClass.HelloReply.newBuilder().setMessage(message);
        responseObserver.onNext(replyBuilder.build());
        responseObserver.onCompleted();
        log.info("Returning " + message);
    }
}