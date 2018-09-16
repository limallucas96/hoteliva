package com.example.lucas.deliva.business;

public enum BusinessErrorCode {
    INVALID(0, "Invalid"),
    GENERIC_ERROR(1, "Generic"),
    INTERNET_CONNECTION_UNAVAILABLE(2, "No internet");

    private final int value;
    private final String name;

    BusinessErrorCode(final int value, final String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static BusinessErrorCode fromInt(final int intValue) {
        for (final BusinessErrorCode type : BusinessErrorCode.values()) {
            if (intValue == type.getValue()) {
                return type;
            }
        }
        return INVALID;
    }

    public static BusinessErrorCode fromString(final String stringValue) {
        for (final BusinessErrorCode type : BusinessErrorCode.values()) {
            if (stringValue.equals(type.getName())) {
                return type;
            }
        }
        return INVALID;
    }
}