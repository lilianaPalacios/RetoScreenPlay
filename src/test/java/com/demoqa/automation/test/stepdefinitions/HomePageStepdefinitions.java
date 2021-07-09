package com.demoqa.automation.test.stepdefinitions;

import com.demoqa.automation.interactions.OpenTheBrowser;
import com.demoqa.automation.tasks.FillForm;
import com.demoqa.automation.tasks.HomePage;
import com.demoqa.automation.tasks.HomePageValidation;
import com.demoqa.automation.tasks.ValidacionResultado;
import com.demoqa.automation.ui.LoginPage;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import javax.swing.*;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class HomePageStepdefinitions {

@Managed
private WebDriver driver;

@Before
public void actorSetup(){
    OnStage.setTheStage(new OnlineCast());
    OnStage.theActorCalled("Liliana").can(BrowseTheWeb.with(driver));
}


    @Given("^El usuario desea acceder al formulario$")
    public void elUsuarioDeseaAccederAlFormulario() {
        theActorInTheSpotlight().attemptsTo(OpenTheBrowser.on(LoginPage.URL));

    }


    @When("^Da clic en la opcion forms$")
    public void daClicEnLaOpcionForms() {
        theActorInTheSpotlight().attemptsTo(HomePage.logPage());
        theActorInTheSpotlight().attemptsTo(HomePageValidation.PracticeFormValidation());
    }

    @When("^Llena el formulario y lo envia$")
    public void llenaElFormularioYLoEnvia() {
        theActorInTheSpotlight().attemptsTo((FillForm.LlenarForm()));

    }

    @Then("^Valida los campos$")
    public void validaLosCampos() {
        theActorInTheSpotlight().attemptsTo(ValidacionResultado.valRes());
    }

}
