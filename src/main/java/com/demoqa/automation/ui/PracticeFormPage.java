package com.demoqa.automation.ui;

import com.demoqa.automation.utils.CompletePracticeForm;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.io.File;

public class PracticeFormPage {


    private String valor = "";
    File tempFile;

    public static final Target GENDERRADIOBBUTON = Target.the("Seleccionar genero").locatedBy("//label[@for='gender-radio-{0}']");
    public static Target HOBBIESCHECK = null;
    public static Target DAYSELECT1 = null;
    public static Target opcionesStateCombo = Target.the("Seleccionar la opcion").locatedBy("//div[contains(text(),'{0}')]");
//By.xpath("//div[contains(text(),'"+dato+"')]");                                                                          //div[contains(text(),'Rajasthan')]
    public static final Target PRACTICEFORMLINK = Target.the("").
            located(By.xpath("//div[@class='element-list collapse show']//li[@id='item-0']"));
    public static final Target NAMEINPUT = Target.the("").
            located(By.id("firstName"));
    public static final Target LASTNAMEINPUT = Target.the("").
            located(By.id("lastName"));
    public static final Target EMAILINPUT = Target.the("").located(By.id("userEmail"));
    public static final Target MOBILEINPUT = Target.the("").
            located(By.xpath("//input[@id='userNumber' and  @placeholder='Mobile Number']"));
    public static final Target DATEBITRHCLICK = Target.the("").located(By.id("dateOfBirthInput"));
    public static final Target MONTHCOMBO = Target.the("").
            located(By.xpath("//select[@class='react-datepicker__month-select']"));
    public static final Target YEARCOMBO = Target.the("").
            located(By.xpath("//select[@class='react-datepicker__year-select']"));
    public static final Target subjectsInput = Target.the("").located(By.id("subjectsInput"));
    public static final Target subjectsInput1 = Target.the("").located(By.xpath("//div[contains(text(),'English')]"));
    public static final Target imagenBtn = Target.the("").
            located(By.xpath("//label[@class='form-file-label']"));
    public static final Target CURRENT_ADDRESS = Target.the("").located(By.id("currentAddress"));
    public static final Target STATE_CITY_COMBO_CLICK = Target.the("").
            locatedBy("//div[contains(text(),'Select State')]");
    public static final Target CIY_COMBO = Target.the("").
            located(By.xpath("//div[contains(text(),'Select City')]"));
    public static final Target SUBMIT_BTN = Target.the("").located(By.id("submit"));
    public static final Target OPC_DESP = Target.the("").located(By.xpath("//div[@class=' css-26l3qy-menu'])"));

    public void setValor(String valor) {
        this.valor = valor;
    }
}