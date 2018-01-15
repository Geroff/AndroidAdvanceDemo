package com.example.statemode;

/**
 * Created by lgf on 18-1-12.
 */

public class MorningState implements State {

    @Override
    public void doSomeThing() {
        System.out.println("早上赖床！");
    }
}
