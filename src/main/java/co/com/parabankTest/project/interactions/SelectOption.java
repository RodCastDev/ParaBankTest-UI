package co.com.encora.project.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import co.com.encora.project.ui.RegisterParaBank;

public class SelectOption implements Interaction {

    private final String option;

    public SelectOption(String option) {
        this.option = option;
    }

    public static SelectOption named(String option) {
        return Tasks.instrumented(SelectOption.class, option);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(RegisterParaBank.registerLink(option))
        );
    }
}
