package com.hypnotes.stepDefinitions.BackendStepDef;

import com.github.javafaker.Faker;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ServiceBackEndCalismalari {
    boolean isTestEnvironment = true;
    String userSessionId = "13i2p2d1b40l6d6sgdpfo618sl";
    Response response;
    JsonPath jsonPath;
    Faker faker = new Faker();


    public int createIndividualSession(
            String userSessionId,
            boolean isTestEnvironment,
            String title,
            int price,
            boolean showPrice,
            int duration,
            int blockBefore,
            int blockAfter,
            boolean paymentRequired,
            boolean bookable,
            String description,
            boolean online

    ) {
        response = given()
                .headers(
                        "content-type", "application/x-www-form-urlencoded",
                        "cookie", "PHPSESSID=" + userSessionId
                )
                .body(
                        "title=" + title +
                                "&price=" + price +
                                "&showPrice=" + intToBoolean(showPrice) +
                                "&duration=" + duration +
                                "&blockBefore=" + blockBefore +
                                "&blockAfter=" + blockAfter +
                                "&paymentRequired=" + intToBoolean(paymentRequired) +
                                "&bookable=" + intToBoolean(bookable) +
                                "&description=" + description +
                                "&online=" + online
                )
                .post("https://test.hypnotes.net/api/settings/meeting/category/add");
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(response.jsonPath().getBoolean("success"));
        return response.jsonPath().getInt("category.id");

    }

    public int createIndividualSession(
            String userSessionId,
            boolean isTestEnvironment,
            String title


    ) {
        int price = 30;
        boolean showPrice = true;
        int duration = 45;
        int blockBefore = 0;
        int blockAfter = 0;
        boolean paymentRequired = true;
        boolean bookable = true;
        String description = "individual";
        boolean online = true;
        response = given()
                .headers(
                        "content-type", "application/x-www-form-urlencoded",
                        "cookie", "PHPSESSID=" + userSessionId
                )
                .body(
                        "title=" + title +
                                "&price=" + price +
                                "&showPrice=" + intToBoolean(showPrice) +
                                "&duration=" + duration +
                                "&blockBefore=" + blockBefore +
                                "&blockAfter=" + blockAfter +
                                "&paymentRequired=" + intToBoolean(paymentRequired) +
                                "&bookable=" + intToBoolean(bookable) +
                                "&description=" + description +
                                "&online=" + online
                )
                .post("https://" + (isTestEnvironment ? "test." : "") + "hypnotes.net/api/settings/meeting/category/add");
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(response.jsonPath().getBoolean("success"));
        return response.jsonPath().getInt("category.id");

    }


    @Test
    public void name() {
        createIndividualSession(userSessionId,
                isTestEnvironment,
                faker.funnyName().name(),
                30,
                true,
                45,
                0,
                20,
                true,
                true,
                "individual",
                true
        );

    }

    public int intToBoolean(boolean input) {
        return input ? 1 : 0;
    }


    public int createPackageSession(
            String userSessionId,
            String title,
            int price,
            boolean showPrice,
            int duration,
            boolean paymentRequired,
            boolean bookable,
            int totalSessions,
            int sessionInterval,
            String description,
            int blockAfter,
            int blockBefore,
            boolean online

    ) {
        response = given()
                .headers(
                        "content-type", "application/x-www-form-urlencoded",
                        "cookie", "PHPSESSID=" + userSessionId
                )
                .body(
                        "title=" + title +
                                "&price=" + price +
                                "&showPrice=" + intToBoolean(showPrice) +
                                "&duration=" + duration +
                                "&paymentRequired=" + intToBoolean(paymentRequired) +
                                "&bookable=" + intToBoolean(bookable) +
                                "&totalSessions=" + totalSessions +
                                "&sessionInterval=" + sessionInterval +
                                "&description=" + description +
                                "&blockAfter=" + blockAfter +
                                "&blockBefore=" + blockBefore +
                                "&online=" + online
                )
                .post("https://test.hypnotes.net/api/settings/meeting/category/add");
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(response.jsonPath().getBoolean("success"));
        response.prettyPrint();
        return response.jsonPath().getInt("category.id");

    }

    @Test
    public void packagecreate() {
        createPackageSession(userSessionId,
                faker.funnyName().name(),
                30,
                true,
                45,
                true,
                true,
                5,
                7,
                "package",
                0,
                0,
                true);
    }
}
