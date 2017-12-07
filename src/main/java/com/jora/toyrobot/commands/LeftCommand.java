package com.jora.toyrobot.commands;

import com.jora.toyrobot.ToyRobot;

public class LeftCommand implements ICommand {
    public void execute(ToyRobot toyRobot) {
        toyRobot.moveLeftOneStep();
    }
}
