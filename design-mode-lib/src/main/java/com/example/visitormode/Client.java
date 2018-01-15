package com.example.visitormode;

/**
 * 访问者模式
 */
public class Client {
    public static void main(String[] args) {
        Administrator administrator = new Administrator();
        administrator.add(new PersonalModule());
        administrator.add(new StaticsModule());

        NormalVisitor normalVisitor = new NormalVisitor();
        VIPVisitor vipVisitor = new VIPVisitor();
        administrator.action(normalVisitor);
        administrator.action(vipVisitor);
    }
}
