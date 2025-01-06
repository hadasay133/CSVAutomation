package org.pages.mainPage;


import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.WebDriver;
import org.pages.BasePage;
import org.pages.studentPage.StudentPage;

public class MainPage extends BasePage {
    public MainPage( WebDriver driver) {
        super(driver);

    }


    public BasePage clickOnHrefOfMainPage(HrefOfMainPage hrefOfMainPage) {

        super.clickOnLinkUsingAction(hrefOfMainPage.toString());
        switch (hrefOfMainPage) {
            case STUDENT:
                return new StudentPage(driver);
            case TEACHING_ASSISTANT:
                break;
            case INSTRUCTOR:
                break;
            default:
                throw new UnsupportedCommandException("Unsupported hrefOfMainPage" + hrefOfMainPage);
        }
        return null;
    }


}
