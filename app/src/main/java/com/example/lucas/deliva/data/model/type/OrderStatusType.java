package com.example.lucas.deliva.data.model.type;

import com.example.lucas.deliva.AppApplication;
import com.example.lucas.deliva.R;

public enum OrderStatusType {

    REQUESTED(0, AppApplication.getAppContext().getString(R.string.order_status_id_1)),

    APPROVED(1, AppApplication.getAppContext().getString(R.string.order_status_id_2)),

    DONE(2, AppApplication.getAppContext().getString(R.string.order_status_id_3));


    private final int value;
    private final String name;

    OrderStatusType(final int value, final String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static OrderStatusType fromInt(final int intValue) {
        for (final OrderStatusType type : OrderStatusType.values()) {
            if (intValue == type.getValue()) {
                return type;
            }
        }
        return REQUESTED;
    }

}
