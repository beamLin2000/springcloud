package com.gxa.feign.fallback;

import com.gxa.entity.Shop;
import com.gxa.feign.ShopServiceFeignClient;
import org.springframework.stereotype.Component;

@Component
public class ShopServiceFeignClientFallback implements ShopServiceFeignClient {
    @Override
    public Shop getShop(Integer shopId) {
        //降级方法
        return null;
    }
}
