/**
 * BakeryRobot generated free by NoraUi Organization https://github.com/NoraUi
 * BakeryRobot is licensed under the license BSD.
 * CAUTION: BakeryRobot use NoraUi library. This project is licensed under the license GNU AFFERO GENERAL PUBLIC LICENSE
 */
package com.github.bakery.robot.indus;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.bakery.robot.utils.BakeryRobotContext;
import com.github.noraui.exception.TechnicalException;
import com.github.noraui.indus.MavenRunCounter;
import com.github.noraui.utils.Context;

public class Counter {

    /**
     * Specific LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(Counter.class);

    public static void main(String[] args) {
        List<String> manager = new ArrayList<>();

        List<String> scenarioBlacklist = new ArrayList<>();
        // you can add not run scenario here
        // scenarioBlacklist.add("--- you can add not run scenario here ---");

        List<String> versionControlSystemsBlacklist = new ArrayList<>();
        versionControlSystemsBlacklist.add(".svn");

        BakeryRobotContext.getInstance().initializeEnv("BakeryRobot.properties");

        MavenRunCounter mavenRunCounter = new MavenRunCounter();
        List<MavenRunCounter.Counter> counters;
        try {
            counters = mavenRunCounter.count(versionControlSystemsBlacklist, scenarioBlacklist, manager, new File(Context.getResourcesPath() + "/steps"));
            mavenRunCounter.print(counters, args[0]);
        } catch (TechnicalException e) {
            LOGGER.error("TechnicalException error: ", e);
        }
    }

}
