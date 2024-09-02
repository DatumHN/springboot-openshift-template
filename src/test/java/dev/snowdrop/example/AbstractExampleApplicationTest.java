package dev.snowdrop.example;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

import dev.snowdrop.example.service.Greeting;

public abstract class AbstractExampleApplicationTest {

    private static final String GREETING_PATH = "api/greeting";

    @Test
    public void testGreetingEndpoint() {
        given()
           .baseUri(baseURI())
           .get(GREETING_PATH)
           .then()
           .statusCode(200)
           .body("content", is(String.format(Greeting.FORMAT, "World")));
    }

    @Test
    public void testGreetingEndpointWithNameParameter() {
        given()
           .baseUri(baseURI())
           .param("name", "John")
           .when()
           .get(GREETING_PATH)
           .then()
           .statusCode(200)
           .body("content", is(String.format(Greeting.FORMAT, "John")));
    }

    protected abstract String baseURI();
}
