package com.demoqa.automation.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ValidacionPage {

    public static Target CAMPOTABLATBL = Target.the("Campo Tabla").locatedBy("//table/tbody/tr[{0}]/td[2]");

    //"//table/tbody/tr["+fila+"]/td[2]"

}
