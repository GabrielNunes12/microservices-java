package com.rocketseat.service.tasks.Enums;

public enum NotifiedEnum {
    NOTIFIED("NOTIFIED", 1),
    NOT_NOTIFIED("NOT_NOTIFIED", 0);
    private final String code;
    private final int value;
    NotifiedEnum(String code, int value) {
        this.code = code;
        this.value = value;
    }
}
