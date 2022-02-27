package pt.goncalo.quarkusplayground.quarkusoauthclient;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;

@QuarkusTest
class SecuredClientTest {

    @Test
    void testTokenDirect() {
        given()
                .when().get("/token/direct")
                .then()
                .statusCode(200)
                .body(isA(String.class))
        ;
    }

    @Test
    void testTokenManaged() {
        given()
                .when().get("/token/managed")
                .then()
                .statusCode(200)
                .body(isA(String.class))
        ;
    }


}