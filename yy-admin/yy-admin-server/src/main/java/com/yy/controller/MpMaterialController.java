package com.yy.controller;

import com.yy.commons.tools.constant.Constant;
import com.yy.commons.tools.page.PageData;
import com.yy.commons.tools.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.api.WxMpMaterialService;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.material.WxMpMaterialFileBatchGetResult;
import me.chanjar.weixin.mp.bean.material.WxMpMaterialNews;
import me.chanjar.weixin.mp.bean.material.WxMpMaterialNewsBatchGetResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 公众号素材管理
 *
 * @author shelei
 */
@AllArgsConstructor
@RestController
@RequestMapping("mp/material")
@Api(tags="公众号素材管理")
public class MpMaterialController {
    private final WxMpService wxService;

    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "appId", value = "appId", paramType = "query", required = true, dataType="String") ,
        @ApiImplicitParam(name = "type", value = "可选值：news、voice、image、video", paramType = "query", required = true, dataType="String") ,
        @ApiImplicitParam(name = "offset", value = "起始位置", paramType = "query", required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query",required = true, dataType="int")
    })
    public Result page(String appId, String type, int offset, int limit) throws Exception {
        if (!this.wxService.switchover(appId)) {
            throw new IllegalArgumentException(String.format("未找到对应appId=[%s]的配置，请核实！", appId));
        }

        //素材服务
        WxMpMaterialService materialService = wxService.getMaterialService();

        if (WxConsts.MaterialType.NEWS.equals(type)) {
            WxMpMaterialNewsBatchGetResult result = materialService.materialNewsBatchGet(offset, limit);

            return new Result<>().ok(new PageData<>(result.getItems(), result.getTotalCount()));
        } else {
            WxMpMaterialFileBatchGetResult result = materialService.materialFileBatchGet(type, offset, limit);

            return new Result<>().ok(new PageData<>(result.getItems(), result.getTotalCount()));
        }

    }

    @GetMapping("get")
    @ApiOperation("获取永久素材")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "appId", value = "appId", paramType = "query", required = true, dataType="String") ,
        @ApiImplicitParam(name = "mediaId", value = "素材ID", paramType = "query", required = true, dataType="String")
    })
    public Result get(String appId, String mediaId) throws Exception {
        if (!this.wxService.switchover(appId)) {
            throw new IllegalArgumentException(String.format("未找到对应appId=[%s]的配置，请核实！", appId));
        }


        //获取永久素材
        WxMpMaterialNews data = wxService.getMaterialService().materialNewsInfo(mediaId);

        return new Result().ok(data);
    }
}
