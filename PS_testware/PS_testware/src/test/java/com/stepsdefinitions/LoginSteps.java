package com.stepsdefinitions;

import com.base.BaseUtil;
import com.pages.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import com.config.Configuration;

import java.io.IOException;


public class LoginSteps extends BaseUtil {

    private BaseUtil base;
    public LoginPage lp;
    public Configuration cf;

    public LoginSteps(BaseUtil base) {
        this.base = base;
    }

   @Given("Navigate to the login page")
    public void navigateToTheLoginPage() {
       lp = new LoginPage(base.getDriver());
       lp.GoToLogin();
    }

    @When("SignIN to my account")
        public void sign_in_to_my_account () throws IOException {
            lp.SignIn();
        }
}
