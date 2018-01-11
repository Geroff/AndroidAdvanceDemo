package com.example.commandmode;

/**
 * 具体命令类
 */

public class NextCommand implements Command {
    private StoryPlayer storyPlayer;

    public NextCommand(StoryPlayer storyPlayer) {
        this.storyPlayer = storyPlayer;
    }

    @Override
    public void execute() {
        storyPlayer.next();
    }
}
