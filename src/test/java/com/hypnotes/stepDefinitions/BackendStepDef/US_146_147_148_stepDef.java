package com.hypnotes.stepDefinitions.BackendStepDef;

import com.hypnotes.enums.TherapistInfo;
import com.hypnotes.utilities.ReadTxt;
import com.hypnotes.utilities.WriteToTxt;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import static com.hypnotes.stepDefinitions.UIStepDef.Hooks.faker;

public class US_146_147_148_stepDef {

    EducationDeneme educationDeneme = new EducationDeneme();
    String userSessionID;
    String schoolName, depatment, description, endDate, startDate;
    JsonPath jsonPath;
    int educationId;
    Response responseAddEducation, responseRemoveEducation;

    @Given("get session Id")
    public void getSessionId() {
        userSessionID = educationDeneme.getSessionID(TherapistInfo.ENTERPRISE);
        schoolName = faker.company().name();
        depatment = faker.company().name();
        description = faker.shakespeare().hamletQuote();
        startDate = educationDeneme.getDateForEducationBackend(0);
        endDate = educationDeneme.getDateForEducationBackend(10);
    }

    @When("add education step")
    public void addEducationStep() {

        responseAddEducation = educationDeneme.addEducation(
                schoolName,
                depatment,
                startDate,
                endDate,
                description,
                userSessionID
        );
        responseAddEducation.prettyPrint();
    }

    @Then("assert add education take place correctly")
    public void assertAddEducationTakePlaceCorrectly() {
        jsonPath = responseAddEducation.jsonPath();
        Assert.assertEquals(200, responseAddEducation.statusCode());
        Assert.assertTrue(jsonPath.getBoolean("success"));
        Assert.assertTrue(jsonPath.getBoolean("education.isActive"));
        Assert.assertEquals(schoolName, jsonPath.getString("education.schoolName"));
        Assert.assertEquals(depatment, jsonPath.getString("education.department"));
        Assert.assertEquals(description, jsonPath.getString("education.description"));
        educationId = jsonPath.getInt("education.id");


        WriteToTxt.saveTitle("target/educatioIdFile.txt", educationId, false);
    }

    @When("update education step")
    public void updateEducationStep() {
        responseAddEducation = educationDeneme.updateEducation(
                userSessionID,
                schoolName,
                depatment,
                startDate,
                endDate,
                description,
                ReadTxt.returntitle("target/educatioIdFile.txt")

        );


    }

    @Then("assert update education take place correctly")
    public void assertUpdateEducationTakePlaceCorrectly() {
        Assert.assertEquals(200, responseAddEducation.statusCode());
        jsonPath = responseAddEducation.jsonPath();
        Assert.assertTrue(jsonPath.getBoolean("success"));
        Assert.assertTrue(jsonPath.getBoolean("education.isActive"));
        Assert.assertEquals(schoolName, jsonPath.getString("education.schoolName"));
        Assert.assertEquals(depatment, jsonPath.getString("education.department"));
        Assert.assertEquals(description, jsonPath.getString("education.description"));
    }

    @When("remove education step")
    public void removeEducationStep() {
        responseRemoveEducation = educationDeneme.removeEducation(userSessionID, ReadTxt.returntitle("target/educatioIdFile.txt"));

    }

    @Then("assert remove education take place correctly")
    public void assertRemoveEducationTakePlaceCorrectly() {
        Assert.assertEquals(200, responseRemoveEducation.statusCode());
        jsonPath = responseRemoveEducation.jsonPath();
        Assert.assertTrue(jsonPath.getBoolean("success"));
    }
}
