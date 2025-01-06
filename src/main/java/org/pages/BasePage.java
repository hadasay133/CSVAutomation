package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        actions = new Actions(driver);
    }





    public void clickOnLinkUsingAction(final String linkText) {
        actions.moveToElement(
                        wait.until(ExpectedConditions.elementToBeClickable(By.linkText(linkText)))
                )
                .click()
                .build()
                .perform();
    }


    public String getText(WebElement webElement){
        wait.until(ExpectedConditions.visibilityOfAllElements(webElement));
       return webElement.getText();

    }

    public void sendKeys(WebElement webElement,String text){

         webElement.sendKeys(text);

    }

    public void clickOnElementUsingAction(WebElement webElement){
        actions.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(webElement)))
                .click()
                .build()
                .perform();

    }

   public void moveToElement( WebElement webElement){
       actions.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(webElement)))
               .build()
               .perform();

   }


}



















