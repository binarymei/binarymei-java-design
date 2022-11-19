package com.binarymei.factory;

import com.binarymei.common.BaseConstants;
import com.binarymei.domain.User;
import com.binarymei.strategy.AbstractPushStrategy;
import com.binarymei.strategy.CommonUserPushStrategy;
import com.binarymei.strategy.VipUserPushStrategy;

import java.util.HashMap;
import java.util.Map;

/**
 * binarymeiのworld
 *
 * @Author: binarymei
 * @Date: 2022/11/9
 * @Description: 策略工厂 通过用户的类型获取不同的策略方法
 */
public class StrategyFactory {
    //创建一个map用于存储不同的策略 方便直接获取
    private static Map<String,AbstractPushStrategy> definitionMap = new HashMap<>();
    //利用静态代码块在类加载的时候就对map进行初始化
    static {
        //这里将不同的用户策略进行初始化并添加到map里 避免重复创建对象 单例模式
        CommonUserPushStrategy commonUserPushStrategy = new CommonUserPushStrategy();
        VipUserPushStrategy vipUserPushStrategy = new VipUserPushStrategy();
        definitionMap.put(BaseConstants.USER_TYPE_COMMON,commonUserPushStrategy);
        definitionMap.put(BaseConstants.USER_TYPE_VIP,vipUserPushStrategy);
    }
    /**
     * 提供获取策略的方法 方法返回值为制定策略的父类 这样不管哪个实现类都能向下转型
     * @param user
     * @return
     */
    public static AbstractPushStrategy get(User user){
        //获取用户类型
        AbstractPushStrategy strategy = definitionMap.get(user.getType());
        return strategy;
    }
}
