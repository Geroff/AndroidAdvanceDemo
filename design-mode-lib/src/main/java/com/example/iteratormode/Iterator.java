package com.example.iteratormode;

/**
 * 抽象迭代器，定义访问和遍历元素的接口
 */

public interface Iterator {
    Song first();
    Song last();
    boolean hasNext();
    Song next();
}
