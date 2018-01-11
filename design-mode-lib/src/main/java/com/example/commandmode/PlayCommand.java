package com.example.commandmode;

/**
 * 具体命令类
 */

public class PlayCommand implements Command {
    private StoryPlayer storyPlayer;

    public PlayCommand(StoryPlayer storyPlayer) {
        this.storyPlayer = storyPlayer;
    }

    @Override
    public void execute() {
        storyPlayer.play();
    }
}
