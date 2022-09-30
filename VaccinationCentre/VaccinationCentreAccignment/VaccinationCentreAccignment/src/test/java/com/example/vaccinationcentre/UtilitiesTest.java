package com.example.vaccinationcentre;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UtilitiesTest {

    @Test
    void max15Chars() {
        assertTrue(Utilities.max15Chars("123456789012345"));  //normal
        assertFalse(Utilities.max15Chars("123456789012345678"));  //abnormal
        assertTrue(Utilities.max15Chars(""));  //normal but unusual
    }

    @Test
    void max30Chars() {
        assertTrue(Utilities.max30Chars("123456789012345678901234567890"));  //normal
        assertFalse(Utilities.max30Chars("123456789012345678901234567890-123"));  //abnormal
        assertTrue(Utilities.max30Chars(""));  //normal but unusual
    }

    @Test
    void max60Chars() {
        assertTrue(Utilities.max60Chars("123456789012345678901234567890123456789012345678901234567890"));  //normal
        assertFalse(Utilities.max60Chars("123456789012345678901234567890-123123456789012345678901234567890"));  //abnormal
        assertTrue(Utilities.max60Chars(""));  //normal but unusual
    }

    @Test
    void validEircode() {
        assertTrue(Utilities.validEircode("x91adt3"));  //normal
        assertFalse(Utilities.validEircode("x91adt3f"));  //abnormal
        assertFalse(Utilities.validEircode("x91ad"));  //abnormal
        assertFalse(Utilities.validEircode(""));  //abnormal
    }

    @Test
    void validPPS() {
        assertTrue(Utilities.validPPS(("1234567A"))); // normal
        assertTrue(Utilities.validPPS(("1234567AB"))); //normal
        assertFalse(Utilities.validPPS(("1234567a")));
        assertFalse(Utilities.validPPS(("1234567ab")));
        assertFalse(Utilities.validPPS(("1234567ab1")));
        assertFalse(Utilities.validPPS(("a234567ab")));
        assertFalse(Utilities.validPPS(("1a34567ab")));
        assertFalse(Utilities.validPPS(("12a4567ab")));
        assertFalse(Utilities.validPPS(("123a567ab")));
        assertFalse(Utilities.validPPS(("1234a67ab")));
        assertFalse(Utilities.validPPS(("12345a7ab")));
        assertFalse(Utilities.validPPS(("123456aab")));
        assertFalse(Utilities.validPPS(("12345671b")));
        assertFalse(Utilities.validPPS(("1234567a1")));
    }

    @Test
    void onlyContainsNumbers() {
        assertTrue(Utilities.onlyContainsNumbers(("1234567890")));    // normal
        assertFalse(Utilities.onlyContainsNumbers(("1234567AB")));    // checking different incorrect positions
        assertFalse(Utilities.onlyContainsNumbers(("1234567ab1")));
        assertFalse(Utilities.onlyContainsNumbers(("a234567ab")));
        assertFalse(Utilities.onlyContainsNumbers((""))); //normal but unusual

    }

    @Test
    void validBoothId() {
        assertTrue(Utilities.validBoothId(("A1"))); // normal
        assertFalse(Utilities.validBoothId(("a1")));
        assertFalse(Utilities.validBoothId(("1A")));
        assertFalse(Utilities.validBoothId(("1a")));
        assertFalse(Utilities.validBoothId(("A12")));
        assertFalse(Utilities.validBoothId(("AB1")));
        assertFalse(Utilities.validBoothId(("12")));
        assertFalse(Utilities.validBoothId(("AB")));

    }

    @Test
    void VCId() {
        assertTrue(Utilities.VCId(("A12"))); // normal
        assertFalse(Utilities.VCId(("a1")));
        assertFalse(Utilities.VCId(("1A")));
        assertFalse(Utilities.VCId(("1a")));
        assertFalse(Utilities.VCId(("AB1")));
        assertFalse(Utilities.VCId(("12")));
        assertFalse(Utilities.VCId(("AB")));
    }
}