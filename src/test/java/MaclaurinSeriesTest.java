import com.lisi4ka.part1.MaclaurinSeriesCos;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class MaclaurinSeriesTest {

    @ParameterizedTest
    @CsvFileSource(resources = "test-data.csv")
    void testCos_Basic(double x, int terms, double expected, double delta) {
        Assertions.assertEquals(expected, MaclaurinSeriesCos.cos(x, terms), delta);
    }

    @ParameterizedTest
    @CsvSource({
            "1.0471975511965976, 10",
            "0, 100"
    })
    void testCos_PositiveAndNegativeX(double x, int terms) {
        Assertions.assertEquals(MaclaurinSeriesCos.cos(-x, terms), MaclaurinSeriesCos.cos(x, terms));
    }

    @ParameterizedTest
    @CsvSource({
            "100, 10000",
            "9, 4"
    })
    void testCos_LargeX_ThrowsException(double x, int terms) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> MaclaurinSeriesCos.cos(x, terms));
    }

    @ParameterizedTest
    @ValueSource(ints = {0})
    void testCos_ThrowsExceptionForNegativeTerms(int terms) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> MaclaurinSeriesCos.cos(2.4398, terms));
    }

    @ParameterizedTest
    @ValueSource(doubles = {Double.NaN})
    void testCos_ThrowsExceptionForNaN(double x) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> MaclaurinSeriesCos.cos(x, 10));
    }

    @ParameterizedTest
    @ValueSource(doubles = {Double.POSITIVE_INFINITY})
    void testCos_ThrowsExceptionForInfinity(double x) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> MaclaurinSeriesCos.cos(x, 10));
    }
}

