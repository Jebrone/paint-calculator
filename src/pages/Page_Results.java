package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Page_Results extends Page_Base {
    
    private static final By RESULTS_TABLE = By.name("Results");
    private static final By ROOM_ROW = By.id("room_row");
    private static final By WALL_SURFACE_AREA = By.id("wall_space");
    private static final By WALL_REQUIRED_GALLONS = By.id("required_gallons");

    public Page_Results(WebDriver driver) {
        super(driver);
    }

    public int getRoomsSurfaceArea(int roomNumber) {
        String surfaceArea = getRoomRow(roomNumber)
                .findElement(WALL_SURFACE_AREA)
                .getText();
        return Integer.parseInt(surfaceArea);
    }

    public double getRoomsGallonsRequired(int roomNumber) {
        String gallonsRequired = getRoomRow(roomNumber)
                .findElement(WALL_REQUIRED_GALLONS)
                .getText();
        return Double.parseDouble(gallonsRequired);
    }

    private WebElement getRoomRow(int roomNumber) {
        return driver.findElement(RESULTS_TABLE)
                .findElements(ROOM_ROW).get(roomNumber - 1);
    }
}
