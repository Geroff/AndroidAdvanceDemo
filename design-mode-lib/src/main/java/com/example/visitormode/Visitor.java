package com.example.visitormode;

/**
 * 抽象访问者
 */
public interface Visitor {
    void visitPersonalModule(PersonalModule personalModule);
    void visitStaticsModule(StaticsModule staticsModule);
}
