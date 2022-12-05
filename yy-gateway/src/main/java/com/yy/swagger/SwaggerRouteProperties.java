package com.yy.swagger;

import lombok.Data;

/**
 * Swagger资源信息
 *
 * @author shelei
 */
@Data
public class SwaggerRouteProperties {
    /**
     * 文档名称
     */
    private String name;
    /**
     * 文档地址
     */
    private String location;

}
