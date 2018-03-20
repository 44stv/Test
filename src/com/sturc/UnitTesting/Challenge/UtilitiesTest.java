package com.sturc.UnitTesting.Challenge;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UtilitiesTest {

    private Utilities utilities;

    @Before
    public void setUp() throws Exception {
        utilities = new Utilities();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void everyNthChar() {
        char[] array = {'h','e', 'l', 'l', 'o'};
        assertArrayEquals(new char[] {'e', 'l'}, utilities.everyNthChar(array, 2));
        assertArrayEquals(new char[] {'h', 'e', 'l', 'l', 'o'}, utilities.everyNthChar(array, 8));
    }

    @Test
    public void removePairs() {
        String source1 = "AABCDDEFF";
        String source2 = "ABCCABDEEF";
        String source3 = "A";
        String source4 = null;

        String result1 = utilities.removePairs(source1);
        assertEquals("ABCDEF", result1);
        String result2 = utilities.removePairs(source2);
        assertEquals("ABCABDEF", result2);
        String result3 = utilities.removePairs(source3);
        assertEquals("A", result3);
        String result4 = utilities.removePairs(source4);
        assertNull(result4);
    }

    @Test
    public void converter() {
        assertEquals(300, utilities.converter(10, 5));
    }

    @Test (expected = ArithmeticException.class)
    public void converter_ArithmeticException() {
        utilities.converter(10, 0);
    }

    @Test
    public void nullIfOddLength() {
        String test1 = "even";
        String test2 = "odd";
        assertNotNull(utilities.nullIfOddLength(test1));
        assertNull(utilities.nullIfOddLength(test2));
    }
}