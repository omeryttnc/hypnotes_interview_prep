package com.hypnotes.stepDefinitions.BackendStepDef;

import com.hypnotes.utilities.ApiUtilities;
import com.hypnotes.utilities.BrowserUtilities;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.hypnotes.stepDefinitions.UIStepDef.Hooks.*;
import static io.restassured.RestAssured.given;

public class US_103_stepDef {
    Response response;

    Map<String, String> colorBackend = new HashMap<>();
    Map<String, String> colorUI = new HashMap<>();

    enum colorIndex {
        GroupSession(getColourOfService(2), 2),
        Packages(getColourOfService(1), 1),
        Individual(getColourOfService(0), 0),
        ShowedUp(getColourOfService(3), 3),
        Canceled(getColourOfService(5), 5),
        Reschedule(getColourOfService(4), 4),
        Noshow(getColourOfService(6), 6);;
        private String colorCode;
        private int index;

        colorIndex(String colorCode, int index) {
            this.colorCode = colorCode;
            this.index = index;
        }

        public String getColorCode() {
            return colorCode;
        }

        public int getIndex() {
            return index;
        }
    }

    @Given("get all color from backend")
    public void getAllColorFromBackend() {
        userSessionID = driver.manage().getCookieNamed("PHPSESSID").toString().split("=")[1].split(";")[0];
        System.out.println("userSessionID = " + userSessionID);
        System.out.println("driver.manage().getCookieNamed(\"PHPSESSID\").toString().split(\"=\")[1].split(\";\")[0] = " + driver.manage().getCookieNamed("PHPSESSID").toString().split("=")[1].split(";")[0]);
        BrowserUtilities.waitForPageToLoad(10);
        BrowserUtilities.wait(5);

        colorBackend = ApiUtilities.Colors.getColor();
    }


    @And("get all color from UI")
    public void getAllColorFromUI() {
        for (int i = 0; i < colorIndex.values().length; i++) {

            colorUI.put(colorIndex.values()[i].name(), getColourOfService(colorIndex.values()[i].index));
        }
        System.out.println("colorBackend = " + colorBackend);
        System.out.println("colorUI = " + colorUI);
    }

    @Then("assert if UI color and backend color are matching")
    public void assertIfUIColorAndBackendColorAreMatching(DataTable dataTable) {

        List<String> index = dataTable.column(0);
        List<String> colorType = dataTable.column(1);


        for (int i = 0; i < colorType.size(); i++) {
            System.out.println(colorBackend.get(colorType.get(i)));
            System.out.println(hexToRgba(colorBackend.get(colorType.get(i))));
            System.out.println(colorUI.get(colorType.get(i)));

            Assert.assertEquals(hexToRgba(colorBackend.get(colorType.get(i))), colorUI.get(colorType.get(i)));

            System.out.println("******");
        }
    }

    @When("change color of from backend")
    public void changeColorOfFromBackend() {
        for (int i = 0; i < colorIndex.values().length; i++) {
            String hex = faker.color().hex();

            ApiUtilities.Colors.setColor(colorIndex.values()[i].name(), hex);
            driver.navigate().refresh();
            BrowserUtilities.waitForPageToLoad(10);
            BrowserUtilities.wait(3);

            System.out.println(getColourOfService(colorIndex.values()[i].getIndex()));
            System.out.println(hex);
            System.out.println(hexToRgba(hex));

            Assert.assertEquals(getColourOfService(colorIndex.values()[i].getIndex()), hexToRgba(hex));
        }
    }


    public void setColor(String userSessionId, boolean isTestEnvironment, String colorType, String hex) {
        response = given().
                headers(
                        "content-type", "application/x-www-form-urlencoded",
                        "cookie", "PHPSESSID=" + userSessionId
                ).body(colorType + "=" + hex)
                .post("https://" + (isTestEnvironment ? "test." : "") + "hypnotes.net/api/schedule/inCalender/setCategoryColor");
        Assert.assertEquals(200, response.statusCode());
        response.prettyPrint();
    }


    public Map<String, String> getColor() {
        Map<String, String> map = new HashMap<>();
        response = given().
                headers(
                        "content-type", "application/x-www-form-urlencoded",
                        "cookie", "PHPSESSID=" + userSessionID
                )
                .post("https://" + (isTestEnvironment ? "test." : "") + "hypnotes.net/api/schedule/inCalender/getCategoryColor");
        System.out.println("sssss");
        response.prettyPrint();
        System.out.println("sssss");
        List<String> title = response.jsonPath().getList("title");
        List<String> color = response.jsonPath().getList("color");

        for (int i = 0; i < title.size(); i++) {
            map.put(title.get(i), color.get(i));
        }


        Assert.assertEquals(response.statusCode(), 200);
        return map;


    }


    public static String getColourOfService(int i_0$p_1$g_2$s_3$r_4$c_5$n_6$go_7) {
        return commonPage.getCalendar().colorToChange.get(i_0$p_1$g_2$s_3$r_4$c_5$n_6$go_7).getCssValue("background-color");
    }

    public String hexToRgba(String hex) {
        Color color = Color.decode(hex);
        return "rgba(" + color.getRed() + ", " + color.getGreen() + ", " + color.getBlue() + ", " + color.getTransparency() + ")";

    }


}
