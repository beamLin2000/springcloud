package com.gxa.common.pay.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.domain.AlipayTradePagePayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.gxa.common.pay.config.AliPayProperties;
import com.ijpay.alipay.AliPayApi;
import com.ijpay.alipay.AliPayApiConfig;
import com.ijpay.alipay.AliPayApiConfigKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.Map;

/**
 * 支付宝支付
 *
 * @author shelei
 */
@RestController
@RequestMapping("/pay/alipay")
public class AliPayController extends AbstractAliPayApiController {
    @Autowired
    private AliPayProperties properties;

    @Override
    public AliPayApiConfig getApiConfig() throws AlipayApiException {
        AliPayApiConfig aliPayApiConfig;
        try {
            aliPayApiConfig = AliPayApiConfigKit.getApiConfig(properties.getAppId());
        } catch (Exception e) {
            aliPayApiConfig = AliPayApiConfig.builder()
                .setAppId(properties.getAppId())
                .setAliPayPublicKey(properties.getPublicKey())
//                .setAppCertPath(properties.getAppCertPath())
//                .setAliPayCertPath(properties.getAliPayCertPath())
//                .setAliPayRootCertPath(properties.getAliPayRootCertPath())
                .setCharset("UTF-8")
                .setPrivateKey(properties.getPrivateKey())
                .setServiceUrl(properties.getServerUrl())
                .setSignType("RSA2")
                // 普通公钥方式
                .build();
                // 证书模式
//                .buildByCert();
        }
        return aliPayApiConfig;
    }

    /**
     * Web支付
     */
    @RequestMapping(value = "/webPay")
    public void webPay(HttpServletResponse response, Long orderId) throws Exception {
        //demo



        AlipayTradePagePayModel model = new AlipayTradePagePayModel();
        model.setOutTradeNo("order.getId()");
        model.setProductCode("FAST_INSTANT_TRADE_PAY");
        model.setTotalAmount("2");
        model.setSubject("中华牙膏");

        //1、根据订单号 到数据库查询 相关的订单信息
//        OrderEntity order = orderService.getByOrderId(orderId);
//        if(order == null){
//            throw new ResultException("订单不存在");
//        }

        //2、判断订单的状态 是否是待支付状态，只要不是待支付状态就说明订单失效
//        if(order.getStatus() != OrderStatusEnum.WAITING.getValue()){
//            throw new ResultException("订单已失效");
//        }

//        AlipayTradePagePayModel model = new AlipayTradePagePayModel();
        //设置订单号
//        model.setOutTradeNo(order.getOrderId() + "");

        //固定值 代号 ，数量 商品
//        model.setProductCode("FAST_INSTANT_TRADE_PAY");
//        model.setTotalAmount(order.getPayAmount().toString());
//        model.setSubject(order.getProductName());
        //公用回传参数，没有则无需设置
        //model.setPassbackParams("passback_params");

        AliPayApi.tradePage(response, model, properties.getNotifyUrl(), properties.getReturnUrl());
    }


    /**
     * 支付宝异步通知接口
     */
    @PostMapping("notify_url")
    public String notifyUrl(HttpServletRequest request) throws Exception {
        //支付宝异步通知内容
        Map<String, String> params = AliPayApi.toMap(request);

        //秘钥模式
        boolean verifyResult = AlipaySignature.rsaCheckV1(params, properties.getPublicKey(), "UTF-8", "RSA2");
        //证书模式
//        boolean verifyResult = AlipaySignature.rsaCertCheckV1(params, properties.getAliPayCertPath(), "UTF-8", "RSA2");

        //验签失败
        if (!verifyResult) {
            return "failure";
        }

        //记录支付宝回调信息

        //如果支付宝返回成功更新订单状态

        //查询订单信息 根据支付宝的回调，去查询该订单的信息

        //重复通知，不再处理 如果订单状态 是已经完成
//        if(order.getStatus() == OrderStatusEnum.FINISH.getValue()){
//            return "success";
//        }


        return "success";
    }

}
 
