package com.hypnotes.enums;

public enum ColorIndexEnum {

    GroupSession(2),
    Packages(1),
    Individual(0),
    ShowedUp(3),
    Canceled(5),
    Reschedule(4),
    Noshow(6);
    private String colorCode;
    private int index;

    ColorIndexEnum(int index) {
        this.colorCode = colorCode;
        this.index = index;
    }
}
