package com.hypnotes.enums;

public enum TherapistInfo {
    STANDARD(0, "interview_therapist_standard@mailsac.com", "12ASDasd.,asdASD34", "standard"),
    ENTERPRISE(0,"interview_therapist_enterprise@mailsac.com","12ASDasd.,asdASD34","enterprise")
    ;

    private int therapistId;
    private String email, password, fullName;

    TherapistInfo(int therapistId, String email, String password, String fullName) {
        this.therapistId = therapistId;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
    }

    public int getTherapistId() {
        return therapistId;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }
}
