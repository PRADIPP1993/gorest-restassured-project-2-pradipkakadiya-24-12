package com.gorest.crudtest;

import com.gorest.model.UserPojo;
import com.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserCRUDTest extends TestBase {

    @Test
    public void verifyUserCreatedSuccessfully() {
        UserPojo UserPojo = new UserPojo();
        UserPojo.setName("prime");
        UserPojo.setEmail("prime123@gmail.com");
        UserPojo.setGender("male");
        UserPojo.setStatus("active");

        Response response = given().log().all()
                .header("content-Type", "application/json")
                .when()
                .body(UserPojo)
                .post();
        response.prettyPrint();
        response.then().log().all().statusCode(201);


    }
@Test
    public void verifyUserUpdateSuccessfully(){
    UserPojo UserPojo = new UserPojo();
    UserPojo.setName("prime");
    UserPojo.setEmail("prime123@gmail.com");
    UserPojo.setGender("male");
    UserPojo.setStatus("active");

    Response response = given().log().all()
            .header("Authorization", "Bearer " + "76a4442f8a4d18f9c66e99025673b0c74b593f2b8c17cb7cf7ad7e62e466d8a1")
            .header("content-Type", "application/json")
            .when()
            .body(UserPojo)
            .post();
    response.prettyPrint();
    response.then().log().all().statusCode(201);


}

}
