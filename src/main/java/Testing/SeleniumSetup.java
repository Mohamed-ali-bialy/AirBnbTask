package Testing;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class SeleniumSetup {
      public WebDriver driver;
      public  WebDriverWait wait;
    public SeleniumSetup(String web_sit_eurl)
    {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");//set driver
        driver = new ChromeDriver();
        driver.get(web_sit_eurl);//get url
        driver.manage().window().maximize();//maximize window
        wait =new WebDriverWait(driver,Duration.ofSeconds(30));//exicitly wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//maximum impicitly wiat of 5 seconds
    }
    public SeleniumSetup(String web_sit_eurl,int implicitlyWait,int explicit_wait )
    {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");//set driver
        driver = new ChromeDriver();
        driver.get(web_sit_eurl);
        driver.manage().window().maximize();//maximize window
        wait =new WebDriverWait(driver,Duration.ofSeconds(explicit_wait));//exicitly wait selcted by user
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlyWait));//impicitly wiat  selcted by user
    }

    public WebDriver getDriver() {return driver;}//webdriver getter

    public WebDriverWait getWait() {
        return wait;
    }//WebDriverWait getter
    public String get_window_id() {return driver.getWindowHandle();}//window id getter
    public Set<String> get_windows_id() {return driver.getWindowHandles();}//windows id getter
}
