import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KalkulackaTest {

    private Kalkulator kalk;

    @BeforeEach
    public void setUp() {
        kalk = new Kalkulator();
    }

    @Test
    public void test35() {
        kalk.cislice(3);
        assertEquals(3, kalk.getHodnotaKZobrazeni());
        kalk.cislice(5);
        assertEquals(35, kalk.getHodnotaKZobrazeni());
    }

    @Test
    public void test35Vymaz() {
        kalk.cislice(3);
        kalk.cislice(5);
        kalk.vymaz();
        assertEquals(0, kalk.getHodnotaKZobrazeni());
    }

    @Test
    public void test35Plus2Rovnase() {
        kalk.cislice(3);
        kalk.cislice(5);
        kalk.plus();
        assertEquals(0, kalk.getHodnotaKZobrazeni());
        kalk.cislice(2);
        assertEquals(2, kalk.getHodnotaKZobrazeni());
        kalk.rovnaSe();
        assertEquals(37, kalk.getHodnotaKZobrazeni());
    }

    @Test
    public void testUkol1() {
        kalk.cislice(3);
        kalk.cislice(5);
        kalk.plus();
        assertEquals(35, kalk.getHodnotaKZobrazeni());
        kalk.cislice(2);
        assertEquals(2, kalk.getHodnotaKZobrazeni());
        kalk.rovnaSe();
        assertEquals(37, kalk.getHodnotaKZobrazeni());
        kalk.cislice(2);
        kalk.rovnaSe();
        assertEquals(2, kalk.getHodnotaKZobrazeni());
    }

    @Test
    public void testUkol2() {
        kalk.cislice(3);
        kalk.cislice(5);
        kalk.plus();
        assertEquals(35, kalk.getHodnotaKZobrazeni());
        kalk.rovnaSe();
        assertEquals(70, kalk.getHodnotaKZobrazeni());
    }

    @Test
    public void testUkol3() {
        kalk.cislice(3);
        kalk.cislice(5);
        kalk.plus();
        assertEquals(35, kalk.getHodnotaKZobrazeni());
        kalk.cislice(2);
        kalk.rovnaSe();
        assertEquals(37, kalk.getHodnotaKZobrazeni());
        kalk.rovnaSe();
        assertEquals(39, kalk.getHodnotaKZobrazeni());
    }

    @Test
    public void testUkol4() {
        kalk.cislice(2);
        kalk.cislice(1);
        kalk.cislice(4);
        kalk.cislice(7);
        kalk.cislice(4);
        kalk.cislice(8);
        kalk.cislice(3);
        kalk.cislice(6);
        kalk.cislice(4);
        kalk.cislice(8);
        assertEquals(214748364, kalk.getHodnotaKZobrazeni());
        kalk.cislice(7);
        assertEquals(2147483647, kalk.getHodnotaKZobrazeni());
        kalk.cislice(8);
        assertEquals(2147483647, kalk.getHodnotaKZobrazeni());
    }
}
