import com.lisi4ka.part1.MaclaurinSeriesCos;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaclaurinSeriesTest {

    @Test
    void testCos_Zero() {
        assertEquals(1.0, MaclaurinSeriesCos.cos(0, 10), 1e-10);
    }

    @Test
    void testCos_PiOver3() {
        assertEquals(0.5, MaclaurinSeriesCos.cos(Math.PI / 3, 10), 1e-10);
    }

    @Test
    void testCos_NegativeX() {
        assertEquals(0.5, MaclaurinSeriesCos.cos(-Math.PI / 3, 10), 1e-10);
    }

    @Test
    void testCos_SmallTerms() {
        assertEquals(1.0, MaclaurinSeriesCos.cos(Math.PI / 3, 1), 1e-10);
    }

    @Test
    void testCos_LargeX_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> MaclaurinSeriesCos.cos(10, 10));
    }

    @Test
    void testCos_XGreaterThan2TimesTerms_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> MaclaurinSeriesCos.cos(9, 4)); // 9 > 2*4
    }

    @Test
    void testCos_LargeTerms() {
        assertEquals(0.5, MaclaurinSeriesCos.cos(Math.PI / 3, 500), 1e-15);
    }

    @Test
    void testCos_ThrowsExceptionForNegativeTerms() {
        assertThrows(IllegalArgumentException.class, () -> MaclaurinSeriesCos.cos(1.0, 0));
    }

    @Test
    void testCos_ThrowsExceptionForNaN() {
        assertThrows(IllegalArgumentException.class, () -> MaclaurinSeriesCos.cos(Double.NaN, 10));
    }

    @Test
    void testCos_ThrowsExceptionForInfinity() {
        assertThrows(IllegalArgumentException.class, () -> MaclaurinSeriesCos.cos(Double.POSITIVE_INFINITY, 10));
    }



}
