package utils;

import config.ApplicationConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FrameworkCore {
    private WebDriver driver;

    public WebDriver getDriver() {
        driver = null;
        switch (ApplicationConfig.BROWSER) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                System.out.println("FF");
                //TODO: add firefox support
                break;
            case OPERA:
                //TODO: add opera support
                break;
            default:
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
                driver = new ChromeDriver();
                break;
        }
        assert driver != null;
        driver.manage().timeouts().implicitlyWait(ApplicationConfig.IMPLICIT_WAIT_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public void openUrl(String url) {
        driver.get(url);
    }

    public void closeBrowser() {
        driver.quit();
    }
}
