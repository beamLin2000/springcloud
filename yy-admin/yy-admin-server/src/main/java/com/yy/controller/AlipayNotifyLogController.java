package com.yy.controller;

import com.yy.commons.tools.constant.Constant;
import com.yy.commons.tools.page.PageData;
import com.yy.commons.tools.utils.Result;
import com.yy.dto.AlipayNotifyLogDTO;
import com.yy.service.AlipayNotifyLogService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Map;


/**
* 支付宝回调日志
*
 * @author shelei
*/
@RestController
@RequestMapping("pay/alipayNotifyLog")
public class AlipayNotifyLogController {
    @Autowired
    private AlipayNotifyLogService alipayNotifyLogService;

    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({
        @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType="String") ,
        @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType="String")
    })
    @PreAuthorize("hasAuthority('pay:alipayNotifyLog:all')")
    public Result<PageData<AlipayNotifyLogDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params){
        PageData<AlipayNotifyLogDTO> page = alipayNotifyLogService.page(params);

        return new Result<PageData<AlipayNotifyLogDTO>>().ok(page);
    }
}