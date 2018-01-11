package com.example.commandmode;

/**
 * 具体命令类
 */

public class PreCommand implements Command {
    private StoryPlayer storyPlayer;

    public PreCommand(StoryPlayer storyPlayer) {
        this.storyPlayer = storyPlayer;
    }

    @Override
    public void execute() {
        storyPlayer.pre();
    }
}
