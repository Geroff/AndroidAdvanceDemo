package com.example.commandmode;

import java.util.List;

/**
 * 具体命令类
 */

public class SetListCommand implements Command {
    private StoryPlayer storyPlayer;
    private List<Story> storyList;

    public void setStoryList(List<Story> storyList) {
        this.storyList = storyList;
    }

    public SetListCommand(StoryPlayer storyPlayer) {
        this.storyPlayer = storyPlayer;
    }

    @Override
    public void execute() {
        storyPlayer.setPlayerList(storyList);
    }

}
