package com.example.demo.domain.support;

public enum PaymentMethod {
    CREDIT("Credit"),
    DEBIT("Debit"),
    GIFT("Gift");

    private String displayName;

    PaymentMethod(String displayName) {
        this.displayName = displayName;
    }

    public String getId() {
        return name();
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return getDisplayName();
    }

}
