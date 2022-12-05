
package com.yy.feign;

import com.yy.commons.tools.constant.ServiceConstant;
import com.yy.commons.tools.utils.Result;
import com.yy.dto.SysDictTypeDTO;
import com.yy.feign.fallback.DictFeignClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * 字典接口
 *
 * @author shelei
 */
@FeignClient(name = ServiceConstant.YY_ADMIN_SERVER, contextId = "DictFeignClient", fallbackFactory = DictFeignClientFallbackFactory.class)
public interface DictFeignClient {

    /**
     * 字典类型列表
     */
    @GetMapping("sys/dict/type/list")
    Result<List<SysDictTypeDTO>> getDictTypeList();

}