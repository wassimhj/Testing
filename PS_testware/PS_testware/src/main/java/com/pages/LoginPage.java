package com.pages;

import com.config.Configuration;
import com.util.Commons;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class LoginPage{

    WebDriver driver;
    public Configuration cf;

    /**
     * Here are the objects used on the LoginPage and their Xpaths
     */
    public static String ACCOUNT_ICON = "//span[@class='nav-line-2 ']";
    public static String SIGN_IN_BUTTON = "//span[@class='nav-action-inner']";
    public static String EMAIL_BOX = "//input[@id='ap_email']";
    public static String EMAIL_BUTTON = "//input[@id='continue']";
    public static String PASSWORD_BOX = "//input[@id='ap_password']";
    public static String LOGIN_BUTTON = "//input[@id='signInSubmit']";
    public static String CANCEL_BUTTON = "//a[@id='ap-account-fixup-phone-skip-link']";


    By account_icon = By.xpath(ACCOUNT_ICON);
    By sign_in_button = By.xpath(SIGN_IN_BUTTON);
    By email_box = By.xpath(EMAIL_BOX);
    By email_button = By.xpath(EMAIL_BUTTON);
    By login_button = By.xpath(LOGIN_BUTTON);
    By cancel_button = By.xpath(CANCEL_BUTTON);

    /**
     * Here we will find the methods used on the login page
     */

    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }

    public void GoToLogin(){
        /*driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(account_icon));
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EMAIL_BUTTON)));
        driver.findElement(sign_in_button).click();*/

        driver.findElement(account_icon).click();
        Commons.ImplicitWait(10, driver);
    }

    public void SignIn() throws IOException {
        Commons.ImplicitWait(10, driver);
        Commons.EnterCredentials(cf.getProperties("username"),EMAIL_BOX,driver);
        //System.out.println(cf.getProperties("username"));
        driver.findElement(email_button).click();
        Commons.EnterCredentials(cf.getProperties("password"),PASSWORD_BOX,driver);
        driver.findElement(login_button).click();
        driver.findElement(cancel_button).click();

    }



}
