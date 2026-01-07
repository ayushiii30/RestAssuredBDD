package stepdefinitions;

import POJO.UserRequest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.ConfigReader;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

public class UserSteps {

    private Response response;

    @Given("the API base URL is set")
    public void set_base_url() {
        RestAssured.baseURI = ConfigReader.getBaseURI();
        System.out.println("Using Base URI: " + RestAssured.baseURI);
    }
    // ---------------- POST ----------------
    @When("I create a user with name {string}, username {string} and email {string}")
    public void create_user(String name, String username, String email) {
        UserRequest user = new UserRequest();
        user.setName(name);
        user.setUserName(username);
        user.setEmail(email);

        response = given()
                .header("Content-Type", "application/json")
                .body(user)
                .post("/users");
    }
    // ---------------- GET ----------------
    @When("I send a GET request to {string}")
    public void send_get_request(String endpoint) {
        response = get(endpoint);
    }

    // ---------------- PUT ----------------
    @When("I update user with id {int} with name {string}")
    public void update_user(int id, String name) {
        UserRequest user = new UserRequest();
        user.setName(name);

        response = given()
                .pathParam("id", id)
                .header("Content-Type", "application/json")
                .body(user)
                .put("/users/{id}");
    }

    // ---------------- DELETE ----------------
    @When("I delete user with id {int}")
    public void delete_user(int id) {
        response = given()
                .pathParam("id", id)
                .header("Content-Type", "application/json")
                .delete("/users/{id}");
    }

    // ---------------- THEN ----------------
    @Then("the response status code should be {int}")
    public void check_status_code(int statusCode) {
        assertEquals(response.getStatusCode(), statusCode, "Status code mismatch!");
    }
    @Then("the response should contain user with id {int}")
    public void check_user_id(int id) {
        int responseId = response.jsonPath().getInt("id");
        assertEquals(responseId, id, "User ID mismatch!");
    }

    @Then("the response should contain name {string}")
    public void check_user_name(String name) {
        String responseName = response.jsonPath().getString("name");
        assertEquals(responseName, name, "User name mismatch!");
    }
}
