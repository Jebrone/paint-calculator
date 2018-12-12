package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page_Home extends Page_Base {
    
    private static final By NUMBER_OF_ROOMS_FORM = By.cssSelector("[action='dimensions']");
    private static final By ROOMS_INPUT = By.name("rooms");
    private static final By SUBMIT_BUTTON = By.cssSelector("[type='submit']");
    
    public Page_Home(WebDriver driver) {
        super(driver);
    }
    
    public Page_Home visitPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public Page_Home enterNumberOfRooms(int numberOfRooms) {
        driver.findElement(NUMBER_OF_ROOMS_FORM)
                .findElement(ROOMS_INPUT)
                .sendKeys(Integer.toString(numberOfRooms));
        return this;
    }

    public Page_Dimensions submitRoomsForm() {
        driver.findElement(NUMBER_OF_ROOMS_FORM)
                .findElement(SUBMIT_BUTTON)
                .click();
        return new Page_Dimensions(driver);
    }

    
}
