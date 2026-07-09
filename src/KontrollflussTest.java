import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KontrollflussTest {
    @Test
    void testUnknown1() {
        assertEquals(5, Kontrollfluss.unknown(5,4,6), "1. Fall funktioniert nicht");
    }

    @Test
    void testUnknown2() {
        assertEquals(6, Kontrollfluss.unknown(7,4,6), "2. Fall funktioniert nicht");
    }

    @Test
    void testUnknown3() {
        assertEquals(2, Kontrollfluss.unknown(5,2,1), "3. Fall funktioniert nicht");
    }

    @Test
    void testUnknown4() {
        assertEquals(3, Kontrollfluss.unknown(2,4,3), "4. Fall funktioniert nicht");
    }

    @Test
    void testUnknown5() {
        assertEquals(4, Kontrollfluss.unknown(2,4,5), "5. Fall funktioniert nicht");
    }

    @Test
    void testUnknown6() {
        assertEquals(2, Kontrollfluss.unknown(2,4,1), "6. Fall funktioniert nicht");
    }
}