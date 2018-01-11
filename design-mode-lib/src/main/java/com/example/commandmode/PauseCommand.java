package com.example.commandmode;

/**
 * 具体命令类
 */

public class PauseCommand implements Command {
    private StoryPlayer storyPlayer;

    public PauseCommand(StoryPlayer storyPlayer) {
        this.storyPlayer = storyPlayer;
    }

    @Override
    public void execute() {
        storyPlayer.pause();
    }
}
