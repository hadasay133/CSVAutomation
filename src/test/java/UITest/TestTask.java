package UITest;


import CsvFiles.CSVHandler;
import com.opencsv.exceptions.CsvValidationException;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pages.mainPage.HrefOfMainPage;
import org.pages.mainPage.MainPage;
import org.pages.studentPage.OptionOfDisplayName;
import org.pages.studentPage.StudentPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class TestTask {
    MainPage mainPage;
    CSVHandler csvHandler;
    WebDriver driver;

    public TestTask() {

    }

    @BeforeClass
    public void setUp() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        csvHandler = new CSVHandler("C:\\Users\\USER\\Documents\\Excels\\Student.csv");
        mainPage = new MainPage(driver);
        driver.manage().window().maximize();
        driver.get("https://www.turnitin.com/newuser_join.asp?svr=6&session-id=af3f072630384dea9a781a729650f8a9&lang=en_us&r=60.0095127327982");
    }


    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Feature("UI Flow")
    @Description("check the title of page - UI flow")
    public void TestCheckTheTitle() throws CsvValidationException, IOException {
        StudentPage studentPage = (StudentPage) mainPage.clickOnHrefOfMainPage(HrefOfMainPage.STUDENT);
        studentPage.enterClassId(csvHandler.getWordByNumber(csvHandler.readCSV(), 1, 0));
        studentPage.clickOnOptionDisplayNames(OptionOfDisplayName.LAST_NOSPACE_FIRST);
        studentPage.selectSecretQuestion("What was the name of the first album that you bought?");
        DisagreePage disagreePage = studentPage.clickOnDisagreeHref();
        String titleOfDisagreePage = disagreePage.getTitle();
        Assert.assertEquals("Bring transparency to the writing process with Turnitin Clarity", titleOfDisagreePage);

    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}