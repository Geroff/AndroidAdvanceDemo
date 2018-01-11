package com.example.memomode;

/**
 * Created by lgf on 18-1-11.
 */

public class Character {
    private int hp;
    private int mp;
    private int money;

    public Character(int hp, int mp, int money) {
        this.hp = hp;
        this.mp = mp;
        this.money = money;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void showMsg() {
        System.out.println("当前状态:| HP:" + hp + "| MP:" + mp + "| money:" + money);
    }

    public Memo save() {
        return new Memo(hp, mp, money);
    }

    public void restore(Memo memo) {
        this.hp = memo.getHp();
        this.mp = memo.getMp();
        this.money = memo.getMoney();
    }
}
