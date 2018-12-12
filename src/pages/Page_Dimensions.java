package pages;

import org.openqa.selenium.WebDriver;

public class Page_Dimensions extends Page_Base {

    public Page_Dimensions(WebDriver driver) {
        super(driver);
    }

        // TODO Auto-generated method stub
    public Page_Dimensions enterLength(int roomNumber, int length) {
        return this;
    }

        // TODO Auto-generated method stub
    public Page_Dimensions enterWidth(int roomNumber, int width) {
        return this;
    }

        // TODO Auto-generated method stub
    public Page_Dimensions enterHeight(int roomNumber, int height) {
        return this;
    }

    public Page_Results submitDimensionsForm() {
        // TODO Auto-generated method stub
        return new Page_Results(driver);
    }
    
}
