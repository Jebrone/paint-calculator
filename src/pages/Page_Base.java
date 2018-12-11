package pages;

import org.openqa.selenium.WebDriver;

public class Page_Base {

    public static final String BASE_URL = "http://127.0.0.1:5000/";
    public WebDriver driver;
    
    public Page_Base(WebDriver driver) {
        this.driver = driver;
    }
    
}
