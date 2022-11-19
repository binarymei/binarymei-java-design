package com.binarymei;

import com.binarymei.common.BaseConstants;
import com.binarymei.domain.User;
import com.binarymei.strategy.faced.PushFaced;

/**
 * binary-meiのworld
 *
 * @Author: binary-mei
 * @Date: 2022/11/9
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        //创建一个用户模型
        User user = new User();
        user.setName("张三");
        user.setAge(20);
        user.setAddress("");
        user.setType(BaseConstants.USER_TYPE_VIP);
        //执行推送策略
        PushFaced.execute(user);
    }
}
