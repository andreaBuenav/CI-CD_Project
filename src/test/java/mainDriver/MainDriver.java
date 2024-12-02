package mainDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainDriver {

    private WebDriver driver;

    public MainDriver( ) {

        String browserType = System.getenv("BROWSER_NAME"); // Obtener el nombre del navegador desde la variable de entorno
        String path = System.getProperty("user.dir");
        if (browserType == null || browserType.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", path + "\\drivers\\chromedriver.exe"); // Sin .exe
            driver = new ChromeDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browserType);
        }

    }

    public WebDriver getDriver() {
        return this.driver;
    }
}


