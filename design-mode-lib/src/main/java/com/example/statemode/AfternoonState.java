package com.example.statemode;

/**
 * 具体状态,实现抽象状态定义的接口,从而达到不同状态的不同行为
 */

public class AfternoonState implements State {

    @Override
    public void doSomeThing() {
        System.out.println("下午学习！");
    }
}
