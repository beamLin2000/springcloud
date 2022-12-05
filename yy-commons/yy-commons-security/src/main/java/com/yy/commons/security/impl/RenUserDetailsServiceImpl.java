package com.yy.commons.security.impl;

import com.yy.commons.security.user.UserDetail;
import com.yy.commons.tools.exception.ErrorCode;
import com.yy.commons.tools.exception.YYException;
import com.yy.commons.tools.utils.Result;
import com.yy.commons.security.enums.UserStatusEnum;
import com.yy.commons.security.feign.AccountFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * UserDetailsService
 *
 * @author shelei
 */
@Service
public class RenUserDetailsServiceImpl implements UserDetailsService {
    @Autowired(required=false)
    private AccountFeignClient accountFeignClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Result<UserDetail> result = accountFeignClient.getByUsername(username);
        UserDetail userDetail = result.getData();
        if(userDetail == null){
            throw new YYException(ErrorCode.ACCOUNT_NOT_EXIST);
        }

        //账号不可用
        if(userDetail.getStatus() == UserStatusEnum.DISABLE.value()){
            userDetail.setEnabled(false);
        }

        return userDetail;
    }
}
