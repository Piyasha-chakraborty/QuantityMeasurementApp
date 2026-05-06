import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    // ---------------- SUBTRACTION TESTS ----------------

    @Test
    void shouldSubtractVolumesCorrectly() {

        Quantity<VolumeUnit> litre =
                new Quantity<>(
                        5,
                        VolumeUnit.LITRE);

        Quantity<VolumeUnit> ml =
                new Quantity<>(
                        2000,
                        VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result =
                litre.subtract(ml);

        Quantity<VolumeUnit> expected =
                new Quantity<>(
                        3,
                        VolumeUnit.LITRE);

        assertEquals(expected, result);
    }

    @Test
    void shouldSubtractLengthsCorrectly() {

        Quantity<LengthUnit> feet =
                new Quantity<>(
                        10,
                        LengthUnit.FEET);

        Quantity<LengthUnit> inch =
                new Quantity<>(
                        6,
                        LengthUnit.INCH);

        Quantity<LengthUnit> result =
                feet.subtract(inch);

        Quantity<LengthUnit> expected =
                new Quantity<>(
                        9.5,
                        LengthUnit.FEET);

        assertEquals(expected, result);
    }

    // ---------------- DIVISION TESTS ----------------

    @Test
    void shouldDivideWeightsCorrectly() {

        Quantity<WeightUnit> kg1 =
                new Quantity<>(
                        10,
                        WeightUnit.KILOGRAM);

        Quantity<WeightUnit> kg2 =
                new Quantity<>(
                        5,
                        WeightUnit.KILOGRAM);

        double result =
                kg1.divide(kg2);

        assertEquals(2.0, result);
    }

    @Test
    void shouldReturnOneForEqualQuantities() {

        Quantity<VolumeUnit> litre =
                new Quantity<>(
                        1,
                        VolumeUnit.LITRE);

        Quantity<VolumeUnit> ml =
                new Quantity<>(
                        1000,
                        VolumeUnit.MILLILITRE);

        double result =
                litre.divide(ml);

        assertEquals(1.0, result);
    }

    @Test
    void shouldThrowExceptionForDivideByZero() {

        Quantity<WeightUnit> kg =
                new Quantity<>(
                        10,
                        WeightUnit.KILOGRAM);

        Quantity<WeightUnit> zero =
                new Quantity<>(
                        0,
                        WeightUnit.KILOGRAM);

        assertThrows(
                ArithmeticException.class,
                () -> kg.divide(zero));
    }

    // ---------------- TYPE SAFETY ----------------

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
}