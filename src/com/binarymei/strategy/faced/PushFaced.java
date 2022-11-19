package com.binarymei.strategy.faced;

import com.binarymei.domain.User;
import com.binarymei.factory.StrategyFactory;
import com.binarymei.strategy.AbstractPushStrategy;

import java.util.Objects;

/**
 * binarymeiのworld
 *
 * @Author: binarymei
 * @Date: 2022/11/9
 * @Description: 对用户进行推送的门面类
 */
public class PushFaced {
    /**
     * 静态方法 可以直接 类名 加 . 进行调用 PushFaced.execute(user);
     * @param user
     */
    public static void execute(User user){
        //通过策略工厂获取该用户的策略
        AbstractPushStrategy strategy = StrategyFactory.get(user);
        if (Objects.nonNull(strategy)){
            //执行策略类的方法
            strategy.push(user);
        }else {
            System.out.println(user.getName()+"，没有关于您这种用户类型的推送策略");
        }
    }
}
