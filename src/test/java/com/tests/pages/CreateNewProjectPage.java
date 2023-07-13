package com.tests.pages;

import com.tests.utilities.AccountProfile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewProjectPage extends BasePage {
    WebDriver driver;
   // private AccountProfile accountProfile;

    public CreateNewProjectPage(WebDriver driver) {
       super(driver);
        this.driver = driver;

    }

    @FindBy(xpath ="//div[contains(@class, 'v-text-field__slot')]/input[@id='input-text-field']")
    private WebElement firstname;

    @FindBy(xpath = "//div[contains(@class, 'v-text-field__slot')]/input[@id='input-text-field' and @data-gtm-form-interact-field-id='1']")
    private WebElement lastname;

    public void createNewProject( AccountProfile accountProfile){
      //  System.out.println(accountProfile.getFirstName());
       //Find the input fields and populate with values from the account profile object that is being passed
        waitforElementToBeClickable(firstname);
        firstname.sendKeys(accountProfile.getFirstName());
       /* waitforElementToBeClickable(lastname);
        lastname.sendKeys(accountProfile.getLastName());*/






    }
}
