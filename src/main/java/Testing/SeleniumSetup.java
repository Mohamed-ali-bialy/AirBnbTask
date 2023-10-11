package Testing;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class SeleniumSetup {
      public WebDriver driver;
      public  WebDriverWait wait;
    public SeleniumSetup(String web_sit_eurl)
    {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");//set driver
        driver = new ChromeDriver();
        driver.get(web_sit_eurl);
        driver.manage().window().maximize();//maximize window
        //waiting #######
        wait =new WebDriverWait(driver,Duration.ofSeconds(30));//exicitly wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//maximum impicitly wiat of 15 seconds
        //waiting #######
    }
    public SeleniumSetup(String web_sit_eurl,int implicitlyWait,int explicit_wait )
    {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");//set driver
        driver = new ChromeDriver();
        driver.get(web_sit_eurl);
        driver.manage().window().maximize();//maximize window
        //waiting #######
        wait =new WebDriverWait(driver,Duration.ofSeconds(explicit_wait));//exicitly wait selcted by user
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlyWait));//maximum impicitly wiat of 15 seconds
        //waiting #######
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }
    public String get_window_id()
    {
        return driver.getWindowHandle();
    }
}
