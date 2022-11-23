package com.hypnotes.utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.Data;
import org.junit.Assert;

import java.io.IOException;
import java.util.List;

import static com.hypnotes.stepDefinitions.UIStepDef.Hooks.*;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.trustStore;

public class ApiUtilities {

}

