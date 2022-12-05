package com.gxa.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//专门用来读取配置的
//@Component
////@RefreshScope
//@Data
//@ConfigurationProperties(prefix = "user")
//public class CommonConfig {
//
//    //该属性一定要和配置中的user前缀后面的东西的对应
//    private String msg;
//    private String pwd;
//    private Integer age;
//
//}
