package com.myresume.api.vacancy.enum_;

import java.util.Arrays;

public enum EnglishLevel {
    NO_ENGLISH("noEnglish"),
    BEGINNER_ELEMENTARY("beginnerOrElementary"),
    PRE_INTERMEDIATE("preIntermediate"),
    INTERMEDIATE("intermediate"),
    UPPER_INTERMEDIATE("upperIntermediate"),
    ADVANCED_FLUENT("advancedOrFluent");


    public final String value;

    EnglishLevel(String value) {
        this.value = value;
    }

    public static EnglishLevel findByValue(String stringValue) {
        return Arrays.stream(EnglishLevel.values())
                .filter(level -> level.value.equalsIgnoreCase(stringValue))
                .findFirst()
                .orElse(null);
    }
}