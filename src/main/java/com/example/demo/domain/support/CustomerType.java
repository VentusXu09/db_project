package com.example.demo.domain.support;


public enum CustomerType {
    INDIVIDUAL("I"),
    CORPORATION("C");

    private String displayName;

    CustomerType(String displayName) {
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
