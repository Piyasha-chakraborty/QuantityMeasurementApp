import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    void testFeetEquality_SameValue() {

        assertTrue(
                QuantityMeasurementApp.checkFeetEquality(1.0, 1.0)
        );
    }

    @Test
    void testFeetEquality_DifferentValue() {

        assertFalse(
                QuantityMeasurementApp.checkFeetEquality(1.0, 2.0)
        );
    }

    @Test
    void testInchesEquality_SameValue() {

        assertTrue(
                QuantityMeasurementApp.checkInchesEquality(1.0, 1.0)
        );
    }

    @Test
    void testInchesEquality_DifferentValue() {

        assertFalse(
                QuantityMeasurementApp.checkInchesEquality(1.0, 2.0)
        );
    }

    @Test
    void testFeetEquality_NullComparison() {

        QuantityMeasurementApp.Feet feet =
                new QuantityMeasurementApp.Feet(1.0);

        assertNotEquals(null, feet);
    }

    @Test
    void testInchesEquality_NullComparison() {

        QuantityMeasurementApp.Inches inches =
                new QuantityMeasurementApp.Inches(1.0);

        assertNotEquals(null, inches);
    }

    @Test
    void testFeetEquality_SameReference() {

        QuantityMeasurementApp.Feet feet =
                new QuantityMeasurementApp.Feet(1.0);

        assertEquals(feet, feet);
    }

    @Test
    void testInchesEquality_SameReference() {

        QuantityMeasurementApp.Inches inches =
                new QuantityMeasurementApp.Inches(1.0);

        assertEquals(inches, inches);
    }
}