import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    // ---------------- LENGTH TESTS ----------------

    @Test
    void shouldReturnTrueForFeetAndInch() {

        Quantity<LengthUnit> feet =
                new Quantity<>(
                        1,
                        LengthUnit.FEET);

        Quantity<LengthUnit> inch =
                new Quantity<>(
                        12,
                        LengthUnit.INCH);

        assertEquals(feet, inch);
    }

    @Test
    void shouldAddLengthsCorrectly() {

        Quantity<LengthUnit> feet =
                new Quantity<>(
                        1,
                        LengthUnit.FEET);

        Quantity<LengthUnit> inch =
                new Quantity<>(
                        12,
                        LengthUnit.INCH);

        Quantity<LengthUnit> result =
                feet.add(inch);

        Quantity<LengthUnit> expected =
                new Quantity<>(
                        2,
                        LengthUnit.FEET);

        assertEquals(expected, result);
    }

    // ---------------- WEIGHT TESTS ----------------

    @Test
    void shouldReturnTrueForKilogramAndGram() {

        Quantity<WeightUnit> kg =
                new Quantity<>(
                        1,
                        WeightUnit.KILOGRAM);

        Quantity<WeightUnit> gram =
                new Quantity<>(
                        1000,
                        WeightUnit.GRAM);

        assertEquals(kg, gram);
    }

    @Test
    void shouldAddWeightsCorrectly() {

        Quantity<WeightUnit> kg =
                new Quantity<>(
                        1,
                        WeightUnit.KILOGRAM);

        Quantity<WeightUnit> gram =
                new Quantity<>(
                        1000,
                        WeightUnit.GRAM);

        Quantity<WeightUnit> result =
                kg.add(gram);

        Quantity<WeightUnit> expected =
                new Quantity<>(
                        2,
                        WeightUnit.KILOGRAM);

        assertEquals(expected, result);
    }

    // ---------------- TYPE SAFETY TEST ----------------

    @Test
    void shouldReturnFalseForLengthAndWeight() {

        Quantity<LengthUnit> feet =
                new Quantity<>(
                        1,
                        LengthUnit.FEET);

        Quantity<WeightUnit> kg =
                new Quantity<>(
                        1,
                        WeightUnit.KILOGRAM);

        assertNotEquals(feet, kg);
    }

    // ---------------- CONVERSION TEST ----------------

    @Test
    void shouldConvertFeetToInch() {

        Quantity<LengthUnit> feet =
                new Quantity<>(
                        1,
                        LengthUnit.FEET);

        Quantity<LengthUnit> inch =
                feet.convertTo(
                        LengthUnit.INCH);

        Quantity<LengthUnit> expected =
                new Quantity<>(
                        12,
                        LengthUnit.INCH);

        assertEquals(expected, inch);
    }
}