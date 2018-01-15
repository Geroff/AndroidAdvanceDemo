package com.example.responsibilitymode;

/**
 * 抽象处理者
 */
public abstract class Handler {
    // 下个处理着
    private Handler nextHandler;

    public Handler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handleRequest(String request, int money);
}
