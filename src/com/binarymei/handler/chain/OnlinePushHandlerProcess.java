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
public class OnlinePushHandlerProcess implements CommonUserPushHandlerProcess, VipUserPushHandlerProcess {
    @Override
    public void commonProcess(User user) {
        System.out.println("您是普通用户，可用在线时间为8小时！");
    }

    @Override
    public void vipProcess(User user) {
        System.out.println("您是尊贵的会员，可用在线时间不限制哦～");
    }
}
