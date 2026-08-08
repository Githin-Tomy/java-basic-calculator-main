public class SimpleCalculatorTest {
    private static final double DELTA = 0.000001;

    public static void main(String[] args) {
        SimpleCalculator calculator = new SimpleCalculator();

        assertEquals(-1.0, calculator.subtract(2.0, 3.0), "subtraction");
        assertEquals(6.0, calculator.multiply(2.0, 3.0), "multiplication");
        assertEquals(2.5, calculator.divide(5.0, 2.0), "division");
        assertEquals(1.0, calculator.modulo(7.0, 3.0), "modulo");

        assertNaN(calculator.divide(1.0, 0.0), "division by zero");
        assertNaN(calculator.modulo(1.0, 0.0), "modulo by zero");

        System.out.println("All SimpleCalculator tests passed.");
    }

    private static void assertEquals(double expected, double actual, String operation) {
        if (Math.abs(expected - actual) > DELTA) {
            throw new AssertionError(operation + ": expected " + expected + ", got " + actual);
        }
    }

    private static void assertNaN(double actual, String operation) {
        if (!Double.isNaN(actual)) {
            throw new AssertionError(operation + ": expected NaN, got " + actual);
        }
    }
}
