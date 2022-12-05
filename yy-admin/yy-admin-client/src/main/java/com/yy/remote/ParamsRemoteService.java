package com.yy.remote;

import com.yy.commons.tools.exception.ErrorCode;
import com.yy.commons.tools.exception.YYException;
import com.yy.commons.tools.utils.JsonUtils;
import com.yy.feign.ParamsFeignClient;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 *  参数
 *
 * @author shelei
 */
@Component
public class ParamsRemoteService {
    @Resource
    private ParamsFeignClient paramsFeignClient;

    /**
     * 根据参数编码，获取value的Object对象
     * @param paramCode  参数编码
     * @param clazz  Object对象
     */
    public <T> T getValueObject(String paramCode, Class<T> clazz) {
        String paramValue = paramsFeignClient.getValue(paramCode);
        if(StringUtils.isNotBlank(paramValue)){
            return JsonUtils.parseObject(paramValue, clazz);
        }

        try {
            return clazz.newInstance();
        } catch (Exception e) {
            throw new YYException(ErrorCode.PARAMS_GET_ERROR);
        }
    }

    /**
     * 根据参数编码，更新value
     * @param paramCode  参数编码
     * @param paramValue  参数值
     */
    public void updateValueByCode(String paramCode, String paramValue){
        paramsFeignClient.updateValueByCode(paramCode, paramValue);
    }

}