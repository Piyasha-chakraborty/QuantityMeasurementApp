import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    void testEquality_YardToYard_SameValue() {

        QuantityMeasurementApp.QuantityLength q1 =
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.YARDS
                );

        QuantityMeasurementApp.QuantityLength q2 =
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.YARDS
                );

        assertEquals(q1, q2);
    }

    @Test
    void testEquality_YardToYard_DifferentValue() {

        QuantityMeasurementApp.QuantityLength q1 =
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.YARDS
                );

        QuantityMeasurementApp.QuantityLength q2 =
                new QuantityMeasurementApp.QuantityLength(
                        2.0,
                        QuantityMeasurementApp.LengthUnit.YARDS
                );

        assertNotEquals(q1, q2);
    }

    @Test
    void testEquality_YardToFeet_EquivalentValue() {

        QuantityMeasurementApp.QuantityLength yard =
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.YARDS
                );

        QuantityMeasurementApp.QuantityLength feet =
                new QuantityMeasurementApp.QuantityLength(
                        3.0,
                        QuantityMeasurementApp.LengthUnit.FEET
                );

        assertEquals(yard, feet);
    }

    @Test
    void testEquality_FeetToYard_EquivalentValue() {

        QuantityMeasurementApp.QuantityLength feet =
                new QuantityMeasurementApp.QuantityLength(
                        3.0,
                        QuantityMeasurementApp.LengthUnit.FEET
                );

        QuantityMeasurementApp.QuantityLength yard =
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.YARDS
                );

        assertEquals(feet, yard);
    }

    @Test
    void testEquality_YardToInches_EquivalentValue() {

        QuantityMeasurementApp.QuantityLength yard =
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.YARDS
                );

        QuantityMeasurementApp.QuantityLength inch =
                new QuantityMeasurementApp.QuantityLength(
                        36.0,
                        QuantityMeasurementApp.LengthUnit.INCH
                );

        assertEquals(yard, inch);
    }

    @Test
    void testEquality_CentimetersToInches_EquivalentValue() {

        QuantityMeasurementApp.QuantityLength cm =
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.CENTIMETERS
                );

        QuantityMeasurementApp.QuantityLength inch =
                new QuantityMeasurementApp.QuantityLength(
                        0.393701,
                        QuantityMeasurementApp.LengthUnit.INCH
                );

        assertEquals(cm, inch);
    }

    @Test
    void testEquality_CentimetersToFeet_NonEquivalentValue() {

        QuantityMeasurementApp.QuantityLength cm =
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.CENTIMETERS
                );

        QuantityMeasurementApp.QuantityLength feet =
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.FEET
                );

        assertNotEquals(cm, feet);
    }

    @Test
    void testEquality_MultiUnit_TransitiveProperty() {

        QuantityMeasurementApp.QuantityLength yard =
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.YARDS
                );

        QuantityMeasurementApp.QuantityLength feet =
                new QuantityMeasurementApp.QuantityLength(
                        3.0,
                        QuantityMeasurementApp.LengthUnit.FEET
                );

        QuantityMeasurementApp.QuantityLength inch =
                new QuantityMeasurementApp.QuantityLength(
                        36.0,
                        QuantityMeasurementApp.LengthUnit.INCH
                );

        assertEquals(yard, feet);
        assertEquals(feet, inch);
        assertEquals(yard, inch);
    }

    @Test
    void testEquality_SameReference() {

        QuantityMeasurementApp.QuantityLength yard =
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.YARDS
                );

        assertEquals(yard, yard);
    }

    @Test
    void testEquality_NullComparison() {

        QuantityMeasurementApp.QuantityLength yard =
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.YARDS
                );

        assertNotEquals(null, yard);
    }
}