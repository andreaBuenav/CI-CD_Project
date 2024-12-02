package mainDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class MainDriver {

    private WebDriver driver;

    public MainDriver( ) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        String browserType = System.getenv("BROWSER_NAME");
        String path = System.getProperty("user.dir");
        if (browserType == null || browserType.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", path + File.separator + "drivers" + File.separator + "chromedriver");
            driver = new ChromeDriver(options);
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browserType);
        }

    }

    public WebDriver getDriver() {
        return this.driver;
    }
}


