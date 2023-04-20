package net.doulrion.toxicsteam.util;

public enum HealingItemValue {
    WEAK(1), MEDIUM(2), STRONG(3);
    private final int value;

    private HealingItemValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}