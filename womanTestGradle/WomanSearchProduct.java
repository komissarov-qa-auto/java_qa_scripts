package womanTestGradle;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class WomanSearchProduct {

    @Before
    public void setup(){
        //Configuration.browser = "firefox";
        Configuration.startMaximized = true;
    }

    @Test
    public void checkIfIOnWomenPage(){
        open("http://automationpractice.com/");
        $(By.linkText("Women")).click();
        $(By.xpath("//h2[@class='title_block']")).shouldHave(text("WOMEN"));
    }

    @Test
    public void searchProduct(){
        $(By.id("search_query_top")).setValue("Blouse").pressEnter();
        $(By.xpath("//img[@title='Blouse']")).shouldBe(visible);
        $(By.xpath("//span[contains(text(),'1 result has been found.')]")).shouldBe(visible);
    }

}
