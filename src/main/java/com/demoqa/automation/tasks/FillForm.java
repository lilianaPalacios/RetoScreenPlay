package com.demoqa.automation.tasks;

import com.demoqa.automation.interactions.OpenFile;
import com.demoqa.automation.interactions.SelectOpcCityState;
import com.demoqa.automation.models.DataInjection;
import com.demoqa.automation.ui.PracticeFormPage;
import com.demoqa.automation.utils.CompletePracticeForm;
import com.demoqa.automation.utils.Excel;
import cucumber.api.java.et.Ja;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.ClickOnTarget;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.selectactions.SelectByVisibleTextFromTarget;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.KeyInput;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.nio.file.Watchable;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class FillForm  implements Task {

    DataInjection dataInjection = new DataInjection();
    CompletePracticeForm completePracticeForm = new CompletePracticeForm();
    Excel excel = new Excel();

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(PracticeFormPage.practiceFormLink,isVisible()),
                JavaScriptClick.on(PracticeFormPage.practiceFormLink),
                WaitUntil.the(PracticeFormPage.lasNameImput,isVisible()),
                Enter.theValue(
                        Excel.getCellValue(dataInjection.getFilePath(),dataInjection.getSheetNameData(),1,0)).
                        into(PracticeFormPage.nameInput),

                Enter.theValue(
                        Excel.getCellValue(dataInjection.getFilePath(),dataInjection.getSheetNameData(),1,1)).
                        into(PracticeFormPage.lasNameImput),
                Enter.theValue(
                        Excel.getCellValue(dataInjection.getFilePath(),dataInjection.getSheetNameData(),1,2)).
                        into(PracticeFormPage.email),
                SelectGender.selGend(Excel.getCellValue(dataInjection.getFilePath(),dataInjection.getSheetNameData(),1,3)),
                Enter.theValue(
                        Excel.getCellValue(dataInjection.getFilePath(),dataInjection.getSheetNameData(),1,4)).
                        into(PracticeFormPage.mobileInput),
                JavaScriptClick.on(PracticeFormPage.dateBirthClick),
                WaitUntil.the(PracticeFormPage.monthCombo,isVisible()),
                new SelectByVisibleTextFromTarget(PracticeFormPage.monthCombo,
                        Excel.getCellValue(dataInjection.getFilePath(),dataInjection.getSheetNameData(),1,6)),
                WaitUntil.the(PracticeFormPage.yearCombo,isVisible()),
                new SelectByVisibleTextFromTarget(PracticeFormPage.yearCombo,
                        Excel.getCellValue(dataInjection.getFilePath(),dataInjection.getSheetNameData(),1,7)),
                JavaScriptClick.on(completePracticeForm.daySelected(
                        Excel.getCellValue(dataInjection.getFilePath(),dataInjection.getSheetNameData(),1,5),
                        Excel.getCellValue(dataInjection.getFilePath(),dataInjection.getSheetNameData(),1,6))),
                WaitUntil.the(PracticeFormPage.subjectsInput,isEnabled()),
                JavaScriptClick.on(PracticeFormPage.subjectsInput),
                WaitUntil.the(PracticeFormPage.subjectsInput,isPresent()),
                Enter.keyValues(Excel.getCellValue(dataInjection.getFilePath(),dataInjection.getSheetNameData(),1,8)).into(PracticeFormPage.subjectsInput),
                Enter.keyValues(Keys.DOWN).into(PracticeFormPage.subjectsInput),
                Enter.keyValues(Keys.ENTER).into(PracticeFormPage.subjectsInput),
                JavaScriptClick.on(completePracticeForm.HobbiesCheck(Excel.getCellValue(dataInjection.getFilePath(),dataInjection.getSheetNameData(),1,9))),
                OpenFile.OpF(Excel.getCellValue(dataInjection.getFilePath(),dataInjection.getSheetNameData(),1,10),
                             Excel.getCellValue(dataInjection.getFilePath(),dataInjection.getSheetNameData(),1,11)),
                Enter.theValue(Excel.getCellValue(dataInjection.getFilePath(),dataInjection.getSheetNameData(),1,12)).
                        into(PracticeFormPage.currentAddres),
                new ClickOnTarget(PracticeFormPage.stateCityComboClick),
                SelectOpcCityState.SelOpcCityState(Excel.getCellValue(dataInjection.getFilePath(),dataInjection.getSheetNameData(),1,13)),
                new ClickOnTarget(PracticeFormPage.ciyCombo),
                SelectOpcCityState.SelOpcCityState(Excel.getCellValue(dataInjection.getFilePath(),dataInjection.getSheetNameData(),1,14)),
                JavaScriptClick.on(PracticeFormPage.submitBtn)
        );
    }

    public static FillForm LlenarForm (){
        return instrumented(FillForm.class);
    }

}
