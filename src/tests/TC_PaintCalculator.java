package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.Page_Dimensions;
import pages.Page_Home;
import pages.Page_Results;

public class TC_PaintCalculator {
    private WebDriver driver;
    private Page_Home homePage;
    private Page_Dimensions dimensionsPage;
    private Page_Results resultsPage;

    @BeforeTest
    public void setup_InitializeDriver() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    
    @AfterTest
    public void teardown_CloseDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
    
    @BeforeMethod
    public void setup_GoToHomePage() {
        homePage = new Page_Home(driver);
        homePage.visitPage();
    }
    
    @Test(dataProvider = "Calculate Results for a Room")
    public void test_CalculateResultsForRoom(int length, int with, int height, 
            int expectedWallarea, double expectedGallonsOfPaint) {
    }
    
    @DataProvider(name = "Calculate Results for a Room")
    public Object[][] dp_CalculateResultsForRoom() {
        Object[][] testData = new Object[][] {
            {10, 10, 1, 100, 0.0},
            {10, 40, 1, 400, 1.0},
            {10, 40, 2, 800, 2.0},
            {10, 40, 3, 1200, 3.0},
            {30, 40, 20, 24000, 3.0}
        };
        
        return testData;
    }
    
}
