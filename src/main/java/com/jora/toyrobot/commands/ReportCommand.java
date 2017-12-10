package com.jora.toyrobot.commands;

import com.jora.toyrobot.ToyRobot;

public class ReportCommand implements Command {
    public void execute(ToyRobot toyRobot) {
        toyRobot.report();
    }
}
