package com.demoqa.automation.interactions;

import com.demoqa.automation.ui.PracticeFormPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import org.openqa.selenium.By;

public class SelectOpcCityState implements Interaction {

    private String dato;

    public SelectOpcCityState(String dato){
        this.dato = dato;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(JavaScriptClick.on(PracticeFormPage.opcionesStateCombo.of(dato)));
        //opcionesStateCombo = By.xpath("//div[contains(text(),'"+dato+"')]");
        //clic(opcionesStateCombo);
    }

    public static SelectOpcCityState SelOpcCityState (String dato){
        return new SelectOpcCityState(dato);
    }
}
