package com.yy.swagger;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Swagger资源信息
 *
 * @author shelei
 */
@Data
@Configuration
@ConfigurationProperties("yy.swagger")
public class SwaggerRoute {
    private List<SwaggerRouteProperties> routes;
}
