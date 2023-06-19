package steps.main;

import screens.MainScreenLocators;
import static com.codeborne.selenide.Selenide.page;
import static io.qameta.allure.Allure.step;
import static org.testng.Assert.assertEquals;

/** This class describes the action steps for the Calculator screen. Step descriptions appear in the report for each test. **/
public class MainScreenSteps {

    MainScreenLocators mainPage = page(MainScreenLocators.class);

    public void stepClickEquals(){
        step("Click on the Login button", ()-> {
            mainPage.equalsBtn.click();
        });
    }
    public void stepClickOnNumber(String numb) {
        step("Click on number "+ numb +"", ()-> { mainPage.numberBtn(numb).click();});
    };
    public void stepClickClearBtn() {
        step("Click on Clear btn", ()-> { mainPage.clearBtn.click();});
    }
    public void stepVerifyFinalResult(String expectedResult){
        step("Check final result", () -> {
            assertEquals(mainPage.resultFinalField.getText(), expectedResult, "Final result must be correct.");
        });
    }
    // Operation's btn
    public void stepClickPlusBtn() {
        step("Click on Plus btn", ()-> { mainPage.plusBtn.click();});
    }
    public void stepClickMinusBtn() {
        step("Click on Minus btn", ()-> { mainPage.minusBtn.click();});
    }
    public void stepClickMultiplyBtn() {
        step("Click on Multiply btn", ()-> { mainPage.multiplyBtn.click();});
    }
    public void stepClickDivideBtn() {
        step("Click on Divide btn", ()-> { mainPage.divideBtn.click();});
    }

}
