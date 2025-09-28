package co.com.encora.project.questions;

import co.com.encora.project.ui.LoginParaBank;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateLogin implements Question<Boolean> {

    private final String expectedText;

    public ValidateLogin(String expectedText) {
        this.expectedText = expectedText;
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        String resultsText;

        if (expectedText.toLowerCase().contains("accounts overview")) {
            resultsText = LoginParaBank.RESULTS_LOGIN.resolveFor(actor).getText().toLowerCase();
        } else {
            resultsText = LoginParaBank.RESULT_REGISTER.resolveFor(actor).getText().toLowerCase();
        }

        return resultsText.contains(expectedText.toLowerCase());
    }

    public static ValidateLogin validateLogin(String expectedText) {
        return new ValidateLogin(expectedText);
    }
}
