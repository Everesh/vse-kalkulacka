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
}
