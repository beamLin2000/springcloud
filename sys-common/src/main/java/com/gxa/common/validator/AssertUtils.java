package com.gxa.common.validator;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ArrayUtil;
import com.gxa.common.exception.ResultException;
import com.gxa.common.utils.ErrorCode;
import org.apache.commons.lang.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * 校验工具类
 *
 * @author shelei
 * @since 1.0.0
 */
public class AssertUtils {

    public static void isBlank(String str) {
        isBlank(str, "不能为空");
    }

    public static void isBlank(String str, String msg) {

        if (StringUtils.isBlank(str)) {
            throw new ResultException(str + "," + msg);
        }
    }

    public static void isNull(Object object) {
        isNull(object, "不能为空");
    }

    public static void isNull(Object object, String msg) {

        if (object == null) {
            throw new ResultException("对象" + "," + msg);
        }
    }

    public static void isArrayEmpty(Object[] array) {
        isArrayEmpty(array, "不能为空");
    }

    public static void isArrayEmpty(Object[] array,String msg) {

        if(ArrayUtil.isEmpty(array)){
            throw new ResultException("数组," + "," + msg);
        }
    }

    public static void isListEmpty(List<?> list) {
        isListEmpty(list, "不能为空");
    }

    public static void isListEmpty(List<?> list, String msg) {

        if(CollUtil.isEmpty(list)){
            throw new ResultException("list" + "," + msg);
        }
    }

    public static void isMapEmpty(Map map) {
        isMapEmpty(map, "不能为空");
    }

    public static void isMapEmpty(Map map, String msg) {

        if(MapUtil.isEmpty(map)){
            throw new ResultException("map" + "," + msg);
        }
    }
}