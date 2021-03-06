package com.demoqa.automation.tasks;

import com.demoqa.automation.ui.PracticeFormPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.JavaScriptClick;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectGender implements Task {

    private String gender;

    public SelectGender(String gender){
        this.gender = gender;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (gender){
            case "Male":
                actor.attemptsTo(JavaScriptClick.on(PracticeFormPage.GENDERRADIOBBUTON.of("1")));
                break;
            case "Female":
                actor.attemptsTo(JavaScriptClick.on(PracticeFormPage.GENDERRADIOBBUTON.of("2")));
                break;
            case "Other":
                actor.attemptsTo(JavaScriptClick.on(PracticeFormPage.GENDERRADIOBBUTON.of("3")));
                break;
        }
    }
    public static SelectGender selGend (String gender){
        return instrumented(SelectGender.class,gender);
    }

}
