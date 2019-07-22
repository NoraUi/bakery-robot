/**
 * BakeryRobot generated free by NoraUi Organization https://github.com/NoraUi
 * BakeryRobot is licensed under the license BSD.
 * 
 * CAUTION: BakeryRobot use NoraUi library. This project is licensed under the license GNU AFFERO GENERAL PUBLIC LICENSE
 */
package com.github.bakery.robot.main;

import com.github.bakery.robot.utils.BakeryRobotContext;

import com.github.noraui.main.ScenarioInitiator;

public class ScenarioInitiatorRunner {

    public static void main(String[] args) {
        BakeryRobotContext.getInstance().initializeEnv("BakeryRobot.properties");
        new ScenarioInitiator().start(args);
    }

}
