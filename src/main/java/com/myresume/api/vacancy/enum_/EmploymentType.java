package com.myresume.api.vacancy.enum_;

import com.myresume.api.vacancy.mapper.Describable;

import java.util.Arrays;

public enum EmploymentType implements Describable {
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

    @Override
    public String getDescription() {
        return description;
    }
}
