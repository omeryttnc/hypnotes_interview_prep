package com.hypnotes.utilities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.junit.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.hypnotes.stepDefinitions.UIStepDef.Hooks.isTestEnvironment;
import static com.hypnotes.stepDefinitions.UIStepDef.Hooks.userSessionID;
import static io.restassured.RestAssured.given;

public class ApiUtilities {
    static Response response;
    static ResponseSpecification responseSpecification;
    static RequestSpecification requestSpecification;


    public static void setupSpecification() {

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        if (isTestEnvironment) {

            requestSpecBuilder.setBaseUri("https://test.hypnotes.net/api");
        } else {
            requestSpecBuilder.setBaseUri("https://hypnotes.net/api");
        }
        requestSpecBuilder.addHeader("content-type", "application/x-www-form-urlencoded");
        requestSpecBuilder.addHeader("cookie", "PHPSESSID=" + userSessionID);
        requestSpecification = requestSpecBuilder.build();

        responseSpecBuilder.expectStatusCode(200);
        responseSpecBuilder.expectResponseTime(Matchers.lessThan(5000L));
      //  responseSpecBuilder.expectBody("success", Matchers.equalTo(true));
        responseSpecification = responseSpecBuilder.build();

    }


    public static void setupSpecification(String userSessionID, boolean isTestEnvironment) {

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        if (isTestEnvironment) {

            requestSpecBuilder.setBaseUri("https://test.hypnotes.net/api");
        } else {
            requestSpecBuilder.setBaseUri("https://hypnotes.net/api");
        }
        requestSpecBuilder.addHeader("content-type", "application/x-www-form-urlencoded");
        requestSpecBuilder.addHeader("cookie", "PHPSESSID=" + userSessionID);
        requestSpecification = requestSpecBuilder.build();

        responseSpecBuilder.expectStatusCode(200);
        responseSpecBuilder.expectResponseTime(Matchers.lessThan(5000L));
      //  responseSpecBuilder.expectBody("success", Matchers.equalTo(true));
        responseSpecification = responseSpecBuilder.build();

    }


    public static class Colors {
        public static void setColor(String userSessionID, boolean isTestEnvironment, String colorType, String hex) {
            setupSpecification(userSessionID, isTestEnvironment);
            response = given()
                    .spec(requestSpecification)
                    .body(colorType + "=" + hex)
                    .expect()
                    .spec(responseSpecification)
                    .when()
                    .post("/schedule/inCalender/setCategoryColor");
            response.prettyPrint();
        }

        public static Map<String, String> getColor(String userSessionID, boolean isTestEnvironment) {

            setupSpecification(userSessionID, isTestEnvironment);
            Map<String, String> map = new HashMap<>();

            response = given()
                    .spec(requestSpecification)
                    .expect()
                    .spec(responseSpecification)
                    .when()
                    .post("/schedule/inCalender/getCategoryColor");


            List<String> title = response.jsonPath().getList("title");
            List<String> color = response.jsonPath().getList("color");

            for (int i = 0; i < title.size(); i++) {
                map.put(title.get(i), color.get(i));
            }


            Assert.assertEquals(response.statusCode(), 200);
            return map;


        }

        public static void setColor(String colorType, String hex) {
            setupSpecification();
            response = given()
                    .spec(requestSpecification)
                    .body(colorType + "=" + hex)
                    .expect()
                    .spec(responseSpecification)
                    .when()
                    .post("/schedule/inCalender/setCategoryColor");
            response.prettyPrint();
        }

        public static Map<String, String> getColor() {

            setupSpecification();
            Map<String, String> map = new HashMap<>();

            response = given()
                    .spec(requestSpecification)
                    .expect()
                    .spec(responseSpecification)
                    .when()
                    .post("/schedule/inCalender/getCategoryColor");
            System.out.println("userSessionID = " + userSessionID);
            System.out.println("isTestEnvironment = " + isTestEnvironment);
            response.prettyPrint();
            List<String> title = response.jsonPath().getList("title");
            List<String> color = response.jsonPath().getList("color");

            for (int i = 0; i < title.size(); i++) {
                map.put(title.get(i), color.get(i));
            }


            Assert.assertEquals(response.statusCode(), 200);
            return map;


        }

    }

    public static class Meetings {

        public static class MeetingInfo {

            List<Integer> meetingId;
            List<String> createdDate, clientName, clientEmail, clientSurname;
            String userSessionId;
            boolean isTestEnvironment;

            public MeetingInfo(String userSessionId, boolean isTestEnvironment) {
                this.userSessionId = userSessionId;
                this.isTestEnvironment = isTestEnvironment;
                setupSpecification(userSessionID, isTestEnvironment);
                set();
            }

            public MeetingInfo() {
                setupSpecification();
                set();
            }

            private void set() {
                response = given()
                        .spec(requestSpecification)
                        .expect()
                        .spec(responseSpecification)
                        .when()
                        .post("/settings/meeting/get");


                meetingId = response.jsonPath().getList("id");
                createdDate = response.jsonPath().getList("datetime.date");
                clientEmail = response.jsonPath().getList("client.clientInfos.email").stream().map(Object::toString).map(t -> t.replace("[", "").replace("]", "")).collect(Collectors.toList());
                clientName = response.jsonPath().getList("client.clientInfos.name").stream().map(Object::toString).map(t -> t.replace("[", "").replace("]", "")).collect(Collectors.toList());
                clientSurname = response.jsonPath().getList("client.clientInfos.surname").stream().map(Object::toString).map(t -> t.replace("[", "").replace("]", "")).collect(Collectors.toList());

            }

            public List<Integer> getMeetingId() {
                return meetingId;
            }

            public List<String> getCreatedDate() {
                return createdDate;
            }

            public List<String> getClientName() {
                return clientName;
            }

            public List<String> getClientEmail() {
                return clientEmail;
            }

            public List<String> getClientSurname() {
                return clientSurname;
            }
        }

    }

}

