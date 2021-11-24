package com.devTest.UnitTestingWithSpringJunitAndMockito;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonStrictModeTest {
    String actualResponse  = "{\"id\":1, \"name\":\"Raj\", \"age\":30}";

    @Test
    public void json_strict_true_validation() throws JSONException {
        String expected = "{\"id\":1, \"name\":\"Raj\"}";
        //test fails as Strict = true and age field is missing.
        JSONAssert.assertEquals(expected, actualResponse, true);
    }

    @Test
    public void json_strict_false_validation() throws JSONException {
        String expected = "{\"id\":1, \"name\":\"Raj\"}";
        JSONAssert.assertEquals(expected, actualResponse, false);
    }
}
