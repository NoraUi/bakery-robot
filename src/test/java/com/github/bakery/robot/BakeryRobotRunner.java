/**
 * BakeryRobot generated free by NoraUi Organization https://github.com/NoraUi
 * BakeryRobot is licensed under the license BSD.
 * CAUTION: BakeryRobot use NoraUi library. This project is licensed under the license GNU AFFERO GENERAL PUBLIC LICENSE
 *
 * @author Nicolas HALLOUIN
 * @author Stéphane GRILLON
 */
package com.github.bakery.robot;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.github.bakery.robot.utils.BakeryRobotContext;
import com.github.noraui.exception.TechnicalException;
import com.github.noraui.utils.Context;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true,
                       glue = { "com.github.noraui.cucumber.config", "com.github.noraui.application.steps", "com.github.noraui.browser.steps", "com.github.bakery.robot.application.steps" },
                     plugin = { "summary", "html:target/reports/html", "json:target/reports/json/report.json", "junit:target/reports/junit/report.xml" },
                   features = { "src/test/resources" })
public class BakeryRobotRunner {

    /**
     * BeforeClass Read constants file.
     * 
     * @throws TechnicalException is thrown if you have a technical error (format, configuration, datas, ...) in NoraUi.
     */
    @BeforeClass
    public static void setUpClass() throws TechnicalException {
        BakeryRobotContext.getInstance().initializeEnv("BakeryRobot.properties");
        BakeryRobotContext.getInstance().initializeRobot(BakeryRobotRunner.class);
    }

    /**
     * AfterClass clear Context.
     */
    @AfterClass
    public static void tearDownClass() {
        Context.clear();
    }

}
