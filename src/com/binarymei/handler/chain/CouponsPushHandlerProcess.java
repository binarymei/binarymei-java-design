package com.binarymei.handler.chain;

import com.binarymei.domain.User;
import com.binarymei.handler.CommonUserPushHandlerProcess;
import com.binarymei.handler.VipUserPushHandlerProcess;

/**
 * binarymeiのworld
 *
 * @Author: binarymei
 * @Date: 2022/11/9
 * @Description:
 */
public class CouponsPushHandlerProcess implements CommonUserPushHandlerProcess, VipUserPushHandlerProcess {
    @Override
    public void commonProcess(User user) {
        System.out.println("已为您发放普通用户专属的98折优惠券！");
    }

    @Override
    public void vipProcess(User user) {
        System.out.println("已为您发放会员用户专属的68折优惠券");
    }
}
