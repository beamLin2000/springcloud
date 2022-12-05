package com.gxa.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.gxa.entity.Goods;
import com.gxa.entity.Shop;
import com.gxa.feign.ShopServiceFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
@RestController
@Slf4j
@RefreshScope
public class GoodsController {

    @Autowired
    private ShopServiceFeignClient shopServiceFeignClient;

//    @Autowired
//    private CommonConfig commonConfig;

//    @Value("${timeout}")
//    private Integer timeout;

    @SentinelResource("abc")
    @GetMapping("/goods/{id}")
    public Goods getById(@PathVariable("id") Integer goodsId){

        log.info("=====goodsId===={}===",goodsId);

        Goods goods = new Goods();
        goods.setId(goodsId);
        goods.setName("中华牙膏11");
        goods.setPrice(39.9);

        Shop shop = shopServiceFeignClient.getShop(10);
        goods.setShop(shop);


        return goods;
    }




}
