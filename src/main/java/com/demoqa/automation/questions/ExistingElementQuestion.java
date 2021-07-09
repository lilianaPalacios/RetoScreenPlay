package com.demoqa.automation.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class ExistingElementQuestion implements Question {

private Target target;

public ExistingElementQuestion(Target target){
this.target = target;
}
    @Override
    public Object answeredBy(Actor actor) {
        WaitUntil.the(target, WebElementStateMatchers.isVisible());
        return target.resolveFor(actor).isVisible();
    }

    public static ExistingElementQuestion visible(Target target){
    return new ExistingElementQuestion(target);
    }

}
