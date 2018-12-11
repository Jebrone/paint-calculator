package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_PaintCalculator {
    
    @Test(dataProvider = "Calculate Results for a Room")
    public void test_CalculateResultsForRoom(int length, int with, int height, 
            int expectedWallarea, double expectedGallonsOfPaint) {
        // TODO Create Test
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
