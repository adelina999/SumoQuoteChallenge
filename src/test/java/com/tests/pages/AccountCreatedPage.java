package com.tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AccountCreatedPage extends BasePage {
    private WebDriver driver;


    public AccountCreatedPage(WebDriver driver) {
        super(driver);
        this.driver = driver;

    }

    @FindBy(xpath = "//p[@data-v-7a167a29 and contains(text(), 'OK, we sent you an email containing account verification instructions')]")
    private WebElement verificationMessage;

    @FindBy(css = "a[href='/signIn']")
    private WebElement signInLink;


    public void verifyAcoountCreated() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitforElementToBeClickable(verificationMessage);
        Assert.assertTrue(verificationMessage.isDisplayed(), "The element is not displayed.");
    }

    //"//span[@class='auth0-label-submit']"
    public LoginPage gotoLoginPage() {
        waitforElementToBeClickable(signInLink);
        signInLink.click();
        return new LoginPage(driver);
    }
}
