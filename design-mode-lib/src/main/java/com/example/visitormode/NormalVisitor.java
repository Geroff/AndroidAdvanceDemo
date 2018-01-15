package com.example.visitormode;

/**
 * 具体访问者
 */
public class NormalVisitor implements Visitor {

    @Override
    public void visitPersonalModule(PersonalModule personalModule) {
        System.out.println("普通用户" + personalModule.personalInfo());
    }

    @Override
    public void visitStaticsModule(StaticsModule staticsModule) {
        System.out.println("普通用户" + staticsModule.staticInfo());
    }
}
