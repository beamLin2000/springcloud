package com.gxa.feign.fallbackfactory;

import com.gxa.entity.Shop;
import com.gxa.feign.ShopServiceFeignClient;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class ShopServiceFeignClientFallbackFatory implements FallbackFactory<ShopServiceFeignClient> {

    @Override
    public ShopServiceFeignClient create(Throwable cause) {
        return new ShopServiceFeignClient() {
            @Override
            public Shop getShop(Integer shopId) {
                Shop shop = new Shop();
                shop.setId(100);
                shop.setName("默认");
                return shop;
            }
        };
    }
}
