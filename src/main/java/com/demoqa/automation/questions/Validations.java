package com.demoqa.automation.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import org.hamcrest.Matchers;

import static org.hamcrest.MatcherAssert.assertThat;

public class Validations implements Question {

    private String campoTabla;
    private String valorExcel;

    public Validations(String campoTabla, String valorExcel){

        this.campoTabla = campoTabla;
        this.valorExcel = valorExcel;
    }

     @Override
    public Object answeredBy(Actor actor)   {
        //target.resolveFor(actor).isVisible();

        return  campoTabla.equalsIgnoreCase(valorExcel);
    }



    public static Validations val (String campoTabla, String valorExcel){

        return new Validations(campoTabla,  valorExcel);
    }


}
