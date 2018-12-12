package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page_Home extends Page_Base {

    public Page_Home(WebDriver driver) {
        super(driver);
    }
    
    public Page_Home visitPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public Page_Home enterNumberOfRooms(int i) {
        // TODO Auto-generated method stub
        return this;
    }

    public Page_Dimensions submitRoomsForm() {
        // TODO Auto-generated method stub
        return new Page_Dimensions(driver);
    }

    
}
