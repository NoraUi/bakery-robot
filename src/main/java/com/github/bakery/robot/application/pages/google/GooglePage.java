/**
 * BakeryRobot generated free by NoraUi Organization https://github.com/NoraUi
 * BakeryRobot is licensed under the license BSD.
 * CAUTION: BakeryRobot use NoraUi library. This project is licensed under the license GNU AFFERO GENERAL PUBLIC LICENSE
 * 
 * @author Nicolas HALLOUIN
 * @author Stéphane GRILLON
 */
package com.github.bakery.robot.application.pages.google;

import static com.github.bakery.robot.utils.BakeryRobotContext.GOOGLE_KEY;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.bakery.robot.utils.BakeryRobotContext;

import com.github.noraui.application.page.Page;
import com.github.noraui.utils.Context;

public class GooglePage extends Page {

    /**
     * Specific LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(GooglePage.class);

    private static final String TITLE_PAGE = "Google";

    public GooglePage() {
        super();
        this.application = GOOGLE_KEY;
        this.pageKey = "GOOGLE_HOME";
        this.callBack = Context.getCallBack(BakeryRobotContext.CLOSE_WINDOW_AND_SWITCH_TO_GOOGLE_HOME);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean checkPage(Object... elements) {
        try {
            Context.waitUntil(ExpectedConditions.not(ExpectedConditions.titleIs("")));
            if (!TITLE_PAGE.equals(getDriver().getTitle())) {
                LOGGER.error("HTML title is not good");
                return false;
            }
            return true;
        } catch (Exception e) {
            LOGGER.error("HTML title Exception", e);
            return false;
        }
    }

}
