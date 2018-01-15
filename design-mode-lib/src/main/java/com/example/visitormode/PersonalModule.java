package com.example.visitormode;

/**
 * 具体元素
 */
public class PersonalModule implements OS {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitPersonalModule(this);
    }

    public String personalInfo() {
        return "个人信息模块";
    }
}
