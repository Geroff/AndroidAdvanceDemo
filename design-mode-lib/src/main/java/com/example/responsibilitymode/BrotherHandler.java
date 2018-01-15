package com.example.responsibilitymode;

/**
 * 具体处理者
 */
public class BrotherHandler extends Handler {
    @Override
    public void handleRequest(String request, int money) {
        if (money <= 100) {
            System.out.println("哥哥" + money + "块还是有的,给你！");
        } else {
            if (getNextHandler() != null) {
                System.out.println("哥哥只有100块,你叫麻麻拿吧");
                getNextHandler().handleRequest(request, money);
            } else {
                System.out.println("大于100块,哥哥没那么多,麻麻不在家");
            }
        }
    }
}
