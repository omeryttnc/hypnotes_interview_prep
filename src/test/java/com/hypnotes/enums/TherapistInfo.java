package com.hypnotes.enums;

public enum TherapistInfo {
    ENTERPRISE(0,"enterprise","interview_therapist_enterprise@mailsac.com","12ASDasd.,asdASD34"),
    PREMIUM(0,"premium","interview_therapist_premium@mailsac.com","12ASDasd.,asdASD34"),
    STANDARD(0,"standard","interview_therapist_standard@mailsac.com","12ASDasd.,asdASD34"),
    BASIC(0,"basic","interview_therapist_basic@mailsac.com","12ASDasd.,asdASD34"),

    ;
    private int therapistId;
    private String fullName,email,password;

    TherapistInfo(int therapistId, String fullName, String email, String password) {
        this.therapistId = therapistId;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }

    public int getTherapistId() {
        return therapistId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
