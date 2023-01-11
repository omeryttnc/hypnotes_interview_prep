package com.hypnotes.stepDefinitions.DatabaseStepDef.user;

import com.hypnotes.enums.ColorIndexEnum;
import com.hypnotes.enums.TherapistInfo;
import com.hypnotes.utilities.ApiUtilities;
import com.hypnotes.utilities.DATABASE_UTILITIES;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class US_162_stepDef {
    Map<String, String> backendColor;
    Map<String, String> databaseColor;

    @Given("collect color information from backend")
    public void collectColorInformationFromBackend() {
        String userSession = ApiUtilities.getSessionID(TherapistInfo.ENTERPRISE);
        boolean isTest = true;
        backendColor = ApiUtilities.Colors.getColor(userSession, isTest);
    }

    @Given("collect color information from database")
    public void collectColorInformationFromDatabase() {
        String sql = "SELECT * FROM `category_color` WHERE `owner_id` = " + TherapistInfo.ENTERPRISE.getTherapistId();
        databaseColor = DATABASE_UTILITIES.getMapForCOLOR(sql);

        // database utilities da handle edildi
//        Connection connection = DriverManager.getConnection(
//                ConfigurationReader.getProperty("dbUrl"),
//                ConfigurationReader.getProperty("dbUser"),
//                ConfigurationReader.getProperty("dbPassword")
//        );
        //    databaseColor = new HashMap<>();
//
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setInt(1, TherapistInfo.ENTERPRISE.getTherapistId());
//        //preparedStatement.setString(2,TherapistInfo.ENTERPRISE.getEmail());
//
//        ResultSet resultSet = preparedStatement.executeQuery();

//        while (resultSet.next()) {
//
//            databaseColor.put(resultSet.getString(3), resultSet.getString(4));
//
//
//        }


    }

    @Then("compare color information from database")
    public void compareColorInformationFromDatabase() {
        for (int i = 0; i < ColorIndexEnum.values().length; i++) {

            Assert.assertEquals(
                    backendColor.get(ColorIndexEnum.values()[i].name()),
                    databaseColor.get(ColorIndexEnum.values()[i].name()));
        }

    }
}
