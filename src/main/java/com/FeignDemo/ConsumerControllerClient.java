package com.FeignDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestClientException;

import java.io.IOException;


@Controller
public class ConsumerControllerClient {

    @Autowired
    private RemoteCallService loadBalancer;

    public void getEmployee() throws RestClientException, IOException {

        try {
            Employee emp = loadBalancer.getData();
            System.out.println(emp.toString());

            System.out.println("\n" + loadBalancer.hello() + "\n");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}