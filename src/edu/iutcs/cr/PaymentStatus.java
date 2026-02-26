package edu.iutcs.cr;

import java.io.Serializable;

/**
 * Replaces the raw boolean {@code isPaid} with a type-safe enum.
 * Fixes Primitive Obsession code smell.
 */
public enum PaymentStatus implements Serializable {
    PAID,
    DUE;

    public static PaymentStatus fromBoolean(boolean isPaid) {
        return isPaid ? PAID : DUE;
    }
}
