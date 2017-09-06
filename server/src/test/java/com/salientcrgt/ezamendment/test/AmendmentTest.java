package com.salientcrgt.ezamendment.test;

import static io.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

/**
 * Unit test for Amendment Process.
 */
public class AmendmentTest
{
	@BeforeClass
    public static void init() {
		String port = System.getProperty("server.port");
        
		// If server.port not available in System property, then setting default port to be 8080
		if (port == null) 
            RestAssured.port = Integer.valueOf(8080);
        else
            RestAssured.port = Integer.valueOf(port);
		
		// If server.base not available in System property, then setting default base to be ezamendment
        String basePath = System.getProperty("server.base");
        if(basePath == null)
            basePath = "/ezamendment/";
        RestAssured.basePath = basePath;
        // If server.host not available in System property, then setting default host to be localhost
        String baseHost = System.getProperty("server.host");
        if(baseHost == null)
            baseHost = "http://localhost";
        
        RestAssured.baseURI = baseHost;
    }
	
	@Test
    public void testCommitteeDetails() {
		get("/ezamendment/committee/C00431445")
        .then()
        .assertThat()
        .statusCode(200)
        .and()
        .contentType(ContentType.JSON)
		.body("api_version", equalTo("1.0"))
		.body("results[0].committee_id", equalTo("C00431445"))
        .body("results[0].name", equalTo("OBAMA FOR AMERICA"));
    }
	
	
}
