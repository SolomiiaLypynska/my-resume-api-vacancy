package com.myresume.api.vacancy.enum_;

import com.myresume.api.vacancy.mapper.Describable;

import java.util.Arrays;

public enum PositionLevel implements Describable {
    TRAINEE("trainee"),
    JUNIOR("junior"),
    MIDDLE("middle"),
    SENIOR("senior"),
    LEAD("lead");


    public final String description;

    PositionLevel(String description) {
        this.description = description;
    }

    public static PositionLevel findByDescription(String description) {
        return Arrays.stream(PositionLevel.values())
                .filter(level -> level.description.equalsIgnoreCase(description))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String getDescription() {
        return description;
    }
}