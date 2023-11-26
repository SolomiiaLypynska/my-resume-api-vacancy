package com.myresume.api.vacancy.enum_;

import java.util.Arrays;

public enum EnglishLevel {
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
}