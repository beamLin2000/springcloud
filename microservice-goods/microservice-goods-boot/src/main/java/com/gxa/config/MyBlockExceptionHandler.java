package com.gxa.config;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Slf4j
@Component
public class MyBlockExceptionHandler implements BlockExceptionHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws Exception {
        log.info("BlockExceptionHandler BlockException================"+e.getRule());
        httpServletResponse.setCharacterEncoding("gbk");
        PrintWriter writer = httpServletResponse.getWriter();

        if(e instanceof FlowException){
            writer.println("接口限流了");
        }else if(e instanceof DegradeException) {
            writer.println("服务降级了");
        }else if(e instanceof ParamFlowException) {
            writer.println("热点参数限流了");
        }else if(e instanceof SystemBlockException) {
            writer.println("触发系统保护规则了");
        }else if(e instanceof AuthorityException) {
            writer.println("授权规则不通过");
        }
    }
}