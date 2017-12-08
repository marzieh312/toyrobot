package com.jora.toyrobot.commands;

import com.jora.toyrobot.ToyRobot;

public class RotateLeftCommand implements Command {
    public void execute(ToyRobot toyRobot) {
        toyRobot.rotateLeft();
    }
}
