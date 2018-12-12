package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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
    
    private static final String TEST_NAME_CALCULATE_ROOM_SURFACE = "Calculate Room Surface";
    private static final String TEST_NAME_CALCULATE_GALLONS_OF_PAINT = "Calculate Gallons of Paint";

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

    @Test(dataProvider = TEST_NAME_CALCULATE_ROOM_SURFACE)
    public void test_CalculateSurfaceArea(int length, int width, int height, int expectedWallarea) {
        System.out.println("Test: " + TEST_NAME_CALCULATE_ROOM_SURFACE);
        
        dimensionsPage = homePage
                .enterNumberOfRooms(1)
                .submitRoomsForm();
        
        resultsPage = dimensionsPage
                .enterLength(1, length)
                .enterWidth(1, width)
                .enterHeight(1, height)
                .submitDimensionsForm();

        Assert.assertEquals(resultsPage.getRoomsSurfaceArea(1), expectedWallarea);
    }

    @Test(dataProvider = TEST_NAME_CALCULATE_GALLONS_OF_PAINT)
    public void test_CalculateGallonsOfPaint(int length, int width, int height, int expectedGallons) {
        System.out.println("Test: " + TEST_NAME_CALCULATE_GALLONS_OF_PAINT);
        
        dimensionsPage = homePage
                .enterNumberOfRooms(1)
                .submitRoomsForm();
        
        resultsPage = dimensionsPage
                .enterLength(1, length)
                .enterWidth(1, width)
                .enterHeight(1, height)
                .submitDimensionsForm();

        Assert.assertEquals(resultsPage.getRoomsGallonsRequired(1), expectedGallons);
    }
    
    @DataProvider(name = TEST_NAME_CALCULATE_ROOM_SURFACE)
    public Object[][] dp_SurfaceArea() {
        Object[][] testData = new Object[][] {
            {1, 1, 1, 4},
            {100, 100, 1, 400},
            {100, 100, 4, 1600},
            {40, 30, 20, 2800},
            {20, 30, 40, 4000}
        };

        return testData;
    }

    @DataProvider(name = TEST_NAME_CALCULATE_GALLONS_OF_PAINT)
    public Object[][] dp_GallonsOfPaint() {
        Object[][] testData = new Object[][] {
            {1, 1, 1, 0.0},
            {50, 50, 1, 1.0},
            {50, 50, 2, 1.0},
            {50, 50, 19, 10.0},
            {40, 30, 20, 7.0},
            {20, 30, 40, 10.0}
        };

        return testData;
    }
    
}
