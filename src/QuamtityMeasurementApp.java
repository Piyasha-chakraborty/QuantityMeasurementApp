public class QuantityMeasurementApp {

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

    private final double value;
    private final LengthUnit unit;

    public QuantityMeasurementApp(double value, LengthUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    public double toBaseUnit() {
        return unit.convertToBaseUnit(value);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof QuantityMeasurementApp))
            return false;

        QuantityMeasurementApp other =
                (QuantityMeasurementApp) obj;

        return Double.compare(
                this.toBaseUnit(),
                other.toBaseUnit()) == 0;
    }

    public QuantityMeasurementApp add(
            QuantityMeasurementApp other) {

        double totalBaseValue =
                this.toBaseUnit() + other.toBaseUnit();

        double convertedValue =
                this.unit.convertFromBaseUnit(totalBaseValue);

        return new QuantityMeasurementApp(
                convertedValue,
                this.unit);
    }
}