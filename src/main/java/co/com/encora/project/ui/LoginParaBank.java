package co.com.encora.project.ui;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginParaBank {
    public static final Target USER_NAME_INPUT = Target.the("input user name")
            .located(By.xpath("//*[@id=\"loginPanel\"]/form/div[1]/input"));

    public static final Target PASSWORD_INPUT = Target.the("input password")
            .located(By.xpath("//*[@id=\"loginPanel\"]/form/div[2]/input"));

    public static final Target LOGIN_BUTTON = Target.the("login button")
            .located(By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input"));

    public static final Target RESULT_REGISTER = Target.the("results register")
            .located(By.xpath("//*[@id=\"rightPanel\"]/h1"));

    public static final Target RESULTS_LOGIN = Target.the("results login")
            .located(By.xpath("//*[@id=\"showOverview\"]/h1"));
}

