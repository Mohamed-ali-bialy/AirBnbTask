import java.util.Date;
import java.util.List;
import java.util.Set;
public class WebsiteTest {
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

        SeleniumSetup s1 = new SeleniumSetup("https://www.airbnb.com");//setup selenium and send url
        Selectors select = new Selectors(s1.getDriver());//create selector obj

        Actions.clickon(select.waitForElementToBeClickable("f16sug5q"));//click on bar
        Actions.SendInput_Enter(select.findByCssSelector("#bigsearch-query-location-input"),location);//send input text and Enter
        Actions.clickon(select.aria_label(checkindate));//select in date
        Actions.clickon(select.aria_label(checkoutdate));//select out date
        Actions.clickon(select.findByClassName("pz9siyu"));//click on guest icon
        Actions.clickon(select.data_testid("stepper-adults-increase-button"),2);//click with number of clicks
        Actions.clickon(select.data_testid("stepper-children-increase-button"));//click once
        Actions.clickon(select.data_testid("structured-search-input-search-button"));//click on search

        boolean headerresult=false;//check the header result
        if(select.TextContainsSubstring(select.waitForElementToBeVisiblebyxpath("/html/body/div[5]/div/div/div[1]/div/div[2]/div[2]/main/div[2]/div/div[1]/div/div/div/section/h1/span"),city))
        {System.out.println("Result of search header contains " + city+" city");headerresult=true;}
        else {System.out.println("Error! the header result dose not search criteria");}

        boolean fltrplace=false;//check place in filter
        if(select.TextContainsSubstring(select.findByClassName("f16sug5q"),city))
        {System.out.println("Filter contains "+city+" city");fltrplace=true;}
        else{System.out.println("Error! the place in filter area dose not search criteria");}

        boolean datein=false;//check checkindate in filter
        if(select.TextContainsSubstring(select.findByXPath("/html/body/div[5]/div/div/div[1]/div/div[2]/div[1]/div[1]/div/div/header/div/div[2]/div[1]/div/span[2]/button[2]/div"),checkinday))
        {System.out.println("Filter contains correct check in day " + checkinday);datein=true;}
        else{System.out.println("Error! the check in day in filter area dose not search criteria");}

        boolean dateout=false;//check checkoutdate in filter
        if(select.TextContainsSubstring(select.findByXPath("/html/body/div[5]/div/div/div[1]/div/div[2]/div[1]/div[1]/div/div/header/div/div[2]/div[1]/div/span[2]/button[2]/div"),checkoutday))
        {System.out.println("Filter contains correct check out day " + checkoutday);dateout=true;}
        else{System.out.println("Error! the check in day out filter area dose not search criteria");}

        boolean gesutnumb=false;//check gesutnumber in filter
        if(select.TextContainsSubstring(select.findByXPath("/html/body/div[5]/div/div/div[1]/div/div[2]/div[1]/div[1]/div/div/header/div/div[2]/div[1]/div/span[2]/button[3]/div[1]"),"3"))
        {System.out.println("Filter contains  " + "3"+" Guests");gesutnumb=true;}
        else{System.out.println("Error! the number of guests  in filter area dose not search criteria");}

        if (headerresult && fltrplace && datein&&dateout&&gesutnumb)//first task criteria
        {System.out.println("The results match the search criteria....(Test 1 Done)");}//matching

        System.out.println("===========================");

        Actions.clickon(select.data_testid("category-bar-filter-button"));//select filter button
        Actions.clickon(select.waitForElementToBeClickable("l1d3yagp"));//wait for showmore
        Actions.clickon(select.data_testid("filter-item-amenities-7"));//click on pool
        Actions.clickon(select.data_testid("menuItemButton-5"));//click on 5 bedrooms
        Actions.clickon(select.findByClassName("bmx2gr4"));//click on show stays

        List<String> tempo=select.findListOfTexts("c4mnd7m","div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(3) > span:nth-child(2) > span:nth-child(3)");
        int containsbedroomcounter=0;//count the number of correct displayed property
        int generalcounter=0;// general counter
        for(String spanText:tempo)
        {
            generalcounter++;
            boolean bedrooms = false;
            boolean leastnumber = false;
            if(spanText.contains("NotFoundElement"))
            {System.out.println("Error! property number: "+generalcounter+" display wrong text.");continue;}//element does not contain a field for bedroom number

            if (spanText.contains("bedrooms")) {bedrooms = true;}//text contains bedrooms
            else{System.out.println("Error! property number: "+generalcounter+" doesn't display bedroom word.");}//does not contain bedroom word
            if ((bedrooms))//if text contains bedroom and no wrong word
            {
                IntegerExtractor extractor = new IntegerExtractor();
                int x = extractor.extractIntegerFromString(spanText);//extract integer from text
                if (x >= 5) {
                    leastnumber = true;//contains leastnumber of bedrooms
                }
                else {System.out.println("Error! property number: "+generalcounter+" doesn't have least number of bedrooms.");}//less than 5
            }
            if (bedrooms && leastnumber){containsbedroomcounter++;}
        }

        if (containsbedroomcounter==tempo.size())
        {
            System.out.println("All properties displayed have least number of bedrooms.");//all data is correct
        }
        else
        {
            System.out.println("Only "+containsbedroomcounter+" property display correct data.");//only number of correct
        }

        String parent=s1.get_window_id();//get window id
        Actions.clickon(select.findByCssSelector(".gsgwcjk > div:nth-child(1)"));//click on first property
        Set<String> windows=s1.driver.getWindowHandles();//featch all windows id
        for(String temp:windows)
        {
            if (!temp.equals(parent))
            {
                s1.driver.switchTo().window(temp);//switch to id of second page
                break;
            }

        }

        Selectors selectnew = new Selectors(s1.getDriver());//send driver to the new selector

        try {
            Actions.clickon(selectnew.waitForElementToBeVisiblebyxpathWithException("/html/body/div[10]/section/div/div/div[2]/div/div[1]/button"));//close popup
        }catch (Exception e){
            System.out.println("Translation Popup didn't appear !");
        }

        Actions.clickon(selectnew.findByCssSelector("#site-content > div > div:nth-child(1) > div:nth-child(3) > div > div._16e70jgn > div > div:nth-child(5) > div > div:nth-child(2) > section > div.b9672i7.dir.dir-ltr > button"));//open popup

        List<String> features=selectnew.findListOfStrings("twad414");//list of string in popup
        for(String str:features)
        {
            if (str.contains("Pool")||str.contains("Private pool")||str.contains("Private outdoor pool"))
            {
                System.out.println("Pool option is displayed in the ‘Amenities’ popup....(Test 2 Done)");//contains pool option
                break;
            }
        }
        s1.driver.quit();
    }
}
