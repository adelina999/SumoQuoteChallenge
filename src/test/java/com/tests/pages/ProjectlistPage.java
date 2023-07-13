package com.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ProjectlistPage extends BasePage{


    private WebDriver driver;

    public ProjectlistPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(css = "button.btn.btn-sumo-primary")
    WebElement footer;

    @FindBy(xpath = "//div[@data-v-b11191ac='']//span[text()='Create new project']")
    WebElement CreateNewButton;

//Verify you are being redirected to project list page
    public void verifyLoginSuccessful() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        String expectedUrl = "https://sumoquoteweb-qa.azurewebsites.net/project-list";


        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, expectedUrl);

    }

 /*  THIS CODE WILL WORK WITH CHROME AS A WORK AROUND
    public CreateNewProjectPage startNewProject() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "const element = document.evaluate(\"//div[@data-v-b11191ac='']//span[text()='Create new project']\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;"
                + "if (element) {"
                + "  element.click();"
                + "} else {"
                + "  console.log('Element not found');"
                + "}";
        js.executeScript(script);
        return new CreateNewProjectPage(driver);
    }*/

    //Clicking on start a new project link will open a new project order page
    public CreateNewProjectPage startNewProject() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By buttnElement = By.xpath("//div[@data-v-b11191ac='']//span[text()='Create new project']");
        Thread.sleep(1000);
        WebElement CreateNewButton = driver.findElement(buttnElement);
        CreateNewButton.click();
        return new CreateNewProjectPage(driver);
    }


}
