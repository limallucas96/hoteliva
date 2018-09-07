package com.example.lucas.deliva.data.model.type;

public enum OrderListType {

    INVALID(-1),

    PROFILE(0),

    ORDER(1),

    STATUS(2);

    private final int value;

    OrderListType(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static OrderListType fromInt(final int intValue) {
        for (final OrderListType type : OrderListType.values()) {
            if (intValue == type.getValue()) {
                return type;
            }
        }
        return INVALID;
    }

}
