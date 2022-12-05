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
 import com.yy.dto.SysRoleDTO;
 import com.yy.service.SysRoleDataScopeService;
 import com.yy.service.SysRoleMenuService;
 import com.yy.service.SysRoleService;
 import com.yy.service.SysRoleUserService;
 import io.swagger.annotations.Api;
 import io.swagger.annotations.ApiImplicitParam;
 import io.swagger.annotations.ApiImplicitParams;
 import io.swagger.annotations.ApiOperation;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.security.access.prepost.PreAuthorize;
 import org.springframework.web.bind.annotation.*;
 import springfox.documentation.annotations.ApiIgnore;

 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;

 /**
 * 角色管理
 *
  * @author shelei
 * @since 1.0.0
 */
@RestController
@RequestMapping("role")
@Api(tags="角色管理")
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysRoleMenuService sysRoleMenuService;
    @Autowired
    private SysRoleDataScopeService sysRoleDataScopeService;
    @Autowired
    private SysRoleUserService sysRoleUserService;

    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({
        @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType="String") ,
        @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType="String") ,
        @ApiImplicitParam(name = "name", value = "角色名", paramType = "query", dataType="String")
    })
    @PreAuthorize("hasAuthority('sys:role:page')")
    public Result<PageData<SysRoleDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params){
        PageData<SysRoleDTO> page = sysRoleService.page(params);

        return new Result<PageData<SysRoleDTO>>().ok(page);
    }

    @GetMapping("list")
    @ApiOperation("列表")
    @PreAuthorize("hasAuthority('sys:role:list')")
    public Result<List<SysRoleDTO>> list(){
        List<SysRoleDTO> data = sysRoleService.list(new HashMap<>(1));

        return new Result<List<SysRoleDTO>>().ok(data);
    }

    @GetMapping("{id}")
    @ApiOperation("信息")
    @PreAuthorize("hasAuthority('sys:role:info')")
    public Result<SysRoleDTO> get(@PathVariable("id") Long id){
        SysRoleDTO data = sysRoleService.get(id);

        //查询角色对应的菜单
        List<Long> menuIdList = sysRoleMenuService.getMenuIdList(id);
        data.setMenuIdList(menuIdList);

        //查询角色对应的数据权限
        List<Long> deptIdList = sysRoleDataScopeService.getDeptIdList(id);
        data.setDeptIdList(deptIdList);

        return new Result<SysRoleDTO>().ok(data);
    }

    @PostMapping
    @ApiOperation("保存")
    @LogOperation("Save Role")
    @PreAuthorize("hasAuthority('sys:role:save')")
    public Result save(@RequestBody SysRoleDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        sysRoleService.save(dto);

        return new Result();
    }

    @PutMapping
    @ApiOperation("修改")
    @LogOperation("Update Role")
    @PreAuthorize("hasAuthority('sys:role:update')")
    public Result update(@RequestBody SysRoleDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        sysRoleService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @ApiOperation("删除")
    @LogOperation("Delete Role")
    @PreAuthorize("hasAuthority('sys:role:delete')")
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        sysRoleService.delete(ids);

        return new Result();
    }

     @GetMapping("getRoleIdList")
     public Result<List<Long>> getRoleIdList(Long userId){
         //用户角色列表
         List<Long> roleIdList = sysRoleUserService.getRoleIdList(userId);

         return new Result<List<Long>>().ok(roleIdList);
     }

}