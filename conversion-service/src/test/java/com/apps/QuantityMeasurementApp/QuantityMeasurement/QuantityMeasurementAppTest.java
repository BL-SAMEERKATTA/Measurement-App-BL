package com.apps.QuantityMeasurementApp.QuantityMeasurement;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.apps.QuantityMeasurement.Length;
import com.apps.QuantityMeasurement.Weight;
import com.apps.QuantityMeasurement.Length.LengthUnit;
import com.apps.QuantityMeasurement.Weight.WeightUnit;

public class QuantityMeasurementAppTest {

    private static final double EPSILON = 0.0001;

    @Test
    public void testFeetEquality() {
        Length a = new Length(1.0, LengthUnit.FEET);
        Length b = new Length(1.0, LengthUnit.FEET);
        assertTrue(a.equals(b));
    }

    @Test
    public void testInchesEquality() {
        Length a = new Length(12.0, LengthUnit.INCHES);
        Length b = new Length(12.0, LengthUnit.INCHES);
        assertTrue(a.equals(b));
    }

    @Test
    public void testFeetInchesComparison() {
        Length feet = new Length(1.0, LengthUnit.FEET);
        Length inches = new Length(12.0, LengthUnit.INCHES);
        assertTrue(feet.equals(inches));
    }

    @Test
    public void testFeetInequality() {
        Length a = new Length(1.0, LengthUnit.FEET);
        Length b = new Length(2.0, LengthUnit.FEET);
        assertFalse(a.equals(b));
    }

    @Test
    public void testInchesInequality() {
        Length a = new Length(10.0, LengthUnit.INCHES);
        Length b = new Length(12.0, LengthUnit.INCHES);
        assertFalse(a.equals(b));
    }

    @Test
    public void testCrossUnitInequality() {
        Length feet = new Length(1.0, LengthUnit.FEET);
        Length inches = new Length(10.0, LengthUnit.INCHES);
        assertFalse(feet.equals(inches));
    }

    @Test
    public void yardEquals36Inches() {
        Length yard = new Length(1.0, LengthUnit.YARDS);
        Length inches = new Length(36.0, LengthUnit.INCHES);
        assertTrue(yard.equals(inches));
    }

    @Test
    public void threeFeetEqualsOneYard() {
        Length feet = new Length(3.0, LengthUnit.FEET);
        Length yard = new Length(1.0, LengthUnit.YARDS);
        assertTrue(feet.equals(yard));
    }

    @Test
    public void convertFeetToInches() {
        double result = Length.convert(1.0, LengthUnit.FEET, LengthUnit.INCHES);
        assertEquals(12.0, result, EPSILON);
    }

    @Test
    public void addFeetAndInches() {
        Length feet = new Length(1.0, LengthUnit.FEET);
        Length inches = new Length(12.0, LengthUnit.INCHES);
        Length result = feet.add(inches);
        assertEquals(2.0, result.getValue(), EPSILON);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    void testEquality_KilogramToKilogram_SameValue() {
        Weight a = new Weight(1, WeightUnit.KILOGRAM);
        Weight b = new Weight(1, WeightUnit.KILOGRAM);
        assertTrue(a.equals(b));
    }

    @Test
    void testEquality_KilogramToGram_EquivalentValue() {
        Weight kg = new Weight(1, WeightUnit.KILOGRAM);
        Weight g = new Weight(1000, WeightUnit.GRAM);
        assertTrue(kg.equals(g));
    }

    @Test
    void testConversion_KilogramToGram() {
        Weight kg = new Weight(1, WeightUnit.KILOGRAM);
        Weight result = kg.convertTo(WeightUnit.GRAM);
        assertEquals(1000, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_SameUnit_KilogramPlusKilogram() {
        Weight a = new Weight(1, WeightUnit.KILOGRAM);
        Weight b = new Weight(2, WeightUnit.KILOGRAM);
        Weight result = a.add(b);
        assertEquals(3, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_CrossUnit_KilogramPlusGram() {
        Weight kg = new Weight(1, WeightUnit.KILOGRAM);
        Weight g = new Weight(1000, WeightUnit.GRAM);
        Weight result = kg.add(g);
        assertEquals(2, result.getValue(), EPSILON);
    }
}
