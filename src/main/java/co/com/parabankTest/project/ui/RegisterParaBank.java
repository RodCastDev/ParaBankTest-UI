package co.com.encora.project.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RegisterParaBank {

    public static Target registerLink(String linkText) {
        return Target.the("Link Register" + linkText)
                .located(By.linkText(linkText));
    }
    public static final Target INPUT_FIRST_NAME = Target.the("Input first name")
            .located(By.id("customer.firstName"));

    public static final Target INPUT_LAST_NAME = Target.the("Input last name")
            .located(By.id("customer.lastName"));

    public static final Target INPUT_ADDRESS = Target.the("Input address")
            .located(By.id("customer.address.street"));

    public static final Target INPUT_CITY = Target.the("Input city")
            .located(By.id("customer.address.city"));

    public static final Target INPUT_STATE = Target.the("Input state")
            .located(By.id("customer.address.state"));

    public static final Target INPUT_ZIP_CODE = Target.the("Input zip code")
            .located(By.id("customer.address.zipCode"));

    public static final Target INPUT_PHONE = Target.the("Input phone number")
            .located(By.id("customer.phoneNumber"));

    public static final Target INPUT_SSN = Target.the("Input SSN")
            .located(By.id("customer.ssn"));

    public static final Target INPUT_USERNAME = Target.the("Input username")
            .located(By.id("customer.username"));

    public static final Target INPUT_PASSWORD = Target.the("Input password")
            .located(By.id("customer.password"));

    public static final Target INPUT_CONFIRM = Target.the("Input confirm password")
            .located(By.id("repeatedPassword"));

    public static final Target BUTTON_REGISTER = Target.the("Register button")
            .located(By.xpath("//input[@value='Register']"));

    public static Target logOurLink(String option) {
        return Target.the("Log Out Link " + option)
                .located(By.linkText(option));
    }



}

//*[@id="rightPanel"]/h1