package com.example.commandmode;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试命令模式，目的在于将请求者与实现者的解耦
 */

public class Client {

    public static void main(String[] args) {
        List<Story> storyList = new ArrayList<>();
        storyList.add(new Story("白雪公主", ""));
        storyList.add(new Story("丑小鸭", ""));
        storyList.add(new Story("小红帽", ""));
        storyList.add(new Story("灰姑娘", ""));
        storyList.add(new Story("三字经", ""));

        // 执行者
        StoryPlayer storyPlayer = new StoryPlayer();

        Command setListCommand = new SetListCommand(storyPlayer);
        Command playCommand = new PlayCommand(storyPlayer);
        Command pauseCommand = new PauseCommand(storyPlayer);
        Command preCommand = new PreCommand(storyPlayer);
        Command nextCommand = new NextCommand(storyPlayer);

        // 请求者
        Invoker invoker = new Invoker();
        invoker.setSetListCommand((SetListCommand) setListCommand);
        invoker.setPlayList(storyList);
        invoker.setPlayCommand((PlayCommand) playCommand);
        invoker.setPauseCommand((PauseCommand) pauseCommand);
        invoker.setPreCommand((PreCommand) preCommand);
        invoker.setNextCommand((NextCommand) nextCommand);

        invoker.play();
        invoker.next();
        invoker.next();
        invoker.next();
        invoker.next();
        invoker.next();
        invoker.pause();
        invoker.play();
    }
}
