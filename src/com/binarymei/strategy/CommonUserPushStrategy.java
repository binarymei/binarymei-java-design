package com.binarymei.strategy;

import com.binarymei.domain.User;
import com.binarymei.factory.PushHandlerProcessFactory;
import com.binarymei.handler.CommonUserPushHandlerProcess;

import java.util.List;

/**
 * binarymeiのworld
 *
 * @Author: binarymei
 * @Date: 2022/11/9
 * @Description: 普通用户推送策略
 */
public class CommonUserPushStrategy extends AbstractPushStrategy{
    /**
     * 普通用户实现抽象的推送策略方法
     * @param user
     */
    @Override
    public void push(User user) {
        System.out.println(user.getName()+"，您是普通用户,正在执行普通用户推送策略");
        System.out.println("用户信息："+user);
        //获取该用户的责任链
        List<CommonUserPushHandlerProcess> list = PushHandlerProcessFactory.get(user);
        list.forEach(handler->handler.commonProcess(user));
    }
}
