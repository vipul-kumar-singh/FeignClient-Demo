package com.FeignDemo;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name = "Zuul")
public interface RemoteCallService {
    @RequestMapping(method = RequestMethod.GET, value = "/producer/employee")
    public Employee getData();

    @RequestMapping(method = RequestMethod.GET, value = "/myservice/hello")
    public String hello();

}