package co.com.encora.project.tasks;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.encora.project.ui.LoginParaBank.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

@AllArgsConstructor
public class DoLogin implements Task {

    private final String username;
    private final String password;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(USER_NAME_INPUT, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(username).into(USER_NAME_INPUT),
                Enter.theValue(password).into(PASSWORD_INPUT),
                Click.on(LOGIN_BUTTON)
        );
    }

    public static DoLogin withCredentials(String username, String password) {
        return instrumented(DoLogin.class, username, password);
    }
}
