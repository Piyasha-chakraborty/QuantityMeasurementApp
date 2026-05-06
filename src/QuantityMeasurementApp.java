public class QuantityMeasurementApp {

    // ---------------- LENGTH ----------------

    enum LengthUnit {

        FEET(1.0),
        INCH(1.0 / 12),
        YARD(3.0),
        CENTIMETER(1.0 / 30.48);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double convertToBaseUnit(double value) {
            return value * conversionFactor;
        }

        public double convertFromBaseUnit(double baseValue) {
            return baseValue / conversionFactor;
        }
    }

    // ---------------- WEIGHT ----------------

    enum WeightUnit {

        KILOGRAM(1.0),
        GRAM(1.0 / 1000),
        POUND(0.453592);

        private final double conversionFactor;

        WeightUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double convertToBaseUnit(double value) {
            return value * conversionFactor;
        }

        public double convertFromBaseUnit(double baseValue) {
            return baseValue / conversionFactor;
        }
    }

    // ---------------- COMMON ----------------

    private final double value;

    private final LengthUnit lengthUnit;

    private final WeightUnit weightUnit;

    // Constructor for Length
    public QuantityMeasurementApp(
            double value,
            LengthUnit unit) {

        this.value = value;
        this.lengthUnit = unit;
        this.weightUnit = null;
    }

    // Constructor for Weight
    public QuantityMeasurementApp(
            double value,
            WeightUnit unit) {

        this.value = value;
        this.weightUnit = unit;
        this.lengthUnit = null;
    }

    // ---------------- LENGTH METHODS ----------------

    public double toBaseLengthUnit() {

        return lengthUnit.convertToBaseUnit(value);
    }

    public QuantityMeasurementApp addLength(
            QuantityMeasurementApp other) {

        double total =
                this.toBaseLengthUnit()
                        + other.toBaseLengthUnit();

        double converted =
                this.lengthUnit
                        .convertFromBaseUnit(total);

        return new QuantityMeasurementApp(
                converted,
                this.lengthUnit);
    }

    // ---------------- WEIGHT METHODS ----------------

    public double toBaseWeightUnit() {

        return weightUnit.convertToBaseUnit(value);
    }

    public QuantityMeasurementApp addWeight(
            QuantityMeasurementApp other) {

        double total =
                this.toBaseWeightUnit()
                        + other.toBaseWeightUnit();

        double converted =
                this.weightUnit
                        .convertFromBaseUnit(total);

        return new QuantityMeasurementApp(
                converted,
                this.weightUnit);
    }

    // ---------------- EQUALS ----------------

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof QuantityMeasurementApp))
            return false;

        QuantityMeasurementApp other =
                (QuantityMeasurementApp) obj;

        // Length comparison
        if (this.lengthUnit != null
                && other.lengthUnit != null) {

            return Double.compare(
                    this.toBaseLengthUnit(),
                    other.toBaseLengthUnit()) == 0;
        }

        // Weight comparison
        if (this.weightUnit != null
                && other.weightUnit != null) {

            return Double.compare(
                    this.toBaseWeightUnit(),
                    other.toBaseWeightUnit()) == 0;
        }

        return false;
    }
}