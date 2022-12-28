package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class UserAssertionTest {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI="https://gorest.co.in/public/v2";
        response= given()
                .when()
                .get("/users?page=1&per_page=20")
                .then().statusCode(200);

    }


    //1. Verify the if the total record is 20
    @Test
    public void Verifytheifthetotal() {
        response.body("per_page", equalTo(20));
    }

    //2. Verify the if the name of id = 5487 is equal to ”Hamsini Trivedi”
    @Test
    public void Test002() {
        response.body("[2].name", equalTo("Bhilangana Shah"));
    }

    //3. Check the single ‘Name’ in the Array list (Subhashini Talwar)
    @Test
    public void Test003() {
        response.body("[3].name", equalTo("Ganak Jain"));

    }

    //4. Check the multiple ‘Names’ in the ArrayList (Mrs. Menaka Bharadwaj, Msgr. Bodhan Guha, Karthik Dubashi IV)
    @Test
    public void Test004() {
        response.body("name", hasItems("Bhilangana Shah", "Ganak Jain", "Aaryan Nayar"));
    }

    //5. Verify the emai of userid = 5471 is equal “adiga_aanjaneya_rep@jast.org”
    @Test
    public void Test005() {
        response.body("[13].email", equalTo("ii_anamika_dubashi@hilpert-crona.name"));

    }

    //6. Verify the status is “Active” of user name is “Shanti Bhat V”
    @Test
    public void Test006() {
        response.body("[17].status", equalTo("active"));

    }

    //7. Verify the Gender = male of user name is “Niro Prajapat”
    @Test
    public void Test007() {
        response.body("[15].gender", equalTo("male"));
    }
}
