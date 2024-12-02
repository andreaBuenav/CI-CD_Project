package mainDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainDriver {
    private WebDriver driver;

    public MainDriver( ) {
        String path = System.getProperty("user.dir");
       System.setProperty( "webdriver.chrome.driver", path+ "\\drivers\\chromedriver.exe");
       driver = new ChromeDriver();
    }

    public WebDriver getDriver() {
        return this.driver;
    }
}


