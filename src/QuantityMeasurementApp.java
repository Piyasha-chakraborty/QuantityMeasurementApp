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

        QuantityLength yard =
                new QuantityLength(
                        1.0,
                        LengthUnit.YARDS
                );

        QuantityLength feet =
                new QuantityLength(
                        3.0,
                        LengthUnit.FEET
                );

        QuantityLength cm =
                new QuantityLength(
                        1.0,
                        LengthUnit.CENTIMETERS
                );

        QuantityLength inch =
                new QuantityLength(
                        0.393701,
                        LengthUnit.INCH
                );

        System.out.println(
                "Yard to Feet Equality: "
                        + yard.equals(feet)
        );

        System.out.println(
                "CM to Inch Equality: "
                        + cm.equals(inch)
        );
    }
}