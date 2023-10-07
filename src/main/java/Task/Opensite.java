package Task;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import Task.DateAfter_N_Days;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Date;
import java.util.Set;

public class Opensite {
    public static void  main(String[] args )
    {

    String location, city, countery;//location
    city = "Rome";
    countery = "italy";
    location = city + ", " + countery;

    Date currentDate = new Date();//get current date
    DateAfter_N_Days day = new DateAfter_N_Days();// creat obj
    currentDate = day.getDateAfterNDays(currentDate, 7);//get date after 7 days(check in date)
    String checkindate = day.formatDate(currentDate) + " ";//get string of check in date
    String checkinday = day.Onlyday(currentDate);//calculate checkin day


    currentDate = day.getDateAfterNDays(currentDate, 7);//get date after 14 days
    String checkoutdate = day.formatDate(currentDate) + " ";//get string of check out date
    String checkoutday = day.Onlyday(currentDate);//calculate checkout day


    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");//set driver
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.airbnb.com");//open airbnb website
    driver.manage().window().maximize();//maximize window

     //waiting #######
    WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(30));
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//maximum impicitly wiat of 15 seconds
     //waiting #######

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class=\"f12fak3r dir dir-ltr\"]"))).click();//click on search bottom
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    driver.findElement(By.cssSelector("[id=\"bigsearch-query-location-input\"]")).sendKeys(location);//send location
    driver.findElement(By.cssSelector("[id=\"bigsearch-query-location-input\"]")).sendKeys(Keys.RETURN);//click enter


    String cssSelector = String.format("[aria-label=\"%s\"]", checkindate);//set foramt of check in date
    driver.findElement(By.cssSelector(cssSelector)).click();//click on check in date
    String cssSelector2 = String.format("[aria-label=\"%s\"]", checkoutdate);//set foramt of check out date
    driver.findElement(By.cssSelector(cssSelector2)).click();//click check out date

    driver.findElement(By.cssSelector("[class=\"pz9siyu pk4ruxu dir dir-ltr\"]")).click();//guest bottom


    driver.findElement(By.cssSelector("[data-testid=\"stepper-adults-increase-button\"]")).click();//add adlut
    driver.findElement(By.cssSelector("[data-testid=\"stepper-adults-increase-button\"]")).click();//add adlut
    driver.findElement(By.cssSelector("[data-testid=\"stepper-children-increase-button\"]")).click();//add child
    driver.findElement(By.cssSelector("[data-testid=\"structured-search-input-search-button\"]")).click();//click search


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[5]/div/div/div[1]/div/div[2]/div[2]/main/div[2]/div/div[1]/div/div/div/section/h1/span")));
        String header = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div/div[2]/div[2]/main/div[2]/div/div[1]/div/div/div/section/h1/span")).getText();//get text of header results
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    boolean searchreult = header.contains(city);
    if (searchreult)//check match between result head and input data
    {
        System.out.println("Result of search header contains " + city);
    }//matching
    else {
        System.out.println("Error! the header result dose not search criteria");
    }//error no matching

    String PlaceInFilterArea = driver.findElement(By.xpath("//html/body/div[5]/div/div/div[1]/div/div[2]/div[1]/div[1]/div/div/header/div/div[2]/div[1]/div/span[2]/button[1]/div")).getText();//get text from filter area
    boolean bol_PlaceInFilter = PlaceInFilterArea.contains(city);//chek matching
    if (bol_PlaceInFilter) {
        System.out.println("Filter contains " + PlaceInFilterArea + " city");
    }//matching
    else {
        System.out.println("Error! the place in filter area dose not search criteria");
    }//error no matching


    String checkinday_fltr = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div/div[2]/div[1]/div[1]/div/div/header/div/div[2]/div[1]/div/span[2]/button[2]/div")).getText();// get checkin day
    boolean bol_checkinday_fltr = checkinday_fltr.contains(checkinday);
    if (bol_checkinday_fltr)//check matching
    {
        System.out.println("Filter contains correct check in day " + checkinday);
    }//matching
    else {
        System.out.println("Error! the check in day in filter area dose not search criteria");
    }//error no matching


    String checkoutday_fltr = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div/div[2]/div[1]/div[1]/div/div/header/div/div[2]/div[1]/div/span[2]/button[2]/div")).getText();//checkout day
    boolean bol_checkoutday_fltr = checkoutday_fltr.contains(checkoutday);
    if (bol_checkoutday_fltr)//check matching
    {
        System.out.println("Fllter contains correct check in day " + checkoutday);
    }//matching
    else {
        System.out.println("Error! the check out day in filter area dose not search criteria");
    }//error no matching


    String GuesntNumb_fltr = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div/div[2]/div[1]/div[1]/div/div/header/div/div[2]/div[1]/div/span[2]/button[3]/div[1]")).getText();//get guest number from fillter
    boolean bol_gesntnumb_fltr = GuesntNumb_fltr.contains("3");
    if (bol_gesntnumb_fltr)//check matching
    {
        System.out.println("Filter contains  " + GuesntNumb_fltr);
    }//matching
    else {
        System.out.println("Error! the number of guestes  in filter area dose not search criteria");
    }//error no matching

    if (searchreult && bol_PlaceInFilter && bol_checkinday_fltr && bol_checkoutday_fltr && bol_gesntnumb_fltr) {
        System.out.println("The results match the search criteria....(Test 1 Done)");
    }//matching}



    //########## Task 2
        System.out.println("===========================");
        System.out.println("Begin of Test 2");
        System.out.println("");

    driver.findElement(By.cssSelector("[data-testid=\"category-bar-filter-button\"]")).click();//click on filter bottom



    driver.findElement(By.cssSelector("[data-testid=\"menuItemButton-5\"]")).click();//select number of bedrooms
    driver.findElement(By.cssSelector("[class=\"l1ovpqvx b1uxatsa c1qih7tm dir dir-ltr\"]")).click();//click on show more
    driver.findElement(By.cssSelector("[data-testid=\"filter-item-amenities-7\"]")).click();//select pool choice
    driver.findElement(By.cssSelector("[class=\"l1ovpqvx bmx2gr4 c1ih3c6 dir dir-ltr\"]")).click();//click show stays


    WebElement outerDiv = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div/div[2]/div[2]/main/div[2]/div/div[2]/div/div/div/div/div[1]"));
    List<WebElement> innerDivs = outerDiv.findElements(By.cssSelector("[class=\"c4mnd7m dir dir-ltr\"]"));//displayed elements

    int containsbedroomcounter=0;//count the number of correct displayed property
    int generalcounter=0;// general counter
       for (WebElement element : innerDivs) {
           try {
               generalcounter++;
            boolean bedrooms=false;
            boolean leastnumber=false;
            boolean wrongtext=false;
           WebElement target = element.findElement(By.cssSelector("div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(3) > span:nth-child(2) > span:nth-child(3)"));//text contain number of bedrooms
           String spanText = target.getText();//text contain number of bedrooms

           if(spanText.contains("bedrooms"))
           {
               bedrooms=true;//text contains bedrooms
           }
           else {
               System.out.println("Error! property number: "+generalcounter+" doesn't display bedroom word.");//does not contain bedroom word
               wrongtext=true;//there is a wrong word
           }
           if((bedrooms)&&(!wrongtext))//if text contains bedroom and no wrong word
           {
               IntegerExtractor extractor=new IntegerExtractor();
               int x= extractor.extractIntegerFromString(spanText);//extract integer from text
               if(x>=5)
               {leastnumber=true;}//contains least number of bedrooms
               else {System.out.println("Error! property number: "+generalcounter+" doesn't have least number of bedrooms."+"bedwordis "+bedrooms);}//less than 5
           }

           if(bedrooms&&leastnumber){containsbedroomcounter++;}//inc number of correct items

           }catch (NoSuchElementException e){
               System.out.println("Error! property number: "+generalcounter+" display wrong text.");//element does not contain a field for bedroom number
           }



       }if (containsbedroomcounter==innerDivs.size())
    {
        System.out.println("All properties displayed have least number of bedrooms.");
    }
    else {
        System.out.println("Only "+containsbedroomcounter+" property display correct data.");
    }


    String parent =driver.getWindowHandle();//get page id
    driver.getWindowHandle();//

    driver.findElement(By.cssSelector(".gsgwcjk > div:nth-child(1)")).click();//open first element

    Set<String> windows=driver.getWindowHandles();//get id of all pages
    for(String temp:windows)
    {
        if (!temp.equals(parent))
        {
            driver.switchTo().window(temp);//switch to id of second page
            break;

        }

    }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div:nth-child(58) > section > div > div > div.p1psejvv.dir.dir-ltr > div > div._1piuevz > button"))).click();//close popup
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#site-content > div > div:nth-child(1) > div:nth-child(3) > div > div._16e70jgn > div > div:nth-child(6) > div > div:nth-child(2) > section > div.b9672i7.dir.dir-ltr > button"))).click();//open amenities
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        WebElement outerDiv2 = driver.findElement(By.cssSelector("body > div:nth-child(58) > section > div > div > div.p1psejvv.dir.dir-ltr > div > div._17itzz4 > div > div > div > section > div:nth-child(2)"));
        List<WebElement> inner = outerDiv2.findElements(By.cssSelector("[class=\"twad414 dir dir-ltr\"]"));//lest of all elements containing text
        for (WebElement temp : inner) {
            String temptitle = temp.getText();//get text of each element

            if (temptitle.contains("Pool")||temptitle.contains("Private pool")||temptitle.contains("Private outdoor pool")) {

                System.out.println("Pool option is displayed in the ‘Amenities’ popup....(Test 2 Done)");//contains pool option
                break;
            }
        }


        System.out.println("===========================");
    System.out.println("END OF PROGRAM");
    driver.quit();
}
}


