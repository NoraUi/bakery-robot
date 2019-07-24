package com.github.bakery.robot;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.github.bakery.robot.utils.BakeryRobotContext;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import com.github.noraui.exception.TechnicalException;
import com.github.noraui.utils.Context;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true,
                       glue = { "com.github.noraui.cucumber.config", "com.github.noraui.application.steps", "com.github.noraui.browser.steps", "com.github.bakery.robot.application.steps" },
                     plugin = { "html:target/reports/html", "json:target/reports/json/report.json", "junit:target/reports/junit/report.xml" },
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
