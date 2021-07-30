package com.socks.api.services;

import com.socks.api.assertions.AssertableResponse;
import com.socks.api.payloads.UserPayload;
import io.qameta.allure.Step;

public class UserApiService extends ApiService {

    @Step("Register a new user")
    public AssertableResponse registerNewUser(UserPayload user) {
        return new AssertableResponse(setUp()
                .body(user)
                .when()
                .post("register"));
    }
}
