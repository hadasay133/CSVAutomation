package UITest;

import CsvFiles.CSVHandler;
import com.opencsv.exceptions.CsvValidationException;
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

public class TestTask {
    private WebDriver driver;
    private final MainPage MainPage;
    private CSVHandler csvHandler;

    public TestTask() {
        driver = new ChromeDriver();
        csvHandler = new CSVHandler("C:\\Users\\USER\\Documents\\Excels\\Student.csv");
        MainPage = new MainPage(driver);
    }

    @BeforeClass
    public void setUp() {
        driver.manage().window().maximize();
        driver.get("https://www.turnitin.com/newuser_join.asp?svr=6&session-id=af3f072630384dea9a781a729650f8a9&lang=en_us&r=60.0095127327982");
    }


    @Test
    public void checkTheTitle() throws CsvValidationException, IOException {
        StudentPage studentPage = (StudentPage) MainPage.clickOnHrefOfMainPage(HrefOfMainPage.STUDENT);
        studentPage.enterClassId(csvHandler.getWordByNumber(csvHandler.readCSV(),1,0));
        studentPage.clickOnOptionDisplayNames(OptionOfDisplayName.LAST_NOSPACE_FIRST);
        studentPage.selectSecretQuestion("What was the name of the first album that you bought?");
        DisagreePage disagreePage = studentPage.clickOnDisagreeHref();
        String titleOfDisagreePage = disagreePage.getTitle();
        Assert.assertEquals("Empower students to do their best,\n" + "original work", titleOfDisagreePage);


    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}