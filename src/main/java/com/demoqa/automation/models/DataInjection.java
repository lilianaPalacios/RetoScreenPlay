package com.demoqa.automation.models;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataInjection {


    Faker faker = new Faker(new Locale("en-US"));

    private String filePath, sheetNameData/*,sheetNameValidations*/;
    int cellNumber, rowNumber;

    public DataInjection(){

        this.filePath = "src\\main\\resources\\Data\\Data.xlsx";
        //this.sheetNameValidations = faker.expression("Validations");
        this.sheetNameData = "dataInjection";
        this.cellNumber = 0;
        this.rowNumber = 0;

    }

    public String getFilePath() {
        return filePath;
    }

    public String getSheetNameData() {
        return sheetNameData;
    }

    public int getCellNumber() {
        return cellNumber;
    }

    public int getRowNumber() {
        return rowNumber;
    }

}
