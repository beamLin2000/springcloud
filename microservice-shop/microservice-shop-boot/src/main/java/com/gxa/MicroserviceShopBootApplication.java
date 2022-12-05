package com.gxa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication()
@EnableDiscoveryClient//服务的注册和发现
public class MicroserviceShopBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceShopBootApplication.class, args);
    }

}
