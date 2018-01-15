package com.example.visitormode;

import java.util.ArrayList;
import java.util.List;

/**
 * 对象结构
 */
public class Administrator {
    private List<OS> osList = new ArrayList<>();
    public void add(OS os) {
        osList.add(os);
    }

    public void action(Visitor visitor) {
        for (OS os: osList) {
            os.accept(visitor);
        }
    }
}
