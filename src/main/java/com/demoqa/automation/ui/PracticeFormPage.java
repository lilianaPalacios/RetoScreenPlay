package com.demoqa.automation.ui;

import com.demoqa.automation.utils.CompletePracticeForm;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.io.File;

public class PracticeFormPage {


    private String valor = "";
    File tempFile;

    public static final Target genderRadioButton = Target.the("Seleccionar genero").locatedBy("//label[@for='gender-radio-{0}']");
    public static Target hobbiesCheck = null;
    public static Target daySelect1 = null;
    public static Target opcionesStateCombo = Target.the("Seleccionar la opcion").locatedBy("//div[contains(text(),'{0}')]");
//By.xpath("//div[contains(text(),'"+dato+"')]");                                                                          //div[contains(text(),'Rajasthan')]
    public static final Target practiceFormLink = Target.the("").
            located(By.xpath("//div[@class='element-list collapse show']//li[@id='item-0']"));
    public static final Target nameInput = Target.the("").
            located(By.id("firstName"));
    public static final Target lasNameImput = Target.the("").
            located(By.id("lastName"));
    public static final Target email = Target.the("").located(By.id("userEmail"));
    public static final Target mobileInput = Target.the("").
            located(By.xpath("//input[@id='userNumber' and  @placeholder='Mobile Number']"));
    public static final Target dateBirthClick = Target.the("").located(By.id("dateOfBirthInput"));
    public static final Target monthCombo = Target.the("").
            located(By.xpath("//select[@class='react-datepicker__month-select']"));
    public static final Target yearCombo = Target.the("").
            located(By.xpath("//select[@class='react-datepicker__year-select']"));
    public static final Target subjectsInput = Target.the("").located(By.id("subjectsInput"));
    public static final Target subjectsInput1 = Target.the("").located(By.xpath("//div[contains(text(),'English')]"));
    public static final Target imagenBtn = Target.the("").
            located(By.xpath("//label[@class='form-file-label']"));
    public static final Target currentAddres = Target.the("").located(By.id("currentAddress"));
    public static final Target stateCityComboClick = Target.the("").
            locatedBy("//div[contains(text(),'Select State')]");
    public static final Target ciyCombo = Target.the("").
            located(By.xpath("//div[contains(text(),'Select City')]"));
    public static final Target submitBtn = Target.the("").located(By.id("submit"));
    public static final Target opcDesp = Target.the("").located(By.xpath("//div[@class=' css-26l3qy-menu'])"));

    public void setValor(String valor) {
        this.valor = valor;
    }
}