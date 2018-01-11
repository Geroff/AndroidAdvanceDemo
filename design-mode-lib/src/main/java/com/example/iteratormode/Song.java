package com.example.iteratormode;

/**
 * Created by lgf on 18-1-11.
 */

public class Song {
    private String name;
    private String singer;

    public Song(String name, String singer) {
        this.name = name;
        this.singer = singer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    @Override
    public String toString() {
        return "[歌名]" + name + " [歌手]" + singer;
    }
}

