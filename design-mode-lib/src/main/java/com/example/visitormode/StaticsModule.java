package com.example.visitormode;

/**
 * 具体元素
 */

public class StaticsModule implements OS {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitStaticsModule(this);
    }

    public String staticInfo() {
        return "统计信息模块";
    }
}
