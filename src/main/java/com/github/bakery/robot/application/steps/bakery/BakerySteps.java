/**
 * BakeryRobot generated free by NoraUi Organization https://github.com/NoraUi
 * BakeryRobot is licensed under the license BSD.
 * 
 * CAUTION: BakeryRobot use NoraUi library. This project is licensed under the license GNU AFFERO GENERAL PUBLIC LICENSE
 */
package com.github.bakery.robot.application.steps.bakery;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.noraui.application.steps.Step;
import com.github.noraui.browser.Auth;
import com.github.noraui.exception.FailureException;
import com.github.noraui.exception.Result;
import com.github.noraui.exception.TechnicalException;
import com.github.noraui.utils.Context;
import com.github.noraui.utils.Messages;
import com.github.noraui.utils.Utilities;
import com.google.inject.Inject;
import com.github.bakery.robot.application.pages.bakery.BakeryPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BakerySteps extends Step {
    
    /**
     * Specific logger
     */
    private static final Logger logger = LoggerFactory.getLogger(BakerySteps.class);

    @Inject
    private BakeryPage bakeryPage;
   
   /**
    * Check Login page.
    *
    * @throws FailureException
    *             if the scenario encounters a functional error.
    */
   @Then("The BAKERY home page is displayed")
   public void checkBakeryLoginPage() throws FailureException {
       if (!bakeryPage.checkPage()) {
           new Result.Failure<>(bakeryPage.getApplication(), Messages.getMessage(Messages.FAIL_MESSAGE_UNKNOWN_CREDENTIALS), true, bakeryPage.getCallBack());
       }
   }
   
   /**
    * Log in to BAKERY without BakeryRobot (login and password in Gherkin scenario).
    *
    * @param login
    *            Login to use.
    * @param password
    *            Password to use.
    * @throws FailureException
    *             if the scenario encounters a functional error.
    */
   @When("I log in to BAKERY as {string} {string}")
   public void logInToBakery(String login, String password) throws FailureException {
       logger.debug("logIn to Bakery with login [{}] and password [{}].");
       try {
           Utilities.findElement(bakeryPage.accountMenu).click();
           Context.waitUntil(ExpectedConditions.presenceOfElementLocated(Utilities.getLocator(bakeryPage.signinMenu))).click();
           Context.waitUntil(ExpectedConditions.presenceOfElementLocated(Utilities.getLocator(bakeryPage.signInButton)));
           Utilities.findElement(bakeryPage.login).sendKeys(login);
           Utilities.findElement(bakeryPage.password).sendKeys(getTextOrKey(password));
           Utilities.findElement(bakeryPage.signInButton).click();
       } catch (Exception e) {
           new Result.Failure<>(e, Messages.getMessage(Messages.FAIL_MESSAGE_UNKNOWN_CREDENTIALS), true, bakeryPage.getCallBack());
       }
   }
   
   /**
    * Check Bakery portal page.
    *
    * @throws FailureException
    *             if the scenario encounters a functional error.
    */
   @Then("The BAKERY portal is displayed")
   public void checkBakeryPage() throws FailureException {
       try {
           Context.waitUntil(ExpectedConditions.presenceOfElementLocated(Utilities.getLocator(bakeryPage.signInMessage)));
           if (!bakeryPage.isDisplayed()) {
               logInToBakeryWithBakeryRobot();
           }
           if (!bakeryPage.checkPage()) {
               new Result.Failure<>(bakeryPage.getApplication(), Messages.getMessage(Messages.FAIL_MESSAGE_UNKNOWN_CREDENTIALS), true, bakeryPage.getCallBack());
           }
       } catch (Exception e) {
           new Result.Failure<>(bakeryPage.getApplication(), Messages.getMessage(Messages.FAIL_MESSAGE_UNKNOWN_CREDENTIALS), true, bakeryPage.getCallBack());
       }    
       Auth.setConnected(true);
   }
   
   /**
    * Logout of Bakery.
    *
    * @throws FailureException
    *             if the scenario encounters a functional error.
    * @throws TechnicalException
    *             is thrown if you have a technical error (format, configuration, datas, ...) in NoraUi.
    */
   @When("I log out of BAKERY")
   public void logOutOfBakery() throws FailureException, TechnicalException {
       if (Auth.isConnected()) {
           getDriver().switchTo().defaultContent();
           clickOn(bakeryPage.accountMenu);
           Context.waitUntil(ExpectedConditions.presenceOfElementLocated(Utilities.getLocator(bakeryPage.signoutMenu))).click();
       }
   }
   
   /**
   * Check Logout page.
   */
  @Then("The BAKERY logout page is displayed")
  public void checkBakeryLogoutPage() {
      bakeryPage.checkPage();
  }
  
  /**
   * Log in to BAKERY with BakeryRobot (login and password in job parameters).
   *
   * @throws FailureException
   *             if the scenario encounters a functional error.
   */
  private void logInToBakeryWithBakeryRobot() throws FailureException {
      String login = Auth.getLogin();
      String password = Auth.getPassword();
      if (!"".equals(login) && !"".equals(password)) {
          logInToBakery(login, password);
      }
  }

}
