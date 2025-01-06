package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DisagreePage extends BasePage {

    WebElement title = driver.findElement(By.cssSelector("h1"));


    public DisagreePage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
       return super.getText(title);

    }

}
