package com.binarymei.factory;

import com.binarymei.common.BaseConstants;
import com.binarymei.domain.User;
import com.binarymei.handler.*;
import com.binarymei.handler.chain.CouponsPushHandlerProcess;
import com.binarymei.handler.chain.OnlinePushHandlerProcess;
import com.binarymei.handler.chain.WelfarePushHandlerProcess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * binarymeiのworld
 *
 * @Author: binarymei
 * @Date: 2022/11/9
 * @Description: 推送责任链消息的工厂 为不同用户生成不同的推送任务
 */
public class PushHandlerProcessFactory<T> {
    //定义一个map用于取出责任链
    private static Map<String,List> dutyMap = new HashMap<>();
    //利用静态代码块对责任链进行封装
    static {
        //创建不同责任的实现类
        CouponsPushHandlerProcess couponsPushHandlerProcess = new CouponsPushHandlerProcess();
        OnlinePushHandlerProcess onlinePushHandlerProcess = new OnlinePushHandlerProcess();
        WelfarePushHandlerProcess welfarePushHandlerProcess = new WelfarePushHandlerProcess();
        //会员用户责任链封装
        List<VipUserPushHandlerProcess> vipPushDutyList = new ArrayList<>(3);
        vipPushDutyList.add(couponsPushHandlerProcess);
        vipPushDutyList.add(onlinePushHandlerProcess);
        vipPushDutyList.add(welfarePushHandlerProcess);
        //普通用户责任链封装
        List<CommonUserPushHandlerProcess> commonPushDutyList = new ArrayList<>(3);
        commonPushDutyList.add(couponsPushHandlerProcess);
        commonPushDutyList.add(onlinePushHandlerProcess);
        commonPushDutyList.add(welfarePushHandlerProcess);
        //将两条责任链放到定义好的map里
        dutyMap.put(BaseConstants.USER_TYPE_VIP,vipPushDutyList);
        dutyMap.put(BaseConstants.USER_TYPE_COMMON,commonPushDutyList);
    }

    /**
     * 提供获取方法 动态获取该用户类型的推送责任链
     * @param user
     * @return
     */
    public static List get(User user){
        return dutyMap.get(user.getType());
    }



}
