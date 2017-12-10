package com.jora.toyrobot;


import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

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
