package com.myresume.api.vacancy.enum_;

import com.myresume.api.vacancy.mapper.Describable;

import java.util.Arrays;

public enum EnglishLevel implements Describable {
    NO_ENGLISH("noEnglish"),
    BEGINNER_ELEMENTARY("beginnerOrElementary"),
    PRE_INTERMEDIATE("preIntermediate"),
    INTERMEDIATE("intermediate"),
    UPPER_INTERMEDIATE("upperIntermediate"),
    ADVANCED_FLUENT("advancedOrFluent");


    public final String description;

    EnglishLevel(String description) {
        this.description = description;
    }

    public static EnglishLevel findByDescription(String description) {
        return Arrays.stream(EnglishLevel.values())
                .filter(level -> level.description.equalsIgnoreCase(description))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String getDescription() {
        return description;
    }
}