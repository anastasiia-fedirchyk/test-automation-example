package com.socks.tests;

import com.github.javafaker.Faker;
import com.socks.api.ProjectConfig;
import com.socks.api.conditions.Conditions;
import com.socks.api.payloads.UserPayload;
import com.socks.api.responses.UserRegistrationResponse;
import com.socks.api.services.UserApiService;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.blankString;
import static org.hamcrest.Matchers.not;

@Feature("User service tests")
@Story("User creation")
public class UsersTest {

    private final UserApiService userApiService = new UserApiService();
    private final Faker faker = new Faker();

    @BeforeClass
    public void setUp() {
        ProjectConfig config = ConfigFactory.create(ProjectConfig.class);
        RestAssured.baseURI = config.baseUrl();
    }

    @Test
    public void testRegisterNewUser() {
        UserPayload user = new UserPayload()
                .username(faker.name().username())
                .email("api-test@test.com")
                .password("123456");

        UserRegistrationResponse userResponse =
                userApiService.registerNewUser(user)
                        .shouldHave(Conditions.statusCode(200))
                        .shouldHave(Conditions.bodyField("id", not(blankString())))
//                        TODO: to modify work with pojo
                        .asPojo(UserRegistrationResponse.class);

    }

}
