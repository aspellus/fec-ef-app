package com.salientcrgt.ezamendment.test;

import static io.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

/**
 * Unit test for Amendment Process.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class AmendmentTest {
    @BeforeClass
    public static void init() {
        String port = System.getenv("SERVER_PORT");

        // If server.port not available in System property, then setting default
        // port to be 8080
        if (port == null)
            RestAssured.port = Integer.valueOf(8080);
        else
            RestAssured.port = Integer.valueOf(port);

        // If server.base not available in System property, then setting default
        // base to be ezamendment
        String basePath = System.getenv("SERVER_BASE");
        if (basePath == null)
            basePath = "/";
        RestAssured.basePath = basePath;

        // If server.host not available in System property, then setting default
        // host to be localhost
        String baseHost = System.getenv("SERVER_HOST");
        if (baseHost == null)
            baseHost = "http://localhost";

        RestAssured.baseURI = baseHost;
    }

    @Test
    @Ignore
    public void testCommitteeDetails() {
        get("/committee/C00431445").then().assertThat().statusCode(200).and().contentType(ContentType.JSON)
                .body("api_version", equalTo("1.0")).body("results[0].committee_id", equalTo("C00431445"))
                .body("results[0].name", equalTo("OBAMA FOR AMERICA"));
    }

}
