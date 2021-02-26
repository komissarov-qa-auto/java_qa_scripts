package womanTestGradle;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;


import java.util.List;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class PresenceOfSocialElements {

    @Before
    public void setup(){
        //Configuration.browser = "firefox";
        Configuration.startMaximized = true;
        open("http://automationpractice.com/");
    }

    @Test
    public void testIfProductHasSocialNetworkButtons(){
        selectProduct("Blouse");
        //elements(".socialsharing_product.list-inline.no-print>button").shouldHave(exactTexts("Tweet","Share", "Google+", "Pinterest"));
        elements(By.xpath("//button[@type='button']")).shouldHave(exactTexts("Tweet","Share", "Google+", "Pinterest"));

    }

    public void selectProduct(String productName){
        elements(".product_img_link").filterBy(attribute("title", productName)).first().click();
    }


}
