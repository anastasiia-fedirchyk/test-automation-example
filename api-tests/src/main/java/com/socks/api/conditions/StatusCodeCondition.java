package com.socks.api.conditions;

import io.restassured.response.Response;

public class StatusCodeCondition implements Condition {

    private final int statusCode;

    public StatusCodeCondition(int statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public void check(Response response) {
        response.then().statusCode(statusCode);
    }
}
