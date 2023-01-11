package com.hypnotes.stepDefinitions.DatabaseStepDef.user;

import com.hypnotes.utilities.BrowserUtilities;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static com.hypnotes.stepDefinitions.UIStepDef.Hooks.*;

public class US_161_stepDef {
    private String firstName, lastName, phoneNumber, occupation, email, country;
    String createdClientId;
    Connection connection;

    @Given("click on add client side")

    public void clickOnAddClientSide() {
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        phoneNumber = faker.phoneNumber().cellPhone().replace("-", "");
        occupation = faker.company().profession();
        email = faker.internet().emailAddress();

        commonPage.getDashboardPage().addClient.click();
    }

    @And("enter first name for new client")
    public void enterFirstNameForNewClient() {
        BrowserUtilities.waitForClickability(commonPage.getClientsPage().register_firstName, 10);

        commonPage.getClientsPage().register_firstName.sendKeys(firstName);

    }

    @And("enter last name for new client")
    public void enterLastNameForNewClient() {
        commonPage.getClientsPage().register_lastName.sendKeys(lastName);
    }

    @And("enter phone number for new client")
    public void enterPhoneNumberForNewClient() {
        BrowserUtilities.cleanTextInBox(commonPage.getClientsPage().register_phone);
        commonPage.getClientsPage().register_phone.sendKeys(phoneNumber);
    }

    @And("enter occupation for new client")
    public void enterOccupationForNewClient() {
        commonPage.getClientsPage().register_occupation.sendKeys(occupation);
    }

    @And("enter email for new client")
    public void enterEmailForNewClient() {
        commonPage.getClientsPage().register_email.sendKeys(email);
    }

    @And("enter county for new client")
    public void enterCountyForNewClient() {
        BrowserUtilities.clickWithJS(commonPage.getClientsPage().register_country_genel);
        BrowserUtilities.wait(1);
        Random random = new Random();
        int randomCaountryIndex = random.nextInt(20);

        for (int j = 0; j < randomCaountryIndex; j++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();

        }
        actions.sendKeys(Keys.ENTER).perform();

        BrowserUtilities.wait(1);
        country = commonPage.getClientsPage().register_country_genel.getAttribute("value");

    }

    @And("click on add client bottom")
    public void clickOnAddClientBottom() {
        BrowserUtilities.clickWithJS(commonPage.getClientsPage().addClientBottom);

    }

    @And("collect created client Id")
    public void collectCreatedClientId() {
        BrowserUtilities.wait(3);
//        createdClientId = driver.getCurrentUrl().split("/")[5];
        createdClientId = BrowserUtilities.getDigitFromString(driver.getCurrentUrl());
        System.out.println(createdClientId);
    }

    @SneakyThrows
    @Then("compare information from UI to database")
    public void compareInformationFromUIToDatabase() {
        // querry
        String sql = "SELECT * FROM `client_info` WHERE `client_id` = " + createdClientId;

        //connection
        connection = DriverManager.getConnection(
                "jdbc:mysql://51.158.110.102:63306/hypnotes",
                "hypnotes",
                "hypnotes"
        );

        // statement
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        //inner class option
        AddedClientInfo addedClientInfo = new AddedClientInfo();

        // map option
        Map<String, String> map = new HashMap<>();
        // okumayi
        while (resultSet.next()) {

            // inner class
            addedClientInfo = new AddedClientInfo(
                    resultSet.getString("name"),
                    resultSet.getString("surname"),
                    resultSet.getString("phone"),
                    resultSet.getString("occupation"),
                    resultSet.getString(4),
                    resultSet.getString("country")

            );

            // map
            map.put("email", resultSet.getString(4));
            map.put("country", resultSet.getString("country"));
            map.put("name", resultSet.getString("name"));
            map.put("surname", resultSet.getString("surname"));
            map.put("occupation", resultSet.getString("occupation"));
            map.put("phone", resultSet.getString("phone"));


//
//            resultSet.getString(4); //email
//            resultSet.getString("country"); // country
//            resultSet.getString("name"); // name
//            resultSet.getString("surname"); // surname
//            resultSet.getString("occupation"); // occupation
//            resultSet.getString("phone"); // phone


        }

        //map assertion
        Assert.assertEquals(firstName, map.get("name"));

        // inner class ile assertion
        Assert.assertEquals(firstName, addedClientInfo.getFirstName());


        Assert.assertEquals(lastName, map.get("surname"));
        Assert.assertEquals(email, map.get("email"));
        Assert.assertEquals(country, map.get("country"));
        Assert.assertEquals(occupation, map.get("occupation"));
        Assert.assertEquals("+" + phoneNumber, map.get("phone"));


    }

    @Then("close connection")
    @SneakyThrows
    public void closeConnection() {
      //  connection.close();
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class AddedClientInfo {
        private String firstName, lastName, phoneNumber, occupation, email, country;


    }

}
