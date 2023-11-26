package com.myresume.api.vacancy.enum_;

import java.util.Arrays;

public enum EmploymentType {
    FULL_TIME("full-time"),
    PART_TIME("part-time"),
    SELF_EMPLOYED("self-employed"),
    FREELANCE("freelance"),
    CONTRACT("contract");

    public final String value;

    EmploymentType(String value) {
        this.value = value;
    }

    public static EmploymentType findByValue(String stringValue) {
        return Arrays.stream(EmploymentType.values())
                .filter(level -> level.value.equalsIgnoreCase(stringValue))
                .findFirst()
                .orElse(null);
    }
}
