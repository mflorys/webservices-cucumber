package stepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PostStepDefinitions {

    public final String URL = "http://localhost:3000/posts";
    private RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder().setContentType(ContentType.JSON).setBaseUri(URL);
    private RequestSpecification request = RestAssured.given(requestSpecBuilder.build().log().all());
    private Response response;

    @Given("I call GET method for posts")
    public void i_call_GET_method_for_posts() {
        response = request.get();
    }

    @Then("I can see that response code is {int}")
    public void i_can_see_that_response_code_is(int code) {
        assertThat(response.getStatusCode(), equalTo(code));
    }
}
