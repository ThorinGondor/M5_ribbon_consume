package com.ribbon_balancer.ribbon_consume.consume_service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloServiceFallback")
    public String helloService(){
        return restTemplate.getForEntity("http://HELLO-SERVICE-CLUSTER/hello", String.class).getBody();
    }

    //发生服务降级时，Hystrix回调该函数
    public String helloServiceFallback(){
        return "Client Service Unavailable! Error!";
    }
}
