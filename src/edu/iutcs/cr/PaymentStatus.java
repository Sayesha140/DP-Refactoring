package edu.iutcs.cr;

import java.io.Serializable;


public enum PaymentStatus implements Serializable {
    PAID,
    DUE;

    public static PaymentStatus fromBoolean(boolean isPaid) {
        return isPaid ? PAID : DUE;
    }
}
