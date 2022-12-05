package com.gxa.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.sun.deploy.security.BlockedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        Entry entry = null;
        try{
            entry = SphU.entry("hello");//声明资源
            return "hello";
        }catch (FlowException e){
            log.info("block");
            return "被控制了。。。";
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(entry != null){
                entry.exit();
            }
        }
        return  null;
    }

    //降级方法在其他类中，通过blockHandlerClass 指定类 ,在其它类中该降级方法应该是static的
    @SentinelResource(value="world", blockHandler = "worldFallback",fallback = "aa")
    @GetMapping("/world/{id}")
    public String world(@PathVariable("id") String id){
        int i = 5/ 0;
        return "world---" + id;
    }

    public String aa(String id){
        return "bb";
    }

    public String worldFallback(String id,BlockException e){
        e.printStackTrace();
        return "被降级了。。。";
    }
//@PostConstruct
    private static void initFlowRules(){
        //流控规则
        List<FlowRule> rules = new ArrayList<>();
        //流控
        FlowRule rule = new FlowRule();
        //设置保护的资源
        rule.setResource("hello");
        //设置流控规则 QPS
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setCount(1);
        rules.add(rule);

        //流控
        FlowRule rule1 = new FlowRule();
        //设置保护的资源
        rule1.setResource("world");
        //设置流控规则 QPS
        rule1.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule1.setCount(1);
        rules.add(rule1);

        FlowRuleManager.loadRules(rules);
    }
    @PostConstruct
    private static void initDegradeRules(){
        //降级规则
        List<DegradeRule> rules = new ArrayList<>();
        DegradeRule rule = new DegradeRule();
        //设置保护的资源
        rule.setResource("world");
        //设置降级的策略：这里使用的是异常数
        rule.setGrade(RuleConstant.DEGRADE_GRADE_EXCEPTION_COUNT);
        //触发熔断异常数
        rule.setCount(2);
        //触发熔断的最小请求数
        rule.setMinRequestAmount(2);
        //统计时长
        rule.setStatIntervalMs(60*1000);
        //触发降级之后 会被熔断掉10秒，10秒之后会成为半打开熔断器状态
        rule.setTimeWindow(10);//单位为秒
        rules.add(rule);


        DegradeRuleManager.loadRules(rules);
    }
}
