import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    // ---------------- LENGTH TESTS ----------------

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

    // ---------------- WEIGHT TESTS ----------------

    @Test
    void shouldReturnTrueForKilogramAndGram() {

        QuantityMeasurementApp kg =
                new QuantityMeasurementApp(
                        1,
                        QuantityMeasurementApp.WeightUnit.KILOGRAM);

        QuantityMeasurementApp gram =
                new QuantityMeasurementApp(
                        1000,
                        QuantityMeasurementApp.WeightUnit.GRAM);

        assertEquals(kg, gram);
    }

    @Test
    void shouldReturnTrueForKilogramAndPound() {

        QuantityMeasurementApp kg =
                new QuantityMeasurementApp(
                        1,
                        QuantityMeasurementApp.WeightUnit.KILOGRAM);

        QuantityMeasurementApp pound =
                new QuantityMeasurementApp(
                        2.20462,
                        QuantityMeasurementApp.WeightUnit.POUND);

        assertEquals(
                kg.toBaseWeightUnit(),
                pound.toBaseWeightUnit(),
                0.01);
    }

    @Test
    void shouldAddWeightsCorrectly() {

        QuantityMeasurementApp kg =
                new QuantityMeasurementApp(
                        1,
                        QuantityMeasurementApp.WeightUnit.KILOGRAM);

        QuantityMeasurementApp gram =
                new QuantityMeasurementApp(
                        1000,
                        QuantityMeasurementApp.WeightUnit.GRAM);

        QuantityMeasurementApp result =
                kg.addWeight(gram);

        QuantityMeasurementApp expected =
                new QuantityMeasurementApp(
                        2,
                        QuantityMeasurementApp.WeightUnit.KILOGRAM);

        assertEquals(expected, result);
    }

    @Test
    void shouldReturnFalseForLengthAndWeight() {

        QuantityMeasurementApp feet =
                new QuantityMeasurementApp(
                        1,
                        QuantityMeasurementApp.LengthUnit.FEET);

        QuantityMeasurementApp kg =
                new QuantityMeasurementApp(
                        1,
                        QuantityMeasurementApp.WeightUnit.KILOGRAM);

        assertNotEquals(feet, kg);
    }
}