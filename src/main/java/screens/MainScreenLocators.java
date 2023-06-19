package screens;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Locators for the main page of the application. The same locators can be used for different platforms
 * example
 *     @AndroidFindBy(id = "toLogin")
 *     @iOSXCUITFindBy(id = "loginBtn")
 *     public SelenideElement signInBtn;
 */
public class MainScreenLocators {

    @AndroidFindBy(id = "eq")
    public SelenideElement equalsBtn;
    @AndroidFindBy(id = "clr")
    public SelenideElement clearBtn;
    @AndroidFindBy(id = "op_add")
    public SelenideElement plusBtn;
    @AndroidFindBy(id = "op_sub")
    public SelenideElement minusBtn;
    @AndroidFindBy(id = "op_mul")
    public SelenideElement multiplyBtn;
    @AndroidFindBy(id = "op_div")
    public SelenideElement divideBtn;
    @AndroidFindBy(id = "result_final")
    public WebElement resultFinalField;

 public static SelenideElement numberBtn(String number){
  return Selenide.$(By.id("digit_" + number+""));
 }


}
