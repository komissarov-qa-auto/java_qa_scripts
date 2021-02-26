package womanTestGradle;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


public class WomanBuyProductAssert {

    @Before
    public void setup(){
        //Configuration.browser = "firefox";
        Configuration.startMaximized = true;
        open("http://automationpractice.com/");
    }

    @Test
    public void AddProductToCart(){
        SelenideElement product = $(By.linkText("Faded Short Sleeve T-shirts"));
        product.scrollTo();
        actions().moveToElement(product).perform();
        $(By.xpath("(//a[@class='quick-view'])[1]")).click();
        switchTo().frame(element(By.className("fancybox-iframe")));
        $(By.id("quantity_wanted")).setValue("2");
        $(By.id("group_1")).selectOption("M");
        $(By.id("add_to_cart")).click();
        $(By.xpath("//*[contains(text(),'Proceed to checkout')]")).click();
        $(By.id("summary_products_quantity")).shouldHave(text("2 Products"));
    }



}

