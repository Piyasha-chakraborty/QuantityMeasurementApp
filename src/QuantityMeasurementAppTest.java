
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    void shouldReturnTrueForFeetAndInch() {

        QuantityMeasurementApp feet =
                new QuantityMeasurementApp(
                        1,
                        QuantityMeasurementApp.LengthUnit.FEET);

        QuantityMeasurementApp inch =
                new QuantityMeasurementApp(
                        12,
                        QuantityMeasurementApp.LengthUnit.INCH);

        assertEquals(feet, inch);
    }

    @Test
    void shouldReturnTrueForFeetAndYard() {

        QuantityMeasurementApp feet =
                new QuantityMeasurementApp(
                        3,
                        QuantityMeasurementApp.LengthUnit.FEET);

        QuantityMeasurementApp yard =
                new QuantityMeasurementApp(
                        1,
                        QuantityMeasurementApp.LengthUnit.YARD);

        assertEquals(feet, yard);
    }

    @Test
    void shouldReturnTrueForFeetAndCentimeter() {

        QuantityMeasurementApp feet =
                new QuantityMeasurementApp(
                        1,
                        QuantityMeasurementApp.LengthUnit.FEET);

        QuantityMeasurementApp cm =
                new QuantityMeasurementApp(
                        30.48,
                        QuantityMeasurementApp.LengthUnit.CENTIMETER);

        assertEquals(feet, cm);
    }

    @Test
    void shouldAddLengthsCorrectly() {

        QuantityMeasurementApp feet =
                new QuantityMeasurementApp(
                        1,
                        QuantityMeasurementApp.LengthUnit.FEET);

        QuantityMeasurementApp inch =
                new QuantityMeasurementApp(
                        12,
                        QuantityMeasurementApp.LengthUnit.INCH);

        QuantityMeasurementApp result =
                feet.add(inch);

        QuantityMeasurementApp expected =
                new QuantityMeasurementApp(
                        2,
                        QuantityMeasurementApp.LengthUnit.FEET);

        assertEquals(expected, result);
    }
}