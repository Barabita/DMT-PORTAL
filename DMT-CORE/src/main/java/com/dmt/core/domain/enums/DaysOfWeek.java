package com.dmt.core.domain.enums;

/**
 * @author mali.sahin
 * @since 29.05.2018.
 */
public enum DaysOfWeek {
    MONDAY("MON"),
    TUESDAY("TUE"),
    WEDNESDAY("WED"),
    THURSDAY("THU"),
    FRIDAY("FRI");

    private String value;

    DaysOfWeek(String val) {
        this.value = val;
    }

    public String getValue() {
        return value;
    }
}
