import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    void testAddition_FeetAndInches_ToYards() {

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

        QuantityMeasurementApp.QuantityLength result =
                feet.add(
                        inches,
                        QuantityMeasurementApp.LengthUnit.YARDS
                );

        assertEquals(
                0.666,
                result.getValue(),
                0.01
        );

        assertEquals(
                QuantityMeasurementApp.LengthUnit.YARDS,
                result.getUnit()
        );
    }

    @Test
    void testAddition_FeetAndFeet_ToFeet() {

        QuantityMeasurementApp.QuantityLength feet1 =
                new QuantityMeasurementApp.QuantityLength(
                        2.0,
                        QuantityMeasurementApp.LengthUnit.FEET
                );

        QuantityMeasurementApp.QuantityLength feet2 =
                new QuantityMeasurementApp.QuantityLength(
                        3.0,
                        QuantityMeasurementApp.LengthUnit.FEET
                );

        QuantityMeasurementApp.QuantityLength result =
                feet1.add(
                        feet2,
                        QuantityMeasurementApp.LengthUnit.FEET
                );

        assertEquals(
                5.0,
                result.getValue()
        );
    }

    @Test
    void testAddition_YardsAndFeet_ToInches() {

        QuantityMeasurementApp.QuantityLength yards =
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.YARDS
                );

        QuantityMeasurementApp.QuantityLength feet =
                new QuantityMeasurementApp.QuantityLength(
                        3.0,
                        QuantityMeasurementApp.LengthUnit.FEET
                );

        QuantityMeasurementApp.QuantityLength result =
                yards.add(
                        feet,
                        QuantityMeasurementApp.LengthUnit.INCH
                );

        assertEquals(
                72.0,
                result.getValue()
        );
    }

    @Test
    void testAddition_CentimetersAndInches() {

        QuantityMeasurementApp.QuantityLength cm =
                new QuantityMeasurementApp.QuantityLength(
                        2.54,
                        QuantityMeasurementApp.LengthUnit.CENTIMETERS
                );

        QuantityMeasurementApp.QuantityLength inch =
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.INCH
                );

        QuantityMeasurementApp.QuantityLength result =
                cm.add(
                        inch,
                        QuantityMeasurementApp.LengthUnit.INCH
                );

        assertEquals(
                2.0,
                result.getValue(),
                0.01
        );
    }

    @Test
    void testAddition_NullQuantity() {

        QuantityMeasurementApp.QuantityLength feet =
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.FEET
                );

        assertThrows(
                IllegalArgumentException.class,
                () -> feet.add(
                        null,
                        QuantityMeasurementApp.LengthUnit.FEET
                )
        );
    }

    @Test
    void testAddition_NullTargetUnit() {

        QuantityMeasurementApp.QuantityLength feet =
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.FEET
                );

        QuantityMeasurementApp.QuantityLength inch =
                new QuantityMeasurementApp.QuantityLength(
                        12.0,
                        QuantityMeasurementApp.LengthUnit.INCH
                );

        assertThrows(
                IllegalArgumentException.class,
                () -> feet.add(inch, null)
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
}