package stepdefinitions;

import co.com.encora.project.interactions.SelectOption;
import co.com.encora.project.models.UserData;
import co.com.encora.project.questions.ValidateLogin;
import co.com.encora.project.tasks.DoLogin;
import co.com.encora.project.tasks.DoRegister;
import co.com.encora.project.tasks.GoToHomePage;
import co.com.encora.project.utils.RandomUserGenerator;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import java.util.Map;

import static org.hamcrest.CoreMatchers.is;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class OpenPageSteps {

    @Before
    public void config() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Rodrigo");
    }
    @Given("the user opens the ParaBank home page")
    public void theUserOpensTheParaBankHomePage() {
        theActorInTheSpotlight().wasAbleTo(
                GoToHomePage.open()
        );
    }

    @When("the user selects {string} and submits valid data:")
    public void theUserSelectsRegisterAndSubmitsValidData(String option, DataTable table) {
        Map<String, String> data = table.asMaps().get(0);

        theActorInTheSpotlight().attemptsTo(
                SelectOption.named(option)
        );

        String generatedUsername = RandomUserGenerator.generateUsername();
        String generatedPassword = RandomUserGenerator.generatePassword();

        UserData userData = UserData.fromMap(data, generatedUsername, generatedPassword);

        theActorInTheSpotlight().remember("userData", userData);

        theActorInTheSpotlight().attemptsTo(
                DoRegister.with(userData)
        );
    }

    @Then("the user should see a successful registration message")
    public void theUserShouldSeeASuccessfulRegistrationMessage() {
        UserData userData = theActorInTheSpotlight().recall("userData");

        theActorInTheSpotlight().should(
                seeThat("registration message",
                        ValidateLogin.validateLogin("Welcome " + userData.getUsername()),
                        is(true))
        );
    }

    @And("selects {string}")
    public void selects(String option) {
        theActorInTheSpotlight().attemptsTo(
                SelectOption.named(option)
        );
    }

    @When("the user logs in with the generated credentials")
    public void theUserLogsInWithTheGeneratedCredentials() {
        UserData userData = theActorInTheSpotlight().recall("userData");

        theActorInTheSpotlight().attemptsTo(
                DoLogin.withCredentials(userData.getUsername(), userData.getPassword())
        );
    }

    @Then("the user should see the account overview page")
    public void theUserShouldSeeTheAccountOverviewPage() {
        theActorInTheSpotlight().should(
                seeThat("account overview is visible",
                        ValidateLogin.validateLogin("Accounts Overview"),
                        is(true))
        );
    }
}