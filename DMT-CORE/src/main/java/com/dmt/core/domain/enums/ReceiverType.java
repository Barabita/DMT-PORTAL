package com.dmt.core.domain.enums;

/**
 * @author mali.sahin
 * @since 20-May-18
 */
public enum ReceiverType {

    USER("USER"), GROUP("GROUP");

    private final String value;

    ReceiverType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


}
