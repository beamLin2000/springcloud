package com.yy.controller;

import com.yy.commons.log.SysLogLogin;
import com.yy.commons.log.enums.LogTypeEnum;
import com.yy.commons.log.enums.LoginOperationEnum;
import com.yy.commons.log.producer.LogProducer;
import com.yy.commons.tools.redis.RedisKeys;
import com.yy.commons.tools.redis.RedisUtils;
import com.yy.commons.tools.utils.IpUtils;
import com.yy.commons.tools.utils.Result;
import com.yy.commons.security.user.UserDetail;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.apache.http.HttpHeaders;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 认证管理
 *
 * @author shelei
 */
@RestController
@AllArgsConstructor
@Api(tags="认证管理")
public class OAuth2Controller {
    private TokenStore tokenStore;
    private LogProducer logProducer;
    private RedisUtils redisUtils;

    /**
     * 认证页面
     */
    @GetMapping("/sso/login")
    public ModelAndView require(ModelAndView modelAndView) {
        modelAndView.setViewName("sso/login");
        return modelAndView;
    }

    /**
     * 退出
     */
    @PostMapping("/oauth/logout")
    public Result logout(HttpServletRequest request) {
        String access_token = request.getHeader(HttpHeaders.AUTHORIZATION).replace("Bearer ", "");
        OAuth2AccessToken oAuth2AccessToken = tokenStore.readAccessToken(access_token);
        if(oAuth2AccessToken != null){
            //用户信息
            OAuth2Authentication oAuth2Authentication = tokenStore.readAuthentication(oAuth2AccessToken);
            UserDetail user = (UserDetail) oAuth2Authentication.getPrincipal();

            tokenStore.removeAccessToken(oAuth2AccessToken);
            OAuth2RefreshToken oAuth2RefreshToken = oAuth2AccessToken.getRefreshToken();
            tokenStore.removeRefreshToken(oAuth2RefreshToken);
            tokenStore.removeAccessTokenUsingRefreshToken(oAuth2RefreshToken);

            //清空菜单导航、权限标识
            redisUtils.deleteByPattern(RedisKeys.getUserMenuNavKey(user.getId()));
            redisUtils.delete(RedisKeys.getUserPermissionsKey(user.getId()));

            //退出日志
            SysLogLogin log = new SysLogLogin();
            log.setType(LogTypeEnum.LOGIN.value());
            log.setOperation(LoginOperationEnum.LOGOUT.value());
            log.setIp(IpUtils.getIpAddr(request));
            log.setUserAgent(request.getHeader(HttpHeaders.USER_AGENT));
            log.setIp(IpUtils.getIpAddr(request));
            log.setCreator(user.getId());
            log.setCreatorName(user.getUsername());
            log.setCreateDate(new Date());
            logProducer.saveLog(log);
        }
        return new Result();
    }

}