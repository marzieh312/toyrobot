package com.jora.toyrobot.commands;

import com.jora.toyrobot.ToyRobot;

public class RightCommand implements ICommand {
    public void execute(ToyRobot toyRobot) {
        toyRobot.moveRightOneStep();
    }
}
