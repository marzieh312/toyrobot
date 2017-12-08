package com.jora.toyrobot.commands;

import com.jora.toyrobot.ToyRobot;

public class RotateRightCommand implements Command {
    public void execute(ToyRobot toyRobot) {
        toyRobot.rotateRight();
    }
}
