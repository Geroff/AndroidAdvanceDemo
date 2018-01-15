package com.example.visitormode;

/**
 * 具体访问者
 */

public class VIPVisitor implements Visitor {
    @Override
    public void visitPersonalModule(PersonalModule personalModule) {
        System.out.println("VIP" + personalModule.personalInfo());
    }

    @Override
    public void visitStaticsModule(StaticsModule staticsModule) {
        System.out.println("VIP" + staticsModule.staticInfo());
    }
}
