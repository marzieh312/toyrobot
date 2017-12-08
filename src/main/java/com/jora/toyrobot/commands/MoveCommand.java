package com.jora.toyrobot.commands;

import com.jora.toyrobot.ToyRobot;

public class MoveCommand implements Command {
    public void execute(ToyRobot toyRobot) {
        toyRobot.moveOneStep();
    }
}
