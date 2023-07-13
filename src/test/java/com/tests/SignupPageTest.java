package com.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.tests.pages.*;
import com.tests.utilities.AccountProfile;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class SignupPageTest {
    public ExtentReports extent;
    public ExtentTest test;
    private WebDriver driver;

    private SignupPage signupPage;
    private CreateNewProjectPage createNewProjectPage;

    private AccountCreatedPage accountCreatedPage;
    public AccountProfile accountProfile = new AccountProfile();

    private ProjectlistPage projectlistPage;

    private LoginPage loginPage;


    @BeforeClass
    public void setUp() {

        //Webdriver manager allows to run the test with the required browser
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.chromedriver().setup();
        driver = new FirefoxDriver();
        // Specify the location and file name of the report
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("reports/ExtentReport.html");

        // Create an ExtentReports object and attach the HTML reporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);


    }

    @Test(enabled = true)
    public void SignupTest() throws Exception {
        test = extent.createTest("SignupTest", "User create new account, then he performs a login and clicks on Create new order");
        driver.get("https://sumoquoteweb-qa.azurewebsites.net/new-account");
        signupPage = new SignupPage(driver);
        signupPage.fillTestData()
                .verifyAcoountCreated();
        accountCreatedPage = new AccountCreatedPage(driver);
        accountCreatedPage.gotoLoginPage();


    }

    @Test(enabled = true)
    public void LoginTest() throws Exception {
        test = extent.createTest("LoginTest", "User create new account, then he performs a login and clicks on Create new order");

        driver.get("https://sumoquoteweb-qa.azurewebsites.net/new-account");
        String emailAddres = "adeletest5@gmail.com";
        String correctPassword = "P@ssw0rd";
        signupPage = new SignupPage(driver);
        signupPage.fillTestData()
                .verifyAcoountCreated();
        accountCreatedPage = new AccountCreatedPage(driver);
        accountCreatedPage.gotoLoginPage();
        accountProfile = signupPage.retrieveAccountProfile();

        loginPage = new LoginPage(driver);
        loginPage.loginIntoAccount(emailAddres, correctPassword)
                .verifyLoginSuccessful();

        projectlistPage = new ProjectlistPage(driver);
        projectlistPage.startNewProject();

        createNewProjectPage = new CreateNewProjectPage(driver);
        createNewProjectPage.createNewProject(accountProfile);
//        System.out.println(accountProfile.getEmail());

    }

    @AfterClass
    public void tearDown() {
        driver.quit();

    }

}
