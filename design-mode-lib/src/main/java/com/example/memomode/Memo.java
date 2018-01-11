package com.example.memomode;

/**
 * 备忘录类
 */

public class Memo {
    private int hp;
    private int mp;
    private int money;

    public Memo(int hp, int mp, int money) {
        this.hp = hp;
        this.mp = mp;
        this.money = money;
    }

    public int getHp() {
        return hp;
    }

    public int getMp() {
        return mp;
    }

    public int getMoney() {
        return money;
    }
}
