package com.sakthi.micronaut.hello;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class HelloWorldControllerTest {

    @Inject
    @Client("/")
    HttpClient client;

    @Test
    void testHelloWorld() {
        var response = client.toBlocking().retrieve("/hello");
        assertEquals("Hello World!", response);
    }

    @Test
    void testHelloWorldWithPropertyResponseCode() {
        var response = client.toBlocking().exchange("/hello", String.class);
        assertEquals("Hello World!", response.body());
        assertEquals(HttpStatus.OK, response.status());

    }

}