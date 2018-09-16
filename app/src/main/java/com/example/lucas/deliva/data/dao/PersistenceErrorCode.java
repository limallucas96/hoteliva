package com.example.lucas.deliva.data.dao;

public enum PersistenceErrorCode {

    ASYNC_TASK_ERROR,
    GENERIC_ERROR,
    INVALID("Invalid");

    private final String name;

    PersistenceErrorCode(final String name) {
        this.name = name;
    }

    PersistenceErrorCode() {
        name = "";
    }

    public String getName() {
        return name;
    }

    public static PersistenceErrorCode fromString(final String stringValue) {
        for (final PersistenceErrorCode type : PersistenceErrorCode.values()) {
            if (stringValue.equals(type.getName())) {
                return type;
            }
        }
        return INVALID;
    }
}
