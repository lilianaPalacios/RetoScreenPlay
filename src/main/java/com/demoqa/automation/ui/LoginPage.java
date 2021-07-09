package com.demoqa.automation.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {

    public static String URL = "https://www.demoqa.com/";

    public static final Target FORMLINK = Target.the("").located(By.xpath("//*[@id='app']/div/div/div[2]/div/div[2]/div/div[3]/h5"));
    public static final Target PRACTICEFORMLINK = Target.the("").located(By.xpath("//div[@class='element-list collapse show']//li[@id='item-0']"));


}
