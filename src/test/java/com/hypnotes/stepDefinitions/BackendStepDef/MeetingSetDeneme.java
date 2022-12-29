package com.hypnotes.stepDefinitions.BackendStepDef;

import com.hypnotes.utilities.ApiUtilities;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class MeetingSetDeneme {

    Response response;
    String userSessionId = "1buurev9krddc3qhh66kh1omld";
    boolean isTestEnvironment = true;

    public void getMeetingsInfo(String userSessionId, boolean isTestEnvironment) {
        response = given().
                headers(
                        "content-type", "application/x-www-form-urlencoded",
                        "cookie", "PHPSESSID=" + userSessionId
                )
                .post("https://" + (isTestEnvironment ? "test." : "") + "hypnotes.net/api/settings/meeting/get");
        response.prettyPrint();

    }

    class MeetingInfo {

        List<Integer> meetingId;
        List<String> createdDate, clientName, clientEmail, clientSurname;
        String userSessionId;
        boolean isTestEnvironment;

        public MeetingInfo(String userSessionId, boolean isTestEnvironment) {
            this.userSessionId = userSessionId;
            this.isTestEnvironment = isTestEnvironment;
            response = given().
                    headers(
                            "content-type", "application/x-www-form-urlencoded",
                            "cookie", "PHPSESSID=" + userSessionId
                    )
                    .post("https://" + (isTestEnvironment ? "test." : "") + "hypnotes.net/api/settings/meeting/get");


            meetingId = response.jsonPath().getList("id");
            createdDate =response.jsonPath().getList("datetime.date");
            clientEmail= response.jsonPath().getList("client.clientInfos.email").stream().map(Object::toString).map(t->t.replace("[","").replace("]","")).collect(Collectors.toList());
            clientName= response.jsonPath().getList("client.clientInfos.name").stream().map(Object::toString).map(t->t.replace("[","").replace("]","")).collect(Collectors.toList());
            clientSurname= response.jsonPath().getList("client.clientInfos.surname").stream().map(Object::toString).map(t->t.replace("[","").replace("]","")).collect(Collectors.toList());
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

    @Test
    public void name() {
        MeetingInfo meetingInfo = new MeetingInfo(userSessionId,isTestEnvironment);
        System.out.println(meetingInfo.getClientEmail());
        System.out.println(meetingInfo.getMeetingId());
        System.out.println(meetingInfo.getClientName());
        System.out.println(meetingInfo.getClientSurname());
        System.out.println(meetingInfo.getCreatedDate());

    }

    @Test
    public void sfds() {
        ApiUtilities.Meetings.MeetingInfo meetingInfo =new ApiUtilities.Meetings.MeetingInfo();
        System.out.println(meetingInfo.getClientEmail());
        System.out.println(meetingInfo.getMeetingId());
        System.out.println(meetingInfo.getClientName());
        System.out.println(meetingInfo.getClientSurname());
        System.out.println(meetingInfo.getCreatedDate());
    }
}
