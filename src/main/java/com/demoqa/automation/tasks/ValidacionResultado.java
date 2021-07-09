package com.demoqa.automation.tasks;

import com.demoqa.automation.models.DataInjection;
import com.demoqa.automation.questions.Validations;
import com.demoqa.automation.ui.PracticeFormPage;
import com.demoqa.automation.ui.ValidacionPage;
import com.demoqa.automation.utils.CompletePracticeForm;
import com.demoqa.automation.utils.Excel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.questions.Text;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ValidacionResultado implements Task {

    DataInjection dataInjection = new DataInjection();
    Excel excel = new Excel();


    @Override
    public <T extends Actor> void performAs(T actor) {
        String datoExcel;
        int j=0;
        for (int i = 1; i <= 10; i++) {
            //for (int j = 0; j < 15; j++) {

            excel.getCellValue(dataInjection.getFilePath(),dataInjection.getSheetNameData(),1,j);
            if (j==0){
                datoExcel =  excel.getCellValue(dataInjection.getFilePath(),dataInjection.getSheetNameData(),1,j) + " " +
                        excel.getCellValue(dataInjection.getFilePath(),dataInjection.getSheetNameData(),1,1);
                j=2;
            }else if(j==5){
                datoExcel =  excel.getCellValue(dataInjection.getFilePath(),dataInjection.getSheetNameData(),1,j) + " " +
                        excel.getCellValue(dataInjection.getFilePath(),dataInjection.getSheetNameData(),1,6)+ "," +
                        excel.getCellValue(dataInjection.getFilePath(),dataInjection.getSheetNameData(),1,7);
                j=8;
            }else if(j==10){
                datoExcel =  excel.getCellValue(dataInjection.getFilePath(),dataInjection.getSheetNameData(),1,11);
                j=12;
            }
            else if(j==13){
                datoExcel =  excel.getCellValue(dataInjection.getFilePath(),dataInjection.getSheetNameData(),1,j)+ " "+
                        excel.getCellValue(dataInjection.getFilePath(),dataInjection.getSheetNameData(),1,14);
                j=15;
            }else{
                datoExcel = excel.getCellValue(dataInjection.getFilePath(),dataInjection.getSheetNameData(),1,j);
                j++;
            }

            System.out.println("target" + Text.of(ValidacionPage.campoTablaTbl.of(i+"")).viewedBy(actor).value() + "excel " + datoExcel);
            actor.should(seeThat(Validations.val((Text.of(ValidacionPage.campoTablaTbl.of(i+"")).viewedBy(actor).value()),datoExcel)));

           // Validar(resultadoPage.getCampoTablaTbl(i),datoExcel);
        }

    }

    public static ValidacionResultado valRes (){
        return instrumented(ValidacionResultado.class);
    }
}
