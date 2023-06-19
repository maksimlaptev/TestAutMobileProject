import env.Env_mobile;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.main.MainScreenSteps;

public class TestCalculator extends Env_mobile {
    MainScreenSteps authPageSteps;

    // The annotation BeforeClass is necessary for the actions that must be performed before the execution of all tests of this class
    @BeforeClass
    private void actionBeforeClass(){
        authPageSteps = new MainScreenSteps();
    }
    @BeforeMethod
    private void actionBeforeMethod(){
        authPageSteps.stepClickClearBtn();
    }

    @Test
    @Description("Checking the addition of two numbers.")
    private void testVerifyOperationPlus() {

        authPageSteps.stepClickOnNumber("5");
        authPageSteps.stepClickPlusBtn();
        authPageSteps.stepClickOnNumber("5");
        authPageSteps.stepClickEquals();
        authPageSteps.stepVerifyFinalResult("10");

    }

    @Test
    @Description("Checking the subtraction of two numbers.")
    private void testVerifyOperationMinus() {

        authPageSteps.stepClickOnNumber("1");
        authPageSteps.stepClickOnNumber("5");
        authPageSteps.stepClickMinusBtn();
        authPageSteps.stepClickOnNumber("5");
        authPageSteps.stepClickEquals();
        authPageSteps.stepVerifyFinalResult("10");

    }

    @Test
    @Description("Checking the multiply of two numbers.")
    private void testVerifyOperationMultiply() {

        authPageSteps.stepClickOnNumber("1");
        authPageSteps.stepClickOnNumber("0");
        authPageSteps.stepClickMultiplyBtn();
        authPageSteps.stepClickOnNumber("5");
        authPageSteps.stepClickEquals();
        authPageSteps.stepVerifyFinalResult("50");

    }

    @Test
    @Description("Checking the divide of two numbers.")
    private void testVerifyOperationDivide() {

        authPageSteps.stepClickOnNumber("1");
        authPageSteps.stepClickOnNumber("5");
        authPageSteps.stepClickDivideBtn();
        authPageSteps.stepClickOnNumber("3");
        authPageSteps.stepClickEquals();
        authPageSteps.stepVerifyFinalResult("5");

    }
}
