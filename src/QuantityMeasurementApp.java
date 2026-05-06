interface IMeasurable {

    double getConversionFactor();

    double convertToBaseUnit(double value);

    double convertFromBaseUnit(double baseValue);

    String getUnitName();
}

// ---------------- LENGTH UNIT ----------------

enum LengthUnit implements IMeasurable {

    FEET(1.0),
    INCH(1.0 / 12),
    YARD(3.0),
    CENTIMETER(1.0 / 30.48);

    private final double conversionFactor;

    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    @Override
    public double getConversionFactor() {
        return conversionFactor;
    }

    @Override
    public double convertToBaseUnit(double value) {
        return value * conversionFactor;
    }

    @Override
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / conversionFactor;
    }

    @Override
    public String getUnitName() {
        return name();
    }
}

// ---------------- WEIGHT UNIT ----------------

enum WeightUnit implements IMeasurable {

    KILOGRAM(1.0),
    GRAM(1.0 / 1000),
    POUND(0.453592);

    private final double conversionFactor;

    WeightUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    @Override
    public double getConversionFactor() {
        return conversionFactor;
    }

    @Override
    public double convertToBaseUnit(double value) {
        return value * conversionFactor;
    }

    @Override
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / conversionFactor;
    }

    @Override
    public String getUnitName() {
        return name();
    }
}

// ---------------- VOLUME UNIT ----------------

enum VolumeUnit implements IMeasurable {

    LITRE(1.0),
    MILLILITRE(0.001),
    GALLON(3.78541);

    private final double conversionFactor;

    VolumeUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    @Override
    public double getConversionFactor() {
        return conversionFactor;
    }

    @Override
    public double convertToBaseUnit(double value) {
        return value * conversionFactor;
    }

    @Override
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / conversionFactor;
    }

    @Override
    public String getUnitName() {
        return name();
    }
}

// ---------------- GENERIC QUANTITY ----------------

class Quantity<U extends IMeasurable> {

    private final double value;

    private final U unit;

    public Quantity(double value, U unit) {

        if (unit == null) {
            throw new IllegalArgumentException(
                    "Unit cannot be null");
        }

        this.value = value;
        this.unit = unit;
    }

    public double toBaseUnit() {

        return unit.convertToBaseUnit(value);
    }

    public Quantity<U> convertTo(U targetUnit) {

        double baseValue = this.toBaseUnit();

        double converted =
                targetUnit.convertFromBaseUnit(baseValue);

        converted =
                Math.round(converted * 100.0) / 100.0;

        return new Quantity<>(converted, targetUnit);
    }

    public Quantity<U> add(Quantity<U> other) {

        double total =
                this.toBaseUnit()
                        + other.toBaseUnit();

        double converted =
                this.unit.convertFromBaseUnit(total);

        return new Quantity<>(converted, this.unit);
    }

    // ---------------- SUBTRACTION ----------------

    public Quantity<U> subtract(Quantity<U> other) {

        double result =
                this.toBaseUnit()
                        - other.toBaseUnit();

        double converted =
                this.unit.convertFromBaseUnit(result);

        converted =
                Math.round(converted * 100.0) / 100.0;

        return new Quantity<>(converted, this.unit);
    }

    public Quantity<U> subtract(
            Quantity<U> other,
            U targetUnit) {

        double result =
                this.toBaseUnit()
                        - other.toBaseUnit();

        double converted =
                targetUnit.convertFromBaseUnit(result);

        converted =
                Math.round(converted * 100.0) / 100.0;

        return new Quantity<>(converted, targetUnit);
    }

    // ---------------- DIVISION ----------------

    public double divide(Quantity<U> other) {

        if (other.toBaseUnit() == 0) {

            throw new ArithmeticException(
                    "Cannot divide by zero");
        }

        return this.toBaseUnit()
                / other.toBaseUnit();
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof Quantity<?>))
            return false;

        Quantity<?> other =
                (Quantity<?>) obj;

        if (this.unit.getClass()
                != other.unit.getClass()) {

            return false;
        }

        return Double.compare(
                this.toBaseUnit(),
                other.toBaseUnit()) == 0;
    }

    @Override
    public int hashCode() {

        return Double.hashCode(toBaseUnit());
    }

    @Override
    public String toString() {

        return value + " " + unit.getUnitName();
    }
}

// ---------------- MAIN CLASS ----------------

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        Quantity<VolumeUnit> litre =
                new Quantity<>(5,
                        VolumeUnit.LITRE);

        Quantity<VolumeUnit> ml =
                new Quantity<>(2000,
                        VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> result =
                litre.subtract(ml);

        System.out.println(result);

        double ratio =
                litre.divide(ml);

        System.out.println(ratio);
    }
}