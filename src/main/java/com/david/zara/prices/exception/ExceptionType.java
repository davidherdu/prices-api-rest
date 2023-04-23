package com.david.zara.prices.exception;

public enum ExceptionType {
    ENTITY_NOT_FOUND("not.found");

    String value;

    ExceptionType(String value) {
        this.value = value;
    }

    String getValue() {
        return this.value;
    }
}
