package mainDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class MainDriver {

    private final WebDriver driver;

    public MainDriver( ) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        String browserType = System.getenv("BROWSER_NAME");
        String path = System.getProperty("user.dir") + File.separator + "drivers" + File.separator;
        String os = System.getProperty("os.name").toLowerCase();

        if (browserType == null || browserType.equalsIgnoreCase("chrome")) {
            if (os.contains("win")) {
                System.setProperty("webdriver.chrome.driver", path + "chromedriver.exe");
            } else if (os.contains("nix") || os.contains("nux")) { // Para Linux
                System.setProperty("webdriver.chrome.driver", path + "chromedriver");
            } else {
                throw new IllegalArgumentException("Unsupported operating system: " + os);
            }
            driver = new ChromeDriver(options);
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browserType);
        }
    }


    public WebDriver getDriver() {
        return this.driver;
    }
}


