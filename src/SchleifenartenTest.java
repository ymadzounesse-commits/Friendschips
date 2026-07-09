import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SchleifenartenTest {

    // Tests für sumDigitsFor
    @Test
    void sumDigitsFor_Normal() {
        assertEquals(10, Schleifenarten.sumDigitsFor(1234), 
            "Quersumme von 1234 sollte 10 sein (1+2+3+4)");
    }

    @Test
    void sumDigitsFor_Zero() {
        assertEquals(0, Schleifenarten.sumDigitsFor(0), 
            "Quersumme von 0 sollte 0 sein");
    }

    @Test
    void sumDigitsFor_SingleDigit() {
        assertEquals(7, Schleifenarten.sumDigitsFor(7), 
            "Quersumme von 7 sollte 7 sein");
    }

    @Test
    void sumDigitsFor_Negative() {
        assertEquals(-1, Schleifenarten.sumDigitsFor(-123), 
            "Negative Zahlen sollten -1 zurückgeben");
    }

    @Test
    void sumDigitsFor_Large() {
        assertEquals(45, Schleifenarten.sumDigitsFor(123456789), 
            "Quersumme von 123456789 sollte 45 sein");
    }

    // Tests für sumDigitsWhile
    @Test
    void sumDigitsWhile_Normal() {
        assertEquals(10, Schleifenarten.sumDigitsWhile(1234), 
            "Quersumme von 1234 sollte 10 sein (1+2+3+4)");
    }

    @Test
    void sumDigitsWhile_Zero() {
        assertEquals(0, Schleifenarten.sumDigitsWhile(0), 
            "Quersumme von 0 sollte 0 sein");
    }

    @Test
    void sumDigitsWhile_SingleDigit() {
        assertEquals(7, Schleifenarten.sumDigitsWhile(7), 
            "Quersumme von 7 sollte 7 sein");
    }

    @Test
    void sumDigitsWhile_Negative() {
        assertEquals(-1, Schleifenarten.sumDigitsWhile(-123), 
            "Negative Zahlen sollten -1 zurückgeben");
    }

    @Test
    void sumDigitsWhile_Large() {
        assertEquals(45, Schleifenarten.sumDigitsWhile(123456789), 
            "Quersumme von 123456789 sollte 45 sein");
    }

    // Tests für sumDigitsDoWhile
    @Test
    void sumDigitsDoWhile_Normal() {
        assertEquals(10, Schleifenarten.sumDigitsDoWhile(1234), 
            "Quersumme von 1234 sollte 10 sein (1+2+3+4)");
    }

    @Test
    void sumDigitsDoWhile_Zero() {
        assertEquals(0, Schleifenarten.sumDigitsDoWhile(0), 
            "Quersumme von 0 sollte 0 sein");
    }

    @Test
    void sumDigitsDoWhile_SingleDigit() {
        assertEquals(7, Schleifenarten.sumDigitsDoWhile(7), 
            "Quersumme von 7 sollte 7 sein");
    }

    @Test
    void sumDigitsDoWhile_Negative() {
        assertEquals(-1, Schleifenarten.sumDigitsDoWhile(-123), 
            "Negative Zahlen sollten -1 zurückgeben");
    }

    @Test
    void sumDigitsDoWhile_Large() {
        assertEquals(45, Schleifenarten.sumDigitsDoWhile(123456789), 
            "Quersumme von 123456789 sollte 45 sein");
    }

    // Vergleichstest: Alle drei Methoden sollten gleiche Ergebnisse liefern
    @Test
    void compareAllMethods() {
        int[] testValues = {0, 1, 10, 99, 1234, 567890};
        
        for (int n : testValues) {
            int forResult = Schleifenarten.sumDigitsFor(n);
            int whileResult = Schleifenarten.sumDigitsWhile(n);
            int doWhileResult = Schleifenarten.sumDigitsDoWhile(n);
            
            assertEquals(forResult, whileResult, 
                "for und while sollten gleiches Ergebnis für " + n + " liefern");
            assertEquals(forResult, doWhileResult, 
                "for und do-while sollten gleiches Ergebnis für " + n + " liefern");
        }
    }

}