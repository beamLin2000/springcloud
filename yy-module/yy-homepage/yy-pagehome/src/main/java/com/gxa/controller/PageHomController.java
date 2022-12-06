package com.gxa.controller;

import com.yy.commons.tools.utils.Result;
import com.yy.entity.Backlog;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PageHomController {
    @GetMapping("/homepage/text")
    @ApiOperation("获取待处理事务")
    public Result gettext(){
        Backlog backlog = new Backlog(1,2,3,4,5);

        return new Result().ok(backlog);

    }
}
