package com.example.lucas.deliva.data.model.type;

import com.example.lucas.deliva.AppApplication;
import com.example.lucas.deliva.R;

public enum PaymentStatusType {

    INVALID(-1, "INVALID"),

    PAID(0, AppApplication.getAppContext().getString(R.string.profile_fragment_title)),

    PENDENT(1, AppApplication.getAppContext().getString(R.string.orders_fragment_title));


    private final int value;
    private final String name;

    PaymentStatusType(final int value, final String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static PaymentStatusType fromInt(final int intValue) {
        for (final PaymentStatusType type : PaymentStatusType.values()) {
            if (intValue == type.getValue()) {
                return type;
            }
        }
        return INVALID;
    }


}


