public class QuantityMeasurementApp {

    enum LengthUnit {

        FEET(1.0),
        INCH(1.0 / 12.0),
        YARDS(3.0),
        CENTIMETERS(0.393701 / 12.0);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    static class QuantityLength {

        private final double value;
        private final LengthUnit unit;

        QuantityLength(double value, LengthUnit unit) {

            if (!Double.isFinite(value)) {
                throw new IllegalArgumentException(
                        "Invalid value"
                );
            }

            if (unit == null) {
                throw new IllegalArgumentException(
                        "Unit cannot be null"
                );
            }

            this.value = value;
            this.unit = unit;
        }

        public double getValue() {
            return value;
        }

        public LengthUnit getUnit() {
            return unit;
        }

        private double toFeet() {
            return value * unit.getConversionFactor();
        }

        public static double convert(
                double value,
                LengthUnit sourceUnit,
                LengthUnit targetUnit
        ) {

            if (!Double.isFinite(value)) {
                throw new IllegalArgumentException(
                        "Invalid value"
                );
            }

            if (sourceUnit == null || targetUnit == null) {
                throw new IllegalArgumentException(
                        "Unit cannot be null"
                );
            }

            double valueInFeet =
                    value * sourceUnit.getConversionFactor();

            return valueInFeet
                    / targetUnit.getConversionFactor();
        }

        public QuantityLength add(
                QuantityLength other
        ) {

            if (other == null) {
                throw new IllegalArgumentException(
                        "Quantity cannot be null"
                );
            }

            double totalFeet =
                    this.toFeet() + other.toFeet();

            double resultValue =
                    totalFeet / this.unit.getConversionFactor();

            return new QuantityLength(
                    resultValue,
                    this.unit
            );
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj)
                return true;

            if (obj == null || getClass() != obj.getClass())
                return false;

            QuantityLength other = (QuantityLength) obj;

            return Double.compare(
                    this.toFeet(),
                    other.toFeet()
            ) == 0;
        }
    }

    public static void main(String[] args) {

        QuantityLength feet =
                new QuantityLength(
                        1.0,
                        LengthUnit.FEET
                );

        QuantityLength inches =
                new QuantityLength(
                        12.0,
                        LengthUnit.INCH
                );

        QuantityLength result =
                feet.add(inches);

        System.out.println(
                "Addition Result = "
                        + result.getValue()
                        + " "
                        + result.getUnit()
        );
    }
}