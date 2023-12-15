package com.myresume.api.vacancy.enum_;

import com.myresume.api.vacancy.mapper.Describable;

import java.util.Arrays;

public enum Location implements Describable {
    OFFICE("office"),
    REMOTE("remote");

    public final String description;

    Location(String description) {
        this.description = description;
    }

    public static Location findByDescription(String description) {
        return Arrays.stream(Location.values())
                .filter(level -> level.description.equalsIgnoreCase(description))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String getDescription() {
        return description;
    }
}
