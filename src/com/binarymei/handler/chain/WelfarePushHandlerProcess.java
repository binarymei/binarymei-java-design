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
public class WelfarePushHandlerProcess implements CommonUserPushHandlerProcess, VipUserPushHandlerProcess {

    @Override
    public void commonProcess(User user) {
        System.out.println("已为您发送普通用户礼包");
    }

    @Override
    public void vipProcess(User user) {
        System.out.println("已为您发送会员用户礼包");
    }
}
