package co.com.encora.project.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.environment.SystemEnvironmentVariables;
import net.thucydides.core.util.EnvironmentVariables;

public class GoToHomePage implements Task {

    private final String baseUrl;

    public GoToHomePage() {
        EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
        this.baseUrl = environmentVariables.getProperty("serenity.base.url");
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(baseUrl)
        );
    }

    public static GoToHomePage open() {
        return new GoToHomePage();
    }
}
