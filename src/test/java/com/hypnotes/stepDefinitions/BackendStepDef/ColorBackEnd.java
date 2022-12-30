package com.hypnotes.stepDefinitions.BackendStepDef;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.Colors;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ColorBackEnd {
    Response response;
    String userSessionId = "7tdco8covg3o1d3jv7agf6ab60";
    boolean isTestEnvironment = false;


    @Test
    public void testGetColor() {

        System.out.println("getColor(userSessionId,isTestEnvironment) = " + getColor(userSessionId, isTestEnvironment));


    }


    public void setColor(String userSessionId, boolean isTestEnvironment, String colorType, String hex) {
        response = given().
                headers(
                        "content-type", "application/x-www-form-urlencoded",
                        "cookie", "PHPSESSID=" + userSessionId
                ).body(colorType + "=" + hex)
                .post("https://" + (isTestEnvironment ? "test." : "") + "hypnotes.net/api/schedule/inCalender/setCategoryColor");

    }

    public Map<String, String> getColor(String userSessionId, boolean isTestEnvironment) {
        Map<String, String> map = new HashMap<>();

        response = given().
                headers(
                        "content-type", "application/x-www-form-urlencoded",
                        "cookie", "PHPSESSID=" + userSessionId
                )
                .post("https://" + (isTestEnvironment ? "test." : "") + "hypnotes.net/api/schedule/inCalender/getCategoryColor");

        List<String> title = response.jsonPath().getList("title");
        List<String> color = response.jsonPath().getList("color");

        for (int i = 0; i < title.size(); i++) {
            map.put(title.get(i), color.get(i));
        }


        Assert.assertEquals(response.statusCode(), 200);
        return map;


    }

    @Test
    public void sda() {
        System.out.println(Colors.BLUEVIOLET.getColorValue().asHex());
        System.out.println("hexToRgb(Colors.BLUEVIOLET.getColorValue().asHex()) = " + hexToRgb(Colors.BLUEVIOLET.getColorValue().asHex()));
        System.out.println(Colors.BLUEVIOLET.getColorValue().asRgb());
        System.out.println(Colors.BLUEVIOLET.getColorValue().asRgba());
    }

    public String hexToRgb(String hex) {
        Color color = Color.decode(hex);
        return "rgb(" + color.getRed() + ", " + color.getGreen() + ", " + color.getBlue() + ")";

    }

    public String hexToRgba(String hex) {
        Color color = Color.decode(hex);
        return "rgba(" + color.getRed() + ", " + color.getGreen() + ", " + color.getBlue() + ", " + color.getTransparency() + ")";

    }

    public String rgbToHex(String rgb) {
        rgb = rgb.replace("rgb(", "").replace(" ", "").replace(")", "");

        String[] split = rgb.split(",");

        int red = Integer.parseInt(split[0]);
        int green = Integer.parseInt(split[1]);
        int blue = Integer.parseInt(split[2]);

//        return Integer.toHexString(new Color(red,green,blue).getRGB()).replace("ff","#");
        return String.format("#%02x%02x%02x", red, green, blue);


    }
}
