package com.yy.controller;

import com.yy.commons.log.annotation.LogOperation;
import com.yy.commons.tools.constant.Constant;
import com.yy.commons.tools.page.PageData;
import com.yy.commons.tools.utils.ConvertUtils;
import com.yy.commons.tools.utils.Result;
import com.yy.commons.tools.validator.AssertUtils;
import com.yy.commons.tools.validator.ValidatorUtils;
import com.yy.commons.tools.validator.group.DefaultGroup;
import com.yy.commons.tools.validator.group.UpdateGroup;
import com.yy.dto.SysDictTypeDTO;
import com.yy.entity.DictType;
import com.yy.service.SysDictTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Map;

/**
 * 字典类型
 * @author shelei
 */
@RestController
@RequestMapping("dict/type")
@Api(tags="字典类型")
public class SysDictTypeController {
    @Autowired
    private SysDictTypeService sysDictTypeService;

    @GetMapping("page")
    @ApiOperation("字典类型")
    @ApiImplicitParams({
        @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType="String") ,
        @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType="String") ,
        @ApiImplicitParam(name = "dictType", value = "字典类型", paramType = "query", dataType="String"),
        @ApiImplicitParam(name = "dictName", value = "字典名称", paramType = "query", dataType="String")
    })
    @PreAuthorize("hasAuthority('sys:dict:page')")
    public Result<PageData<SysDictTypeDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params){
        //字典类型
        PageData<SysDictTypeDTO> page = sysDictTypeService.page(params);

        return new Result<PageData<SysDictTypeDTO>>().ok(page);
    }

    @GetMapping("{id}")
    @ApiOperation("信息")
    @PreAuthorize("hasAuthority('sys:dict:info')")
    public Result<SysDictTypeDTO> get(@PathVariable("id") Long id){
        SysDictTypeDTO data = sysDictTypeService.get(id);

        return new Result<SysDictTypeDTO>().ok(data);
    }

    @PostMapping
    @ApiOperation("保存")
    @LogOperation("保存")
    @PreAuthorize("hasAuthority('sys:dict:save')")
    public Result save(@RequestBody SysDictTypeDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, DefaultGroup.class);

        sysDictTypeService.save(dto);

        return new Result();
    }

    @PutMapping
    @ApiOperation("修改")
    @LogOperation("修改")
    @PreAuthorize("hasAuthority('sys:dict:update')")
    public Result update(@RequestBody SysDictTypeDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        sysDictTypeService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @ApiOperation("删除")
    @LogOperation("删除")
    @PreAuthorize("hasAuthority('sys:dict:delete')")
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        sysDictTypeService.delete(ids);

        return new Result();
    }

    @GetMapping("all")
    @ApiOperation("所有字典数据")
    public Result<List<DictType>> all(){
        List<DictType> list = sysDictTypeService.getAllList();

        return new Result<List<DictType>>().ok(list);
    }

    @GetMapping("list")
    public Result<List<SysDictTypeDTO>> list(){
        List<DictType> list = sysDictTypeService.getDictTypeList();
        List<SysDictTypeDTO> typeList = ConvertUtils.sourceToTarget(list, SysDictTypeDTO.class);
        return new Result<List<SysDictTypeDTO>>().ok(typeList);
    }

}