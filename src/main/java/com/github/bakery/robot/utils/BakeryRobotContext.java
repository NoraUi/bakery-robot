/**
 * BakeryRobot generated free by NoraUi Organization https://github.com/NoraUi
 * BakeryRobot is licensed under the license BSD.
 * 
 * CAUTION: BakeryRobot use NoraUi library. This project is licensed under the license GNU AFFERO GENERAL PUBLIC LICENSE
 */
package com.github.bakery.robot.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.noraui.application.Application;
import com.github.noraui.application.page.Page;
import com.github.noraui.exception.TechnicalException;
import com.github.noraui.utils.Context;
import com.github.noraui.utils.Messages;

public class BakeryRobotContext extends Context {

    /**
     * Specific logger
     */
    private static final Logger logger = LoggerFactory.getLogger(BakeryRobotContext.class);

    // applications
    public static final String BAKERY_KEY = "bakery";
    public static final String BAKERY_HOME = "BAKERY_HOME";
    private String bakeryHome; // BAKERY home url
    public static final String GOOGLE_KEY = "google";
    public static final String GOOGLE_HOME = "GOOGLE_HOME";
    private String googleHome; // GOOGLE home url
    public static final String LOGOGAME_KEY = "logogame";
    public static final String LOGOGAME_HOME = "LOGOGAME_HOME";
    private String logogameHome; // LOGOGAME home url

    // targets
    public static final String GO_TO_BAKERY_HOME = "GO_TO_BAKERY_HOME";
    public static final String CLOSE_WINDOW_AND_SWITCH_TO_BAKERY_HOME = "CLOSE_WINDOW_AND_SWITCH_TO_BAKERY_HOME";
    public static final String CLOSE_ALL_WINDOWS_AND_SWITCH_TO_BAKERY_HOME = "CLOSE_ALL_WINDOWS_AND_SWITCH_TO_BAKERY_HOME";
    public static final String GO_TO_GOOGLE_HOME = "GO_TO_GOOGLE_HOME";
    public static final String CLOSE_WINDOW_AND_SWITCH_TO_GOOGLE_HOME = "CLOSE_WINDOW_AND_SWITCH_TO_GOOGLE_HOME";
    public static final String CLOSE_ALL_WINDOWS_AND_SWITCH_TO_GOOGLE_HOME = "CLOSE_ALL_WINDOWS_AND_SWITCH_TO_GOOGLE_HOME";
    public static final String GO_TO_LOGOGAME_HOME = "GO_TO_LOGOGAME_HOME";
    public static final String CLOSE_WINDOW_AND_SWITCH_TO_LOGOGAME_HOME = "CLOSE_WINDOW_AND_SWITCH_TO_LOGOGAME_HOME";
    public static final String CLOSE_ALL_WINDOWS_AND_SWITCH_TO_LOGOGAME_HOME = "CLOSE_ALL_WINDOWS_AND_SWITCH_TO_LOGOGAME_HOME";

    /**
     * Constructor is useless because all attributes are static
     */
    private BakeryRobotContext() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void initializeRobot(Class clazz) throws TechnicalException {
        super.initializeRobot(clazz);
        logger.info("BakeryRobotContext > initializeRobot()");
        
        // This line is here as an example to show how to do with internationalization using messages bundles.
        logger.info(Messages.format(Messages.getMessage("HELLO", "robot"), "robot"));

        // Urls configuration
        bakeryHome = getProperty(BAKERY_KEY, applicationProperties);
        googleHome = getProperty(GOOGLE_KEY, applicationProperties);
        logogameHome = getProperty(LOGOGAME_KEY, applicationProperties);

        // Selectors configuration
        initApplicationDom(clazz.getClassLoader(), selectorsVersion, BAKERY_KEY);
        initApplicationDom(clazz.getClassLoader(), selectorsVersion, GOOGLE_KEY);
        initApplicationDom(clazz.getClassLoader(), selectorsVersion, LOGOGAME_KEY);
 
        // Exception Callbacks
        exceptionCallbacks.put(GO_TO_BAKERY_HOME, STEPS_BROWSER_STEPS_CLASS_QUALIFIED_NAME, GO_TO_URL_METHOD_NAME, BAKERY_HOME);
        exceptionCallbacks.put(CLOSE_WINDOW_AND_SWITCH_TO_BAKERY_HOME, STEPS_BROWSER_STEPS_CLASS_QUALIFIED_NAME, "closeWindowAndSwitchTo", BAKERY_KEY, BAKERY_HOME);
        exceptionCallbacks.put(CLOSE_ALL_WINDOWS_AND_SWITCH_TO_BAKERY_HOME, STEPS_BROWSER_STEPS_CLASS_QUALIFIED_NAME, "closeAllWindowsAndSwitchTo", BAKERY_KEY);
        exceptionCallbacks.put(GO_TO_GOOGLE_HOME, STEPS_BROWSER_STEPS_CLASS_QUALIFIED_NAME, GO_TO_URL_METHOD_NAME, GOOGLE_HOME);
        exceptionCallbacks.put(CLOSE_WINDOW_AND_SWITCH_TO_GOOGLE_HOME, STEPS_BROWSER_STEPS_CLASS_QUALIFIED_NAME, "closeWindowAndSwitchTo", GOOGLE_KEY, GOOGLE_HOME);
        exceptionCallbacks.put(CLOSE_ALL_WINDOWS_AND_SWITCH_TO_GOOGLE_HOME, STEPS_BROWSER_STEPS_CLASS_QUALIFIED_NAME, "closeAllWindowsAndSwitchTo", GOOGLE_KEY);
        exceptionCallbacks.put(GO_TO_LOGOGAME_HOME, STEPS_BROWSER_STEPS_CLASS_QUALIFIED_NAME, GO_TO_URL_METHOD_NAME, LOGOGAME_HOME);
        exceptionCallbacks.put(CLOSE_WINDOW_AND_SWITCH_TO_LOGOGAME_HOME, STEPS_BROWSER_STEPS_CLASS_QUALIFIED_NAME, "closeWindowAndSwitchTo", LOGOGAME_KEY, LOGOGAME_HOME);
        exceptionCallbacks.put(CLOSE_ALL_WINDOWS_AND_SWITCH_TO_LOGOGAME_HOME, STEPS_BROWSER_STEPS_CLASS_QUALIFIED_NAME, "closeAllWindowsAndSwitchTo", LOGOGAME_KEY);

        // applications mapping
        applications.put(BAKERY_KEY, new Application(BAKERY_HOME, bakeryHome));
        applications.put(GOOGLE_KEY, new Application(GOOGLE_HOME, googleHome));
        applications.put(LOGOGAME_KEY, new Application(LOGOGAME_HOME, logogameHome));

        Page.setPageMainPackage("com.github.bakery.robot.application.pages.");
    }
    
    /**
     * Get context singleton.
     *
     * @return context instance
     */
    public static Context getInstance() {
        if (instance == null || !(instance instanceof BakeryRobotContext)) {
            instance = new BakeryRobotContext();
        }
        return instance;
    }

    // home getters
    public String getBakeryHome() {
        return bakeryHome;
    }
    public String getGoogleHome() {
        return googleHome;
    }
    public String getLogogameHome() {
        return logogameHome;
    }

}
