package pages;

import org.openqa.selenium.WebDriver;

public class Page_Dimensions extends Page_Base {

    public Page_Dimensions(WebDriver driver) {
        super(driver);
    }

    public Page_Dimensions enterLength(int length) {
        // TODO Auto-generated method stub
        return this;
    }

    public Page_Dimensions enterWidth(int width) {
        // TODO Auto-generated method stub
        return this;
    }

    public Page_Dimensions enterHeight(int height) {
        // TODO Auto-generated method stub
        return this;
    }

    public Page_Results submitDimensionsForm() {
        // TODO Auto-generated method stub
        return new Page_Results(driver);
    }
    
}
