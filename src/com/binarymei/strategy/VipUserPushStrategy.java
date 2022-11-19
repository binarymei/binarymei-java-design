package com.binarymei.strategy;

import com.binarymei.domain.User;
import com.binarymei.factory.PushHandlerProcessFactory;
import com.binarymei.handler.VipUserPushHandlerProcess;


import java.util.List;

/**
 * binarymeiのworld
 *
 * @Author: binarymei
 * @Date: 2022/11/9
 * @Description: 会员用户推送策略
 */
public class VipUserPushStrategy extends AbstractPushStrategy{

    /**
     * 会员用户实现抽象的推送策略方法
     * @param user
     */
    @Override
    public void push(User user) {
        System.out.println(user.getName()+"，您是会员,正在执行会员用户推送策略");
        System.out.println("用户信息："+user);
        //获取该用户的责任链
        List<VipUserPushHandlerProcess> list = PushHandlerProcessFactory.get(user);
        list.forEach(handler->handler.vipProcess(user));
    }
}
