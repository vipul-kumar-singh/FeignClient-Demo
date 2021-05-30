package com.FeignDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestClientException;

import java.io.IOException;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@Controller
public class FeignDemoApplication {

    public static void main(String[] args) throws RestClientException, IOException {
        ApplicationContext ctx = SpringApplication.run(FeignDemoApplication.class, args);

        ConsumerControllerClient consumerControllerClient = ctx.getBean(ConsumerControllerClient.class);
        System.out.println(consumerControllerClient);
        consumerControllerClient.getEmployee();
    }

    @Bean
    public ConsumerControllerClient consumerControllerClient() {
        return new ConsumerControllerClient();
    }
}
