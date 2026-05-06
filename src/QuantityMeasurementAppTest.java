import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    // ---------------- LENGTH TEST ----------------

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

    // ---------------- WEIGHT TEST ----------------

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

    // ---------------- VOLUME TESTS ----------------

    @Test
    void shouldReturnTrueForLitreAndMillilitre() {

        Quantity<VolumeUnit> litre =
                new Quantity<>(
                        1,
                        VolumeUnit.LITRE);

        Quantity<VolumeUnit> ml =
                new Quantity<>(
                        1000,
                        VolumeUnit.MILLILITRE);

        assertEquals(litre, ml);
    }

    @Test
    void shouldConvertLitreToMillilitre() {

        Quantity<VolumeUnit> litre =
                new Quantity<>(
                        1,
                        VolumeUnit.LITRE);

        Quantity<VolumeUnit> result =
                litre.convertTo(
                        VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> expected =
                new Quantity<>(
                        1000,
                        VolumeUnit.MILLILITRE);

        assertEquals(expected, result);
    }

    @Test
    void shouldReturnTrueForLitreAndGallon() {

        Quantity<VolumeUnit> gallon =
                new Quantity<>(
                        1,
                        VolumeUnit.GALLON);

        Quantity<VolumeUnit> litre =
                new Quantity<>(
                        3.79,
                        VolumeUnit.LITRE);

        assertEquals(
                gallon.toBaseUnit(),
                litre.toBaseUnit(),
                0.01);
    }

    @Test
    void shouldAddVolumesCorrectly() {

        Quantity<VolumeUnit> litre =
                new Quantity<>(
                        1,
                        VolumeUnit.LITRE);

        Quantity<VolumeUnit> ml =
                new Quantity<>(
                        1000,
                        VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result =
                litre.add(ml);

        Quantity<VolumeUnit> expected =
                new Quantity<>(
                        2,
                        VolumeUnit.LITRE);

        assertEquals(expected, result);
    }

    // ---------------- TYPE SAFETY ----------------

    @Test
    void shouldReturnFalseForVolumeAndWeight() {

        Quantity<VolumeUnit> litre =
                new Quantity<>(
                        1,
                        VolumeUnit.LITRE);

        Quantity<WeightUnit> kg =
                new Quantity<>(
                        1,
                        WeightUnit.KILOGRAM);

        assertNotEquals(litre, kg);
    }
}