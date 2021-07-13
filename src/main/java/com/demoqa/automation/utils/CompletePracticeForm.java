package com.demoqa.automation.utils;

import com.demoqa.automation.ui.PracticeFormPage;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.awt.*;
import java.io.File;

public class CompletePracticeForm extends PracticeFormPage {

    Robot robot;
    File tempFile;

    public Target daySelected (String dia, String mes){

        DAYSELECT1 = Target.the("").locatedBy(("//*[contains(@class,'react-datepicker__day react-datepicker__day--0" + dia +"') and contains(@aria-label,' "+ mes + "') ] "));
                //By.xpath("//*[contains(@class,'react-datepicker__day react-datepicker__day--0" + dia +"') and contains(@aria-label,' "+ this.valor + "') ] ");
    return DAYSELECT1;
    }

    public Target HobbiesCheck(String hobbies) {

        switch (hobbies){
            case "Sports":
                HOBBIESCHECK = Target.the("").located(By.xpath("//label[@for='hobbies-checkbox-1']"));
                break;
            case "Reading":
                HOBBIESCHECK = Target.the("").located(By.xpath("//label[@for='hobbies-checkbox-2']"));
                break;
            case "Music":
                HOBBIESCHECK = Target.the("").located(By.xpath("//label[@for='hobbies-checkbox-3']"));
                break;
        }
        return HOBBIESCHECK;
    }

}
