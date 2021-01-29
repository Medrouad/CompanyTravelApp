package com.enums;

public enum Zone {
    ZONE_ONE(1), ZONE_TWO(2), ZONE_TREE(3), ZONE_FOUR(4);

    public int value;

    Zone(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }


}
