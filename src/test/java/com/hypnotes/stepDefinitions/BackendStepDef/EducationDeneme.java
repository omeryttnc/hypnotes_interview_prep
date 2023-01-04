package com.hypnotes.stepDefinitions.BackendStepDef;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hypnotes.enums.TherapistInfo;
import com.hypnotes.pojo.educationPojo.EducationPojo;
import com.hypnotes.utilities.ReadTxt;
import com.hypnotes.utilities.WriteToTxt;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static com.hypnotes.stepDefinitions.UIStepDef.Hooks.faker;
import static io.restassured.RestAssured.given;

public class EducationDeneme {
    Response response;
    Response responseAddEducation;
    Response responseRemoveEducation;
    String userSessionId;
    String schoolName, depatment, description, endDate, startDate;
    JsonPath jsonPath;

    ObjectMapper objectMapper = new ObjectMapper();
    static int educationId;


    public String getSessionID(String email, String password) {
        response = given()
                .headers(
                        "content-type", "application/x-www-form-urlencoded")
                .body("\"username\":\"" + email + "\",\"password\":\"" + password + "\"")
                .post("https://test.hypnotes.net/api/login");

        return (response.headers().getValue("set-cookie").split("=")[1].split(";")[0]);

    }

    /**
     * JavaDoc
     * <p>
     * get session id by using ENUM
     *
     * @param therapistInfo enum dan session id sini almak istedigim kullaniciyi sectim
     * @return secilen kullanicinin session Id si
     * @author omeryttnc
     * @since 04.01.2023
     */
    public String getSessionID(TherapistInfo therapistInfo) {
        response = given()
                .headers(
                        "content-type", "application/x-www-form-urlencoded")
                .body("{\"username\":\"interview_therapist_enterprise@mailsac.com\",\"password\":\"12ASDasd.,asdASD34\"}")
//                .body("\"username\":\"" + therapistInfo.getEmail() + "\",\"password\":\"" + therapistInfo.getPassword() + "\"")
                .post("https://test.hypnotes.net/api/login");
response.prettyPrint();
        return (response.headers().getValue("set-cookie").split("=")[1].split(";")[0]);

    }

    @Before
    public void setUpEnvironment() {
        schoolName = faker.company().name();
        depatment = faker.company().name();
        description = faker.shakespeare().hamletQuote();
        startDate = getDateForEducationBackend(0);
        endDate = getDateForEducationBackend(10);

        userSessionId = getSessionID(TherapistInfo.ENTERPRISE);
    }

    public Response addEducation(String schoolName, String department, String startedAt, String enddedAt, String description,String userSessionId) {
        response = given()
                .headers(
                        "content-type", "application/x-www-form-urlencoded",
                        "cookie", "PHPSESSID=" + userSessionId)
                .body(

                        "schoolName=" + schoolName +
                                "&department=" + department +
                                "&startedAt=" + startedAt +
                                "&enddedAt=" + enddedAt +
                                "&description=" + description


                )
                .post("https://test.hypnotes.net/api/profile/addEducation");

        return response;
    }


    @Test
    public void addEducationTest() {

//        responseAddEducation = addEducation(
//                schoolName,
//                depatment,
//                startDate,
//                endDate,
//                description
//        );
        jsonPath = responseAddEducation.jsonPath();
        Assert.assertEquals(200, responseAddEducation.statusCode());
        Assert.assertTrue(jsonPath.getBoolean("success"));
        Assert.assertTrue(jsonPath.getBoolean("education.isActive"));
        Assert.assertEquals(schoolName, jsonPath.getString("education.schoolName"));
        Assert.assertEquals(depatment, jsonPath.getString("education.department"));
        Assert.assertEquals(description, jsonPath.getString("education.description"));
        educationId = jsonPath.getInt("education.id");


        WriteToTxt.saveTitle("target/educatioIdFile.txt", educationId, false);
//        Assert.assertEquals(startDate.replace(" GMT",".000000"),jsonPath.getString("education.startedAt"));
//        Assert.assertEquals(endDate.replace(" GMT",".000000"),jsonPath.getString("education.enddedAt"));


    }


    @Test
    public void updateTest() {
//        updateEducation(
//                schoolName,
//                depatment,
//                startDate,
//                endDate,
//                description,
//                ReadTxt.returntitle("target/educatioIdFile.txt")
//
//        );

        Assert.assertEquals(200, responseAddEducation.statusCode());
        Assert.assertTrue(jsonPath.getBoolean("success"));
        Assert.assertTrue(jsonPath.getBoolean("education.isActive"));
        Assert.assertEquals(schoolName, jsonPath.getString("education.schoolName"));
        Assert.assertEquals(depatment, jsonPath.getString("education.department"));
        Assert.assertEquals(description, jsonPath.getString("education.description"));
    }

    public Response updateEducation(String userSessionId,String schoolName, String department, String startedAt, String enddedAt, String description, String educationId) {
        response = given()
                .headers(
                        "content-type", "application/x-www-form-urlencoded",
                        "cookie", "PHPSESSID=" + userSessionId)
                .body(

                        "schoolName=" + schoolName +
                                "&department=" + department +
                                "&startedAt=" + startedAt +
                                "&enddedAt=" + enddedAt +
                                "&description=" + description +
                                "&educationId=" + educationId


                )
                .post("https://test.hypnotes.net/api/profile/updateEducation");
        response.prettyPrint();
        return response;
    }

    public Response removeEducation(String userSessionId,String educationId) {
        response = given()
                .headers(
                        "content-type", "application/x-www-form-urlencoded",
                        "cookie", "PHPSESSID=" + userSessionId)
                .body(


                        "&educationId=" + educationId


                )
                .post("https://test.hypnotes.net/api/profile/removeEducation");
        response.prettyPrint();
        return response;
    }


    @Test
    public void removeEducationTest_1() {

       // responseRemoveEducation = removeEducation(ReadTxt.returntitle("target/educatioIdFile.txt"));
        Assert.assertEquals(200, responseRemoveEducation.statusCode());
        Assert.assertTrue(jsonPath.getBoolean("success"));
    }

    @Test
    public void removeEducationTest_2() {
        Random random = new Random();
        int randomEducation = random.nextInt(getActiveEducationId().size());
        int lastIndex = getActiveEducationId().size() - 1;
      //  responseRemoveEducation = removeEducation(String.valueOf(getActiveEducationId().get(lastIndex)));
        jsonPath = responseRemoveEducation.jsonPath();
        Assert.assertEquals(200, responseRemoveEducation.statusCode());
        Assert.assertTrue(jsonPath.getBoolean("success"));
    }

    /**
     * education ekliyorken kullandigimiz saat formati
     *
     * @param skipDate kac gun skip edecegimiz miktari yaziyoruz
     * @return backend in istedigi format da tarihi
     * @author omeryttnc
     * @since 04.01.2023
     */
    public String getDateForEducationBackend(int skipDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, skipDate);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss");
        return (simpleDateFormat.format(calendar.getTime()) + " GMT");
    }


    public EducationPojo getUserInfo() {

        response = given()
                .headers(
                        "content-type", "application/x-www-form-urlencoded",
                        "cookie", "PHPSESSID=" + userSessionId)
                .body(
                        "&timezone=" + "Europe/London"
                )
                .post("https://test.hypnotes.net/api/dashboard/getUser");

        EducationPojo educationPojo;

        try {
            educationPojo = objectMapper.readValue(response.asString(), EducationPojo.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return educationPojo;

    }


    public List<Integer> getActiveEducationId() {

        EducationPojo userInfo = getUserInfo();

//        for (int i = 0; i < userInfo.getProfile().getEducations().size(); i++) {
//
//            System.out.println(userInfo.getProfile().getEducations().get(i).getId());
//        }
        System.out.println("************");
        List<Integer> collect = userInfo.getProfile().getEducations()
                .stream()
                .filter(t -> t.getIsActive() == true)
                .map(t -> t.getId())
                .collect(Collectors.toList());

        return collect;


    }
}
