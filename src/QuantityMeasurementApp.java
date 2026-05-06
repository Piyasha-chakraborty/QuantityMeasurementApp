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
            this.value = value;
            this.unit = unit;
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
                        "Invalid numeric value"
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

        double feetToInches =
                QuantityLength.convert(
                        1.0,
                        LengthUnit.FEET,
                        LengthUnit.INCH
                );

        double yardsToInches =
                QuantityLength.convert(
                        1.0,
                        LengthUnit.YARDS,
                        LengthUnit.INCH
                );

        double cmToFeet =
                QuantityLength.convert(
                        30.48,
                        LengthUnit.CENTIMETERS,
                        LengthUnit.FEET
                );

        System.out.println(
                "1 Foot in Inches = "
                        + feetToInches
        );

        System.out.println(
                "1 Yard in Inches = "
                        + yardsToInches
        );

        System.out.println(
                "30.48 CM in Feet = "
                        + cmToFeet
        );
    }
}
