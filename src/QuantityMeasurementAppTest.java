import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    void testConvert_FeetToInches() {

        double result =
                QuantityMeasurementApp.QuantityLength.convert(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.FEET,
                        QuantityMeasurementApp.LengthUnit.INCH
                );

        assertEquals(12.0, result);
    }

    @Test
    void testConvert_YardsToInches() {

        double result =
                QuantityMeasurementApp.QuantityLength.convert(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.YARDS,
                        QuantityMeasurementApp.LengthUnit.INCH
                );

        assertEquals(36.0, result);
    }

    @Test
    void testConvert_CentimetersToFeet() {

        double result =
                QuantityMeasurementApp.QuantityLength.convert(
                        30.48,
                        QuantityMeasurementApp.LengthUnit.CENTIMETERS,
                        QuantityMeasurementApp.LengthUnit.FEET
                );

        assertEquals(1.0, result, 0.01);
    }

    @Test
    void testConvert_FeetToYards() {

        double result =
                QuantityMeasurementApp.QuantityLength.convert(
                        3.0,
                        QuantityMeasurementApp.LengthUnit.FEET,
                        QuantityMeasurementApp.LengthUnit.YARDS
                );

        assertEquals(1.0, result);
    }

    @Test
    void testConvert_InchesToFeet() {

        double result =
                QuantityMeasurementApp.QuantityLength.convert(
                        12.0,
                        QuantityMeasurementApp.LengthUnit.INCH,
                        QuantityMeasurementApp.LengthUnit.FEET
                );

        assertEquals(1.0, result);
    }

    @Test
    void testConvert_InvalidValue() {

        assertThrows(
                IllegalArgumentException.class,
                () -> QuantityMeasurementApp.QuantityLength.convert(
                        Double.POSITIVE_INFINITY,
                        QuantityMeasurementApp.LengthUnit.FEET,
                        QuantityMeasurementApp.LengthUnit.INCH
                )
        );
    }

    @Test
    void testConvert_NullSourceUnit() {

        assertThrows(
                IllegalArgumentException.class,
                () -> QuantityMeasurementApp.QuantityLength.convert(
                        1.0,
                        null,
                        QuantityMeasurementApp.LengthUnit.INCH
                )
        );
    }

    @Test
    void testConvert_NullTargetUnit() {

        assertThrows(
                IllegalArgumentException.class,
                () -> QuantityMeasurementApp.QuantityLength.convert(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.FEET,
                        null
                )
        );
    }

    @Test
    void testEquality_FeetAndInches() {

        QuantityMeasurementApp.QuantityLength feet =
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.FEET
                );

        QuantityMeasurementApp.QuantityLength inches =
                new QuantityMeasurementApp.QuantityLength(
                        12.0,
                        QuantityMeasurementApp.LengthUnit.INCH
                );

        assertEquals(feet, inches);
    }

    @Test
    void testEquality_YardsAndFeet() {

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
}