package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GreeterTest {

    @Test
    void testGreet() {
        Greeter greeter = new Greeter();

        String expectedResult = "Hello, audy";
        String actualResult = greeter.hello("audy");

        Assertions.assertEquals(expectedResult, actualResult);
    }
}