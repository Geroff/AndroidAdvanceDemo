package com.example.commandmode;

import java.util.List;

/**
 * 请求者类
 */

public class Invoker {
    private SetListCommand setListCommand;
    private PlayCommand playCommand;
    private PauseCommand pauseCommand;
    private PreCommand preCommand;
    private NextCommand nextCommand;

    public void setSetListCommand(SetListCommand setListCommand) {
        this.setListCommand = setListCommand;
    }

    public void setPlayCommand(PlayCommand playCommand) {
        this.playCommand = playCommand;
    }

    public void setPauseCommand(PauseCommand pauseCommand) {
        this.pauseCommand = pauseCommand;
    }

    public void setPreCommand(PreCommand preCommand) {
        this.preCommand = preCommand;
    }

    public void setNextCommand(NextCommand nextCommand) {
        this.nextCommand = nextCommand;
    }

    public void setPlayList(List<Story> list) {
        setListCommand.setStoryList(list);
        setListCommand.execute();
    }

    public void play() {
        playCommand.execute();
    }

    public void pause() {
        pauseCommand.execute();
    }

    public void next() {
        nextCommand.execute();
    }

    public void pre() {
        preCommand.execute();
    }
}
