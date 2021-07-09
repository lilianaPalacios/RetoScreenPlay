package com.demoqa.automation.tasks;

import com.demoqa.automation.questions.ExistingElementQuestion;
import com.demoqa.automation.ui.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Consequence;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static org.hamcrest.Matchers.*;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;


public class HomePageValidation implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(LoginPage.PRACTICEFORMLINK,isVisible()));
        actor.should(
                seeThat(ExistingElementQuestion.visible(LoginPage.PRACTICEFORMLINK), Matchers.is(true)));
    }

    public static HomePageValidation PracticeFormValidation(){
        return instrumented(HomePageValidation.class);
    }
}
