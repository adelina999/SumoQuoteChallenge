package com.tests.pages;

import com.github.javafaker.Faker;
import com.tests.utilities.AccountProfile;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Locale;


public class SignupPage extends BasePage {

    private WebDriver driver;
    AccountProfile accountProfile = new AccountProfile();
    Faker faker = new Faker(new Locale("en-CA"));

    //JavascriptExecutor executor = (JavascriptExecutor) driver;

    public SignupPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(css = ".v-input input#accountName")
    private WebElement accountname;

    @FindBy(css = "input[id=\"firstName\"]")
    private WebElement firstname;

    @FindBy(css = "input[id=\"lastName\"]")
    private WebElement lastname;

    @FindBy(css = "input[id=\"emailAddress\"]")
    private WebElement emailAdress;

    @FindBy(css = "input[id=\"phoneNumber\"]")
    private WebElement phoneNumber;

    @FindBy(css = "input[id=\"Password\"]")
    private WebElement password1;

    @FindBy(css = "input[id=\"repeatPassword\"]")
    private WebElement repeatPassword;

    @FindBy(css = "[class=\"v-input__icon v-input__icon--append\"]")
    private WebElement howHeard;

    @FindBy(xpath = "//div[contains(text(),'Certainteed')]")
    private WebElement howHeard_selection;

    @FindBy(css = "[class='v-input--selection-controls__ripple']")
    private WebElement acceptingTerms;

    @FindBy(css = "[class='btn-sumo-primary v-btn v-btn--has-bg theme--light elevation-0 v-size--default']")
    private WebElement saveButton;

    public AccountCreatedPage fillTestData() throws InterruptedException {
       //Filling all the fields and saving the form will redirect the user to Account created page
        String CreatedPassword = password();
        getRandomTestPRofile(CreatedPassword);
        //System.out.println(accountProfile.getOrgName());
        accountname.sendKeys(accountProfile.getOrgName());
        firstname.sendKeys(accountProfile.getFirstName());
        lastname.sendKeys(accountProfile.getLastName());
        emailAdress.sendKeys(accountProfile.getEmail());
        phoneNumber.sendKeys(accountProfile.getPhoneNumber());
        password1.sendKeys(CreatedPassword);
        repeatPassword.sendKeys(CreatedPassword);

        scrollintoView();
        Thread.sleep(1000);
        scrollintoView(howHeard);
        //choose how you heard from the list
        waitforElementToBeClickable(howHeard);
        howHeard.click();
        waitforElementToBeClickable(howHeard_selection);
        howHeard_selection.click();

        // Click on the element with CSS selector for accepting terms and conditions
        waitforElementToBeClickable(acceptingTerms);
        acceptingTerms.click();

        // Wait for the Save button to be clickable
        waitforElementToBeClickable(saveButton);
        saveButton.click();
        return new AccountCreatedPage(driver);

    }

    public String password() {
        //Generating password based on the specified requirements
        int minimumLength = 8;
        boolean includeUppercase = true;
        boolean includeDigit = true;


        String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
        String uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String digitChars = "0123456789";
        String specialChars = "!@#$%^&*";

        // Generate a random password with the specified criteria
        String password = RandomStringUtils.random(minimumLength, includeUppercase, includeDigit);
        //add lowercase
        password += RandomStringUtils.random(1, lowercaseChars);
        //add uppercase
        password += RandomStringUtils.random(1, uppercaseChars);
        //add digit
        password += RandomStringUtils.random(1, digitChars);
        //add special char
        password += RandomStringUtils.random(1, specialChars);
        //System.out.println(password);
        return password;
    }

    public AccountProfile retrieveAccountProfile() {
        //retreving the account profile details for further use
        AccountProfile retrieveProfile = accountProfile.getAccountProfile();
        //System.out.println(retrieveProfile.getOrgName());
        return retrieveProfile;
    }

    private String generateEmail() {
        //This code generate fake email
        String domain = "gmail.com";
        int usernameLength = 8;

        String username = RandomStringUtils.randomAlphanumeric(usernameLength).toLowerCase();
        String fakeEmail = username + "@" + domain;
        // System.out.println(fakeEmail);
        return fakeEmail;
    }

    private void getRandomTestPRofile(String password) {
        //using Faker library to generate new fake data for the account
        accountProfile.setOrgName(faker.company().name());
        accountProfile.setFirstName(faker.name().firstName());
        accountProfile.setLastName(faker.name().lastName());
        accountProfile.setPhoneNumber(faker.phoneNumber().cellPhone());
        accountProfile.setEmail(generateEmail());
        accountProfile.setPassword(password);
    }

}

