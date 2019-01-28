package com.ribbon_balancer.ribbon_consume.consume_controller;

import com.ribbon_balancer.ribbon_consume.consume_service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumeController {

    @Autowired
    HelloService helloService;

    @RequestMapping(value = "/ribbon-consumer", method = RequestMethod.GET)
    public String consumeHello(){
        return helloService.helloService();
    }
}
