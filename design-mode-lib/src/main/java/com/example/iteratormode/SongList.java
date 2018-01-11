package com.example.iteratormode;

/**
 * 抽象容器，提供创建具体迭代器角色的接口
 */
public interface SongList {
    Iterator iterator();
}
