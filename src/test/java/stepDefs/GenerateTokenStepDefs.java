package stepDefs;

import endPoints_services.GenerateToken;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class GenerateTokenStepDefs {
 GenerateToken generateToken=new GenerateToken();
    @Given("input valid credentials")
    public void input_valid_credentials() {
generateToken.generateToken();
    }

    @Then("verify tokenStatusCode")
    public void verify_tokenStatusCode() {
generateToken.verifyRegisterStatusCode();
    }



}
