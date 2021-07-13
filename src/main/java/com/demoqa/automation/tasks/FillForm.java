package com.demoqa.automation.tasks;

import com.demoqa.automation.interactions.OpenFile;
import com.demoqa.automation.interactions.SelectOpcCityState;
import com.demoqa.automation.models.DataInjection;
import com.demoqa.automation.ui.PracticeFormPage;
import com.demoqa.automation.utils.CompletePracticeForm;
import com.demoqa.automation.utils.Excel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.ClickOnTarget;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.selectactions.SelectByVisibleTextFromTarget;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class FillForm  implements Task {

    DataInjection dataInjection = new DataInjection();
    CompletePracticeForm completePracticeForm = new CompletePracticeForm();
    Excel excel = new Excel();

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(PracticeFormPage.PRACTICEFORMLINK,isVisible()),
                JavaScriptClick.on(PracticeFormPage.PRACTICEFORMLINK),
                WaitUntil.the(PracticeFormPage.LASTNAMEINPUT,isVisible()),
                Enter.theValue(
                        Excel.getCellValue(dataInjection.getFilePath(),dataInjection.getSheetNameData(),1,0)).
                        into(PracticeFormPage.NAMEINPUT),

                Enter.theValue(
                        Excel.getCellValue(dataInjection.getFilePath(),dataInjection.getSheetNameData(),1,1)).
                        into(PracticeFormPage.LASTNAMEINPUT),
                Enter.theValue(
                        Excel.getCellValue(dataInjection.getFilePath(),dataInjection.getSheetNameData(),1,2)).
                        into(PracticeFormPage.EMAILINPUT),
                SelectGender.selGend(Excel.getCellValue(dataInjection.getFilePath(),dataInjection.getSheetNameData(),1,3)),
                Enter.theValue(
                        Excel.getCellValue(dataInjection.getFilePath(),dataInjection.getSheetNameData(),1,4)).
                        into(PracticeFormPage.MOBILEINPUT),
                JavaScriptClick.on(PracticeFormPage.DATEBITRHCLICK),
                WaitUntil.the(PracticeFormPage.MONTHCOMBO,isVisible()),
                new SelectByVisibleTextFromTarget(PracticeFormPage.MONTHCOMBO,
                        Excel.getCellValue(dataInjection.getFilePath(),dataInjection.getSheetNameData(),1,6)),
                WaitUntil.the(PracticeFormPage.YEARCOMBO,isVisible()),
                new SelectByVisibleTextFromTarget(PracticeFormPage.YEARCOMBO,
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
                        into(PracticeFormPage.CURRENT_ADDRESS),
                new ClickOnTarget(PracticeFormPage.STATE_CITY_COMBO_CLICK),
                SelectOpcCityState.SelOpcCityState(Excel.getCellValue(dataInjection.getFilePath(),dataInjection.getSheetNameData(),1,13)),
                new ClickOnTarget(PracticeFormPage.CIY_COMBO),
                SelectOpcCityState.SelOpcCityState(Excel.getCellValue(dataInjection.getFilePath(),dataInjection.getSheetNameData(),1,14)),
                JavaScriptClick.on(PracticeFormPage.SUBMIT_BTN)
        );
    }

    public static FillForm LlenarForm (){
        return instrumented(FillForm.class);
    }

}
