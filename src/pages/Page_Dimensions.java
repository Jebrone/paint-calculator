package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Page_Dimensions extends Page_Base {

    private static final By ROOM_DIMENSIONS_FORM = By.cssSelector("form[action='results']");
    private static final By DIMENSIONS_TABLE = By.name("dimensions_table");
    private static final By ROOM_INFO_INPUT_ROW = By.id("room_row_input");
    private static final By LENGTH_INPUT = By.id("length");
    private static final By WIDTH_INPUT = By.id("width");
    private static final By HEIGHT_INPUT = By.id("height");
    private static final By SUBMIT_BUTTON = By.cssSelector("[type='submit']");

    public Page_Dimensions(WebDriver driver) {
        super(driver);
    }

    public Page_Dimensions enterLength(int roomNumber, int length) {
        getRoomRow(roomNumber)
                .findElement(LENGTH_INPUT)
                .sendKeys(Integer.toString(length));
        return this;
    }

    public Page_Dimensions enterWidth(int roomNumber, int width) {
        getRoomRow(roomNumber)
                .findElement(WIDTH_INPUT)
                .sendKeys(Integer.toString(width));
        return this;
    }

    public Page_Dimensions enterHeight(int roomNumber, int height) {
        getRoomRow(roomNumber)
                .findElement(HEIGHT_INPUT)
                .sendKeys(Integer.toString(height));
        return this;
    }
    
    private WebElement getRoomRow(int roomNumber) {
        return driver.findElement(DIMENSIONS_TABLE)
                .findElements(ROOM_INFO_INPUT_ROW).get(roomNumber - 1);
    }

    public Page_Results submitDimensionsForm() {
        driver.findElement(ROOM_DIMENSIONS_FORM)
                .findElement(SUBMIT_BUTTON)
                .click();
        return new Page_Results(driver);
    }
    
}
