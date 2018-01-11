package com.example.iteratormode;

import java.util.ArrayList;
import java.util.List;

/**
 * 迭代器模式，主要包括抽象迭代器，具体迭代器，抽象容器，具体容器
 */

public class Client {
    public static void main(String[] args) {
        List<Song> songList = new ArrayList<>();
        songList.add(new Song("name1", "singer1"));
        songList.add(new Song("name2", "singer2"));
        songList.add(new Song("name3", "singer3"));
        songList.add(new Song("name4", "singer4"));
        MyStoryList myStoryList = new MyStoryList(songList);
        Iterator iterator = myStoryList.iterator();
        while (iterator.hasNext()) {
            Song next = iterator.next();
            System.out.println(next.toString());
        }
    }
}
