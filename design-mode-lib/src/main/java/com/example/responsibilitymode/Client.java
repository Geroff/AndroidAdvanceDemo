package com.example.responsibilitymode;

/**
 * 责任链模式
 */
public class Client {
    public static void main(String[] args) {
        BrotherHandler brotherHandler = new BrotherHandler();
        MomHandler momHandler = new MomHandler();
        FatherHandler fatherHandler = new FatherHandler();

        brotherHandler.setNextHandler(momHandler);
        momHandler.setNextHandler(fatherHandler);

//        brotherHandler.handleRequest("要钱", 100);
//        brotherHandler.handleRequest("要钱", 200);
//        brotherHandler.handleRequest("要钱", 600);
        brotherHandler.handleRequest("要钱", 1600);
    }
}
