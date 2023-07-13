package com.tests.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;



public class LoginPage extends BasePage{
    private WebDriver driver;




    @FindBy(xpath = "//input[@placeholder='yours@example.com']")
    WebElement emailField;

    @FindBy(xpath = "//input[@placeholder='your password']")
    WebElement passwd;
    @FindBy(xpath = "//span[@class='auth0-label-submit']")
    WebElement loginButtn;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;


    }

    public ProjectlistPage loginIntoAccount(String email, String psswd) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        waitforElementToBeClickable(emailField);
        emailField.sendKeys(email);
        waitforElementToBeClickable(passwd);
        passwd.sendKeys(psswd);
        waitforElementToBeClickable(loginButtn);
        loginButtn.click();
        return new ProjectlistPage(driver);

    }
}
