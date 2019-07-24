/**
 * BakeryRobot generated free by NoraUi Organization https://github.com/NoraUi
 * BakeryRobot is licensed under the license BSD.
 * 
 * CAUTION: BakeryRobot use NoraUi library. This project is licensed under the license GNU AFFERO GENERAL PUBLIC LICENSE 
 * 
 * @author Nicolas HALLOUIN
 * @author Stéphane GRILLON
 */
package com.github.bakery.robot.application.pages.bakery;

import static com.github.noraui.utils.Context.BAKERY_KEY;
import static com.github.noraui.utils.Context.BAKERY_REF;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.noraui.application.page.Page;
import com.github.noraui.exception.Callbacks;
import com.github.noraui.utils.Context;
import com.github.noraui.utils.Utilities;

public class ReferencerPage extends Page {

    /**
     * Specific logger
     */
    protected static final Logger logger = LoggerFactory.getLogger(ReferencerPage.class);

    public final PageElement titleMessage = new PageElement("-title_message");
    public final PageElement signOutMenu = new PageElement("-signout_menu");

    public ReferencerPage() {
        super();
        this.application = BAKERY_KEY;
        this.pageKey = BAKERY_REF;
        this.callBack = Context.getCallBack(Callbacks.CLOSE_WINDOW_AND_SWITCH_TO_BAKERY_HOME);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean checkPage(Object... elements) {
        try {
            Context.waitUntil(ExpectedConditions.visibilityOfElementLocated(Utilities.getLocator(titleMessage)));
            return true;
        } catch (Exception e) {
            logger.error("signIn message not found", e);
            return false;
        }
    }

}
