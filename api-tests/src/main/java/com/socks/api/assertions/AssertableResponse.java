package com.socks.api.assertions;

import com.socks.api.conditions.Condition;
import io.qameta.allure.Step;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class AssertableResponse {

    private Response response;

    public AssertableResponse(Response response) {
        this.response = response;
    }

    @Step("The response should have {condition}")
    public AssertableResponse shouldHave(Condition condition) {
        condition.check(response);
        return this;
    }

    public <T> T asPojo(Class<T> tClass) {
        return response.as(tClass);
    }

    public Headers headers() {
        return response.getHeaders();
    }
}
