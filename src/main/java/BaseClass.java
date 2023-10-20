import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;

import static java.time.Duration.*;


public class BaseClass {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static final int TIMEOUT = 15;
    @BeforeClass
    public void beforeClass(@Optional("firefox") String browser) throws IOException {

        System.out.println("BeforeClass: Opening browser:" + browser);


        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            options.addArguments("--start-maximized");
            options.addArguments("--remote-allow-origins=*");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
        }else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--incognito");
            options.addArguments("--start-maximized");
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(options);
        }
        else {
            System.out.println("Not a valid browser");
        }

        driver.manage().timeouts().implicitlyWait(ofSeconds(TIMEOUT));
        wait = new WebDriverWait(driver, ofSeconds(TIMEOUT));

    }

}
