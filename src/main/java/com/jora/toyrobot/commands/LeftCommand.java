package com.jora.toyrobot.commands;

import com.jora.toyrobot.ToyRobot;

public class LeftCommand implements Command {
    public void execute(ToyRobot toyRobot) {
        toyRobot.moveLeftOneStep();
    }
}
