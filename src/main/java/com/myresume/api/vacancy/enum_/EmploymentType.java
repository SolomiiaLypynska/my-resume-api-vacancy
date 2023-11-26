package com.myresume.api.vacancy.enum_;

import java.util.Arrays;

public enum EmploymentType {
    FULL_TIME("full-time"),
    PART_TIME("part-time"),
    SELF_EMPLOYED("self-employed"),
    FREELANCE("freelance"),
    CONTRACT("contract");

    public final String description;

    EmploymentType(String description) {
        this.description = description;
    }

    public static EmploymentType findByDescription(String description) {
        return Arrays.stream(EmploymentType.values())
                .filter(level -> level.description.equalsIgnoreCase(description))
                .findFirst()
                .orElse(null);
    }
}
