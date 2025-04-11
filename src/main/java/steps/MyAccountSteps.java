package steps;

import io.qameta.allure.Step;
import org.testng.Assert;
import pages.MyAccountPage;

public class MyAccountSteps {
    MyAccountPage myAccountPage;

    public MyAccountSteps() {
        this.myAccountPage = new MyAccountPage();
    }

    @Step("Open Women page")
    public void openWomenPage() {
        myAccountPage.openWomenPage();
    }

    @Step("Checking My Account title")
    public MyAccountSteps checkMyAccountTitle(String titleText) {
        Assert.assertEquals(myAccountPage.getMyAccountTitle(), titleText);
        return this;
    }
}
