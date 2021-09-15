package com.aws.codestar.projecttemplates.controller;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for {@link OAuth2ProtectedController}. Modify the tests in order to support your use case as you build your project.
 */
@DisplayName("Tests for HelloWorldController")
class OAuth2ProtectedControllerTest {

    private final OAuth2ProtectedController controller = new OAuth2ProtectedController();

    /**
     * Initializing variables before we run the tests.
     * Use @BeforeAll for initializing static variables at the start of the test class execution.
     * Use @BeforeEach for initializing variables before each test is run.
     */
    @BeforeAll
    static void setup() {
        // Use as needed.
    }

    /**
     * De-initializing variables after we run the tests.
     * Use @AfterAll for de-initializing static variables at the end of the test class execution.
     * Use @AfterEach for de-initializing variables at the end of each test.
     */
    @AfterAll
    static void tearDown() {
        // Use as needed.
    }

    /**
     * Basic test to verify the result obtained when calling {@link OAuth2ProtectedController#helloWorld()} successfully.
     */
    @Test
    @DisplayName("Basic test for GET request")
    void testGetRequest() {
        ResponseEntity responseEntity = controller.helloWorld();

        // Verify the response obtained is 200
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
}