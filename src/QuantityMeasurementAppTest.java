import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    void testEquality_SameValue() {

        QuantityMeasurementApp.Feet feet1 =
                new QuantityMeasurementApp.Feet(1.0);

        QuantityMeasurementApp.Feet feet2 =
                new QuantityMeasurementApp.Feet(1.0);

        assertEquals(feet1, feet2);
    }

    @Test
    void testEquality_DifferentValue() {

        QuantityMeasurementApp.Feet feet1 =
                new QuantityMeasurementApp.Feet(1.0);

        QuantityMeasurementApp.Feet feet2 =
                new QuantityMeasurementApp.Feet(2.0);

        assertNotEquals(feet1, feet2);
    }

    @Test
    void testEquality_NullComparison() {

        QuantityMeasurementApp.Feet feet =
                new QuantityMeasurementApp.Feet(1.0);

        assertNotEquals(null, feet);
    }

    @Test
    void testEquality_NonNumericInput() {

        QuantityMeasurementApp.Feet feet =
                new QuantityMeasurementApp.Feet(1.0);

        String value = "abc";

        assertNotEquals(feet, value);
    }

    @Test
    void testEquality_SameReference() {

        QuantityMeasurementApp.Feet feet =
                new QuantityMeasurementApp.Feet(1.0);

        assertEquals(feet, feet);
    }
}