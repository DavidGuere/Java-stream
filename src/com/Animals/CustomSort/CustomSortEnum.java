package com.Animals.CustomSort;

public enum CustomSortEnum {

    TYPE("type"),
    NAME("name"),
    BIRTH_YEAR("birth"),
    SWIMMER("swim");


    private final String specialSort;

    CustomSortEnum(String specialSort) {
        this.specialSort = specialSort;
    }

    public String getSpecialSort() {
        return specialSort;
    }
}
