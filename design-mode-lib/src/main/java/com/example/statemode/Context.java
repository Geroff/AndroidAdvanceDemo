package com.example.statemode;

/**
 * 上下文环境, 维护一个State子类的实例,该实例定义了对象的当前状态
 */

public class Context {
    public void setState(State state) {
        System.out.println("状态改变");
        state.doSomeThing();
    }
}
