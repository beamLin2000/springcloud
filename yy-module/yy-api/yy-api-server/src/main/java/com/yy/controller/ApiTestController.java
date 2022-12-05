package com.yy.controller;

import com.yy.annotation.Login;
import com.yy.annotation.LoginUser;
import com.yy.commons.tools.utils.Result;
import com.yy.dto.UploadDTO;
import com.yy.entity.UserEntity;
import com.yy.feign.OssFeignClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 测试接口
 *
 * @author shelei
 */
@RestController
@RequestMapping("test")
@Api(tags="测试接口")
public class ApiTestController {
    @Autowired
    private OssFeignClient ossFeignClient;

    @Login
    @GetMapping("userInfo")
    @ApiOperation(value="获取用户信息", response= UserEntity.class)
    public Result<UserEntity> userInfo(@ApiIgnore @LoginUser UserEntity user){
        return new Result<UserEntity>().ok(user);
    }

    @Login
    @GetMapping("userId")
    @ApiOperation("获取用户ID")
    public Result<Long> userInfo(@ApiIgnore @RequestAttribute("userId") Long userId){
        return new Result<Long>().ok(userId);
    }

    @GetMapping("notToken")
    @ApiOperation("忽略Token验证测试")
    public Result<String> notToken(){
        return new Result<String>().ok("无需token也能访问。。。");
    }

    @PostMapping("upload")
    @ApiOperation(value = "上传文件")
    public Result<UploadDTO> upload(@RequestParam("file") MultipartFile file) {
        Result<UploadDTO> dto = ossFeignClient.upload(file);

        return dto;
    }
}