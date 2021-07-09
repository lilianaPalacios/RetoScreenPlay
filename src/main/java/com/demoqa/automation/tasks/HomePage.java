package com.demoqa.automation.tasks;

import com.demoqa.automation.ui.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class HomePage implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(LoginPage.FORMLINK, isVisible()),
                JavaScriptClick.on(LoginPage.FORMLINK)
        );

    }
    public static HomePage logPage (){
        return instrumented(HomePage.class);
    }
}
