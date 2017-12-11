package com.jora.toyrobot;


import com.jora.toyrobot.models.Coordinate;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class FiveUnitsTableTopTest {
    @Test
    public void shouldReturnFalseIfNotInsideTableBorder() {
        FiveUnitsTableTop fiveUnitsTableTop = new FiveUnitsTableTop();
        assertFalse(fiveUnitsTableTop.insideTableBorder(new Coordinate(5, 1)));
    }

    @Test
    public void shouldReturnTrueIfInsideTableBorder() {
        FiveUnitsTableTop fiveUnitsTableTop = new FiveUnitsTableTop();
        assertTrue(fiveUnitsTableTop.insideTableBorder(new Coordinate(0, 0)));
    }
}
