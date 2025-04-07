package steps;

import io.qameta.allure.Step;
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
}
