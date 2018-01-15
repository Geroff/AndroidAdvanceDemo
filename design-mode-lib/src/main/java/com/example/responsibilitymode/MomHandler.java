package com.example.responsibilitymode;

/**
 * 具体处理者
 */

public class MomHandler extends Handler {
    @Override
    public void handleRequest(String request, int money) {
        if (money <= 500) {
            System.out.println("麻麻" + money + "块还是有的,给你！");
        } else {
            if (getNextHandler() != null) {
                System.out.println("麻麻只有500块,你叫爸爸拿吧");
                getNextHandler().handleRequest(request, money);
            } else {
                System.out.println("大于500块,麻麻没那么多,爸爸不在家");
            }
        }
    }
}
