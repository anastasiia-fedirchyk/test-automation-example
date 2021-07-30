package com.socks.api.services;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.Filter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ApiService {


    protected RequestSpecification setUp() {
        return RestAssured
                .given().contentType(ContentType.JSON).log().all()
                .filters(getFilters());

    }

    private List<Filter> getFilters() {
        Boolean enableLogging = Boolean.valueOf(System.getProperty("logging", "true"));

        if (enableLogging) {
            return Arrays.asList(new RequestLoggingFilter(), new ResponseLoggingFilter(), new AllureRestAssured());
        } else return Collections.singletonList(new AllureRestAssured());

    }
}
