package com.example.statemode;

/**
 * Created by lgf on 18-1-12.
 */

public class Client {
    public static void main(String[] args) {
        AfternoonState afternoonState = new AfternoonState();
        MorningState morningState = new MorningState();
        EveningState eveningState = new EveningState();
        Context context = new Context();
        context.setState(afternoonState);
        context.setState(morningState);
        context.setState(eveningState);
    }
}
