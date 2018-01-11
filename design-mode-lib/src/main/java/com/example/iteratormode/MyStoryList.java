package com.example.iteratormode;

import java.util.List;

/**
 * 具体容器，具体迭代器角色与容器相关联
 */
public class MyStoryList implements SongList {
    private List<Song> songList;

    public MyStoryList(List<Song> songList) {
        if  (songList == null) {
            throw new NullPointerException();
        }

        this.songList = songList;
    }

    @Override
    public Iterator iterator() {
        return new SongIterator();
    }

    /**
     * 具体迭代器，实现接口中的方法，并且记录遍历的当前位置
     */
    private class SongIterator implements Iterator {
        int cursor;
        @Override
        public Song first() {
            return songList.get(0);
        }

        @Override
        public Song last() {
            return songList.get(songList.size() - 1);
        }

        @Override
        public boolean hasNext() {
            return cursor != songList.size();
        }

        @Override
        public Song next() {
            Song song = null;
            if (hasNext()) {
                song = songList.get(cursor);
            }
            cursor++;
            return song;
        }
    }
}
