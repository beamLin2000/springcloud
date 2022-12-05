package com.gxa.controller;

import com.gxa.entity.Shop;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class ShopController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/shop/{id}")
    public Shop getShop(@PathVariable("id") Integer shopId){
        log.info("-----shopId-----{}----",shopId);

//        try {
//            TimeUnit.SECONDS.sleep(3);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        Shop shop = new Shop();
        shop.setId(shopId);
        shop.setName("苏宁小店---" + port);

        return shop;
    }

    @PostMapping("/shop/json")
    //这里写完全是用来测试传参方式，不带有任何的业务逻辑
    public Shop getShopJson(@RequestBody Shop shop){
        log.info("-----------shop服务--------{}-----",shop);
        return shop;
    }

    @PostMapping("/shop/form")
    //这里写完全是用来测试传参方式，不带有任何的业务逻辑
    public Shop getShopForm( Shop shop){
        log.info("-----------shop服务 form--------{}-----",shop);
        return shop;
    }
}
