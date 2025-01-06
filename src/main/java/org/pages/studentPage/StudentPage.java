package org.pages.studentPage;

import org.openqa.selenium.By;
import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.pages.BasePage;
import org.pages.DisagreePage;

public class StudentPage extends BasePage {

    WebElement title = driver.findElement(By.cssSelector("div[id='ibox_form'] div"));
    WebElement classId = driver.findElement(By.cssSelector("input[id='id']"));
    WebElement firstOptionRadioButton = driver.findElement(By.cssSelector("label[for='first_space_last'] "));
    WebElement secondOptionRadioButton = driver.findElement(By.cssSelector("label[for='last_space_first']"));
    WebElement thirdOptionRadioButton = driver.findElement(By.cssSelector("label[for='last_nospace_first']"));
    WebElement secretQuestion = driver.findElement(By.cssSelector("div[class='ip_valid_inidicator '] select"));



    public StudentPage(WebDriver driver) {
        super(driver);
    }


    public String getTitleText() {
        return super.getText(title);
    }

    public void enterClassId(String text) {
        super.sendKeys(classId, text);
    }

    public void clickOnOptionDisplayNames(OptionOfDisplayName optionOfDisplayName) {
        switch (optionOfDisplayName) {
            case FIRST_SPACE_LAST:
                clickOnElementUsingAction(firstOptionRadioButton);
                break;
            case LAST_SPACE_FIRST:
                super.clickOnElementUsingAction(secondOptionRadioButton);
                break;
            case LAST_NOSPACE_FIRST:
                super.clickOnElementUsingAction(thirdOptionRadioButton);
                break;
            default:
                throw new UnsupportedCommandException("Unsupported optionOfDisplayName" + optionOfDisplayName);
        }

    }



    public void selectSecretQuestion(String option) {
        super.moveToElement(secretQuestion);
        Select s = new Select(secretQuestion);
        s.selectByVisibleText(option);

    }


    public DisagreePage clickOnDisagreeHref() {
        super.clickOnLinkUsingAction("I Disagree -- Cancel Profile");
        return new DisagreePage(driver);
    }
}
