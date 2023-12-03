package com.myresume.api.vacancy.enum_;

import com.myresume.api.vacancy.mapper.Describable;

import java.util.Arrays;

public enum CompanyType implements Describable {
    PRODUCT("product"),
    OUTSOURCE("outsource"),
    OUTSTAFF("outstaff");


    public final String description;

    CompanyType(String description) {
        this.description = description;
    }

    public static CompanyType findByDescription(String description) {
        return Arrays.stream(CompanyType.values())
                .filter(level -> level.description.equalsIgnoreCase(description))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String getDescription() {
        return description;
    }
}