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

    // ---------------- OPERATION ENUM ----------------

    private enum ArithmeticOperation {

        ADD,
        SUBTRACT,
        DIVIDE
    }

    public Quantity(double value, U unit) {

        if (unit == null) {

            throw new IllegalArgumentException(
                    "Unit cannot be null");
        }

        if (!Double.isFinite(value)) {

            throw new IllegalArgumentException(
                    "Value must be finite");
        }

        this.value = value;
        this.unit = unit;
    }

    public double toBaseUnit() {

        return unit.convertToBaseUnit(value);
    }

    // ---------------- CENTRALIZED HELPER ----------------

    private double performOperation(
            Quantity<U> other,
            ArithmeticOperation operation) {

        if (other == null) {

            throw new IllegalArgumentException(
                    "Other quantity cannot be null");
        }

        if (this.unit.getClass()
                != other.unit.getClass()) {

            throw new IllegalArgumentException(
                    "Different measurement categories");
        }

        double thisBase =
                this.toBaseUnit();

        double otherBase =
                other.toBaseUnit();

        switch (operation) {

            case ADD:
                return thisBase + otherBase;

            case SUBTRACT:
                return thisBase - otherBase;

            case DIVIDE:

                if (otherBase == 0) {

                    throw new ArithmeticException(
                            "Cannot divide by zero");
                }

                return thisBase / otherBase;

            default:
                throw new IllegalArgumentException(
                        "Invalid operation");
        }
    }

    // ---------------- ADDITION ----------------

    public Quantity<U> add(
            Quantity<U> other) {

        double result =
                performOperation(
                        other,
                        ArithmeticOperation.ADD);

        double converted =
                unit.convertFromBaseUnit(result);

        converted =
                Math.round(converted * 100.0) / 100.0;

        return new Quantity<>(
                converted,
                unit);
    }

    public Quantity<U> add(
            Quantity<U> other,
            U targetUnit) {

        double result =
                performOperation(
                        other,
                        ArithmeticOperation.ADD);

        double converted =
                targetUnit.convertFromBaseUnit(result);

        converted =
                Math.round(converted * 100.0) / 100.0;

        return new Quantity<>(
                converted,
                targetUnit);
    }

    // ---------------- SUBTRACTION ----------------

    public Quantity<U> subtract(
            Quantity<U> other) {

        double result =
                performOperation(
                        other,
                        ArithmeticOperation.SUBTRACT);

        double converted =
                unit.convertFromBaseUnit(result);

        converted =
                Math.round(converted * 100.0) / 100.0;

        return new Quantity<>(
                converted,
                unit);
    }

    public Quantity<U> subtract(
            Quantity<U> other,
            U targetUnit) {

        double result =
                performOperation(
                        other,
                        ArithmeticOperation.SUBTRACT);

        double converted =
                targetUnit.convertFromBaseUnit(result);

        converted =
                Math.round(converted * 100.0) / 100.0;

        return new Quantity<>(
                converted,
                targetUnit);
    }

    // ---------------- DIVISION ----------------

    public double divide(
            Quantity<U> other) {

        return performOperation(
                other,
                ArithmeticOperation.DIVIDE);
    }

    // ---------------- EQUALS ----------------

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

        return Double.hashCode(
                toBaseUnit());
    }

    @Override
    public String toString() {

        return value + " "
                + unit.getUnitName();
    }
}

// ---------------- MAIN CLASS ----------------

public class QuantityMeasurementApp {

    public static void main(String[] args) {

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

        System.out.println(result);

        double ratio =
                feet.divide(inch);

        System.out.println(ratio);
    }
}