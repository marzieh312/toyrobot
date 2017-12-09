package com.jora.toyrobot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FiveUnitsTableTopTest {
    @Test
    void shouldReturnFalseIfNotInsideTableBorder() {
        FiveUnitsTableTop fiveUnitsTableTop = new FiveUnitsTableTop();
        assertFalse(fiveUnitsTableTop.insideTableBorder(new Coordinate(5, 1)));
    }

    @Test
    void shouldReturnTrueIfInsideTableBorder() {
        FiveUnitsTableTop fiveUnitsTableTop = new FiveUnitsTableTop();
        assertTrue(fiveUnitsTableTop.insideTableBorder(new Coordinate(0, 0)));
    }
}
