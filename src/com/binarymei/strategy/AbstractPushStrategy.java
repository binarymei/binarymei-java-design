package com.binarymei.strategy;

import com.binarymei.domain.User;

/**
 * binarymeiのworld
 *
 * @Author: binarymei
 * @Date: 2022/11/9
 * @Description: 抽象策略类 制定推送策略的模版
 */
public abstract class AbstractPushStrategy {
    abstract public void push(User user);
}
