package com.demoqa.automation.utils;

import com.demoqa.automation.ui.PracticeFormPage;
import net.serenitybdd.screenplay.questions.JavaScript;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class CompletePracticeForm extends PracticeFormPage {

    Robot robot;
    File tempFile;

    public Target daySelected (String dia, String mes){

        daySelect1 = Target.the("").locatedBy(("//*[contains(@class,'react-datepicker__day react-datepicker__day--0" + dia +"') and contains(@aria-label,' "+ mes + "') ] "));
                //By.xpath("//*[contains(@class,'react-datepicker__day react-datepicker__day--0" + dia +"') and contains(@aria-label,' "+ this.valor + "') ] ");
    return daySelect1;
    }

    public Target HobbiesCheck(String hobbies) {

        switch (hobbies){
            case "Sports":
                hobbiesCheck = Target.the("").located(By.xpath("//label[@for='hobbies-checkbox-1']"));
                break;
            case "Reading":
                hobbiesCheck = Target.the("").located(By.xpath("//label[@for='hobbies-checkbox-2']"));
                break;
            case "Music":
                hobbiesCheck = Target.the("").located(By.xpath("//label[@for='hobbies-checkbox-3']"));
                break;
        }
        return hobbiesCheck;
    }

}
