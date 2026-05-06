import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    void testAddition_FeetAndInches() {

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
                feet.add(inches);

        assertEquals(
                2.0,
                result.getValue()
        );

        assertEquals(
                QuantityMeasurementApp.LengthUnit.FEET,
                result.getUnit()
        );
    }

    @Test
    void testAddition_YardsAndFeet() {

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
                yards.add(feet);

        assertEquals(
                2.0,
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
                cm.add(inch);

        assertEquals(
                5.08,
                result.getValue(),
                0.01
        );
    }

    @Test
    void testAddition_SameUnit() {

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
                feet1.add(feet2);

        assertEquals(
                5.0,
                result.getValue()
        );
    }

    @Test
    void testAddition_NullObject() {

        QuantityMeasurementApp.QuantityLength feet =
                new QuantityMeasurementApp.QuantityLength(
                        1.0,
                        QuantityMeasurementApp.LengthUnit.FEET
                );

        assertThrows(
                IllegalArgumentException.class,
                () -> feet.add(null)
        );
    }

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