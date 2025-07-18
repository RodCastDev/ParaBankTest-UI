package co.com.encora.project.tasks;

import co.com.encora.project.models.UserData;
import co.com.encora.project.ui.RegisterParaBank;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

@AllArgsConstructor
public class DoRegister implements Task {

    private final UserData userData;

    public static DoRegister with(UserData userData) {
        return Tasks.instrumented(DoRegister.class, userData);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(userData.getFirstName()).into(RegisterParaBank.INPUT_FIRST_NAME),
                Enter.theValue(userData.getLastName()).into(RegisterParaBank.INPUT_LAST_NAME),
                Enter.theValue(userData.getAddress()).into(RegisterParaBank.INPUT_ADDRESS),
                Enter.theValue(userData.getCity()).into(RegisterParaBank.INPUT_CITY),
                Enter.theValue(userData.getState()).into(RegisterParaBank.INPUT_STATE),
                Enter.theValue(userData.getZipCode()).into(RegisterParaBank.INPUT_ZIP_CODE),
                Enter.theValue(userData.getPhone()).into(RegisterParaBank.INPUT_PHONE),
                Enter.theValue(userData.getSsn()).into(RegisterParaBank.INPUT_SSN),

                Enter.theValue(userData.getUsername()).into(RegisterParaBank.INPUT_USERNAME),
                Enter.theValue(userData.getPassword()).into(RegisterParaBank.INPUT_PASSWORD),
                Enter.theValue(userData.getPassword()).into(RegisterParaBank.INPUT_CONFIRM),
                Click.on(RegisterParaBank.BUTTON_REGISTER)
        );
    }
}