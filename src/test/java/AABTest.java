import io.netty.util.internal.PriorityQueue;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import org.apache.hc.core5.reactor.Command;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static java.time.Duration.ofSeconds;

public class AABTest extends BaseClass{

    @Test
    public void Tc_001(){
       driver.get("https://www.google.com");
        System.out.println("Google Opened");
    //}
    @Test
    public void Tc_002() throws InterruptedException {
        driver.get("https://tmsit.threatmodeler.us/");
        System.out.println("Threat Model website opened");

        driver.manage().timeouts().implicitlyWait(ofSeconds(TIMEOUT));
        wait = new WebDriverWait(driver, ofSeconds(TIMEOUT));
        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@id=\"Username\"]")).sendKeys("Saurav");
        driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys("Saurav234-");
        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[2]/form/button")).click();

    }
        @Test
        public void Tc_003 () {
            // Create A New user
            driver.findElement(By.xpath("//*[@id=\"guidedTourCheckbox\"]")).click();
            driver.findElement(By.xpath("/html/body/app-root/ngx-guided-tour/div[2]/div/div/div[2]/span[1]/button/i")).click();

        }
    }
