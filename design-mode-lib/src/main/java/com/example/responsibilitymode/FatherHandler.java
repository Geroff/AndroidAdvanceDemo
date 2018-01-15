package com.example.responsibilitymode;

/**
 * 具体处理者
 */

public class FatherHandler extends Handler {
    @Override
    public void handleRequest(String request, int money) {
        if (money <= 1000) {
            System.out.println("爸爸" + money + "块还是有的,给你！");
        } else {
            System.out.println("拿那么多钱干嘛,没有！");
        }
    }
}
