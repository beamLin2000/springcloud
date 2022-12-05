package com.yy.controller;

import com.yy.commons.log.annotation.LogOperation;
import com.yy.commons.tools.constant.Constant;
import com.yy.commons.tools.page.PageData;
import com.yy.commons.tools.utils.Result;
import com.yy.commons.tools.validator.AssertUtils;
import com.yy.commons.tools.validator.ValidatorUtils;
import com.yy.commons.tools.validator.group.AddGroup;
import com.yy.commons.tools.validator.group.DefaultGroup;
import com.yy.commons.tools.validator.group.UpdateGroup;
import com.yy.dto.MpAccountDTO;
import com.yy.service.MpAccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Map;


/**
* 公众号账号管理
*
 * @author shelei
*/
@AllArgsConstructor
@RestController
@RequestMapping("mp/account")
@Api(tags="公众号账号管理")
public class MpAccountController {
    private final MpAccountService mpAccountService;

    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({
        @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType="String") ,
        @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType="String")
    })
    @PreAuthorize("hasAuthority('mp:account:all')")
    public Result<PageData<MpAccountDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params){
        PageData<MpAccountDTO> page = mpAccountService.page(params);

        return new Result<PageData<MpAccountDTO>>().ok(page);
    }

    @GetMapping("{id}")
    @ApiOperation("信息")
    @PreAuthorize("hasAuthority('mp:account:all')")
    public Result<MpAccountDTO> get(@PathVariable("id") Long id){
        MpAccountDTO data = mpAccountService.get(id);

        return new Result<MpAccountDTO>().ok(data);
    }

    @PostMapping
    @ApiOperation("保存")
    @LogOperation("保存")
    @PreAuthorize("hasAuthority('mp:account:all')")
    public Result save(@RequestBody MpAccountDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        mpAccountService.save(dto);

        return new Result();
    }

    @PutMapping
    @ApiOperation("修改")
    @LogOperation("修改")
    @PreAuthorize("hasAuthority('mp:account:all')")
    public Result update(@RequestBody MpAccountDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        mpAccountService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @ApiOperation("删除")
    @LogOperation("删除")
    @PreAuthorize("hasAuthority('mp:account:all')")
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        mpAccountService.delete(ids);

        return new Result();
    }

}