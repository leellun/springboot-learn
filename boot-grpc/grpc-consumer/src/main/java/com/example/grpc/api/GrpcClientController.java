package com.example.grpc.api;


import com.example.grpc.service.IGrpcClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GrpcClientController {

    @Autowired
    private IGrpcClientService grpcClientService;

    /**
     * Testing
     *
     * @param name
     * @return
     */
    @RequestMapping("/")
    public String printMessage(@RequestParam(defaultValue = "ipman") String name) {
        return grpcClientService.sendMessage(name);
    }
}