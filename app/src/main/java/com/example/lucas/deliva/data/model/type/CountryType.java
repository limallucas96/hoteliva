package com.example.lucas.deliva.data.model.type;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public enum CountryType {

    INVALID(""),

    BRAZIL("BR"),

    UNITED_STATES("US");

    private final String value;

    CountryType(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @NonNull
    public static CountryType fromString(@Nullable final String stringValue) {
        if (stringValue != null) {
            for (CountryType country : values()) {
                if (stringValue.equalsIgnoreCase(country.getValue())) {
                    return country;
                }
            }
        }
        return INVALID;
    }
}
