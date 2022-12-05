package com.gxa.feign;

import com.gxa.entity.Shop;
import com.gxa.feign.fallback.ShopServiceFeignClientFallback;
import com.gxa.feign.fallbackfactory.ShopServiceFeignClientFallbackFatory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(value = "shop-service", contextId = "shopService", fallback = ShopServiceFeignClientFallback.class)
@FeignClient(value = "shop-service", contextId = "shopService", fallbackFactory = ShopServiceFeignClientFallbackFatory.class)
public interface ShopServiceFeignClient {

    @GetMapping("/shop/{id}")
    public Shop getShop(@PathVariable("id") Integer shopId);


}
