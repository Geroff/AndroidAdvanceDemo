package com.example.memomode;

/**
 * Created by lgf on 18-1-11.
 */

public class Client {
    public static void main(String[]args) {
        Caretaker caretaker = new Caretaker();
        Character character = new Character(1000, 1000, 5000);

        System.out.println("===存档中...===");
        character.showMsg();
        caretaker.setMemo(character.save());

        System.out.println("===挑战boss失败...===");
        character.setHp(0);
        character.setMp(0);
        character.setMoney(250);
        character.showMsg();

        System.out.println("===读档中...===");
        character.restore(caretaker.getMemo());
        character.showMsg();
    }
}
