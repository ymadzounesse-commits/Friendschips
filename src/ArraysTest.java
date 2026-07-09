import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArraysTest {


    @Test
    void sum1() {
        int[] array = {1, 2, 3, 4};
        assertEquals(10, Arrays.sum(array), "Summe von {1,2,3,4} sollte 10 sein");
    }

    @Test
    void sum2() {
        int[] array = {-1, -2, -3};
        assertEquals(-6, Arrays.sum(array), "Summe von negativen Zahlen sollte funktionieren");
    }

    @Test
    void sum3() {
        int[] array = {0, 0, 0};
        assertEquals(0, Arrays.sum(array), "Summe von Nullen sollte 0 sein");
    }

    @Test
    void sumEmpty() {
        int[] array = {};
        assertEquals(0, Arrays.sum(array), "Summe von leerem Array sollte 0 sein");
    }

    @Test
    void sumSingle() {
        int[] array = {5};
        assertEquals(5, Arrays.sum(array), "Summe von Array mit einem Element sollte dieses Element sein");
    }

    @Test
    void sumMixed() {
        int[] array = {-5, 10, -3, 8};
        assertEquals(10, Arrays.sum(array), "Summe von gemischten positiven und negativen Zahlen sollte funktionieren");
    }

    @Test
    void invertNormal() {
        double[] array = {1.0, 2.0, 3.0};
        Arrays.invert(array);
        assertArrayEquals(new double[]{-1.0, -2.0, -3.0}, array, "Invertierung sollte korrekt sein");
    }

    @Test
    void invertEmpty() {
        double[] array = {};
        Arrays.invert(array);
        assertArrayEquals(new double[]{}, array, "Invertierung eines leeren Arrays sollte leer bleiben");
    }

    @Test
    void invertSingle() {
        double[] array = {5.0};
        Arrays.invert(array);
        assertArrayEquals(new double[]{-5.0}, array, "Invertierung eines Arrays mit einem Element sollte korrekt sein");
    }

    @Test
    void invertNegative() {
        double[] array = {-1.0, -2.0, -3.0};
        Arrays.invert(array);
        assertArrayEquals(new double[]{1.0, 2.0, 3.0}, array, "Invertierung von negativen Zahlen sollte korrekt sein");
    }

    @Test
    void invertMixed() {
        double[] array = {1.0, -2.0, 3.0, -4.0};
        Arrays.invert(array);
        assertArrayEquals(new double[]{-1.0, 2.0, -3.0, 4.0}, array, "Invertierung von gemischten Zahlen sollte korrekt sein");
    }

    @Test
    void reverseNormal() {
        int[] array = {1, 2, 3, 4};
        int[] expected = {4, 3, 2, 1};
        assertArrayEquals(expected, Arrays.reverse(array), "Reverse sollte korrekt sein");
    }

    @Test
    void reverseEmpty() {
        int[] array = {};
        assertArrayEquals(new int[]{}, Arrays.reverse(array), "Reverse eines leeren Arrays sollte leer bleiben");
    }

    @Test
    void reverseSingle() {
        int[] array = {5};
        assertArrayEquals(new int[]{5}, Arrays.reverse(array), "Reverse eines Arrays mit einem Element sollte das Element unverändert lassen");
    }

    @Test
    void reverseMixed() {
        int[] array = {1, 2, 3, 4, 5};
        int[] expected = {5, 4, 3, 2, 1};
        assertArrayEquals(expected, Arrays.reverse(array), "Reverse von gemischten Zahlen sollte korrekt sein");
    }

    @Test
    void reverseInPlaceNormal() {
        int[] array = {1, 2, 3, 4};
        Arrays.reverse_inplace(array);
        assertArrayEquals(new int[]{4, 3, 2, 1}, array, "In-place Reverse sollte korrekt sein");
    }

    @Test
    void reverseInPlaceEmpty() {
        int[] array = {};
        Arrays.reverse_inplace(array);
        assertArrayEquals(new int[]{}, array, "In-place Reverse eines leeren Arrays sollte leer bleiben");
    }

    @Test
    void reverseInPlaceSingle() {
        int[] array = {5};
        Arrays.reverse_inplace(array);
        assertArrayEquals(new int[]{5}, array, "In-place Reverse eines Arrays mit einem Element sollte das Element unverändert lassen");
    }

    @Test
    void reverseInPlaceMixed() {
        int[] array = {1, 2, 3, 4, 5};
        Arrays.reverse_inplace(array);
        assertArrayEquals(new int[]{5, 4, 3, 2, 1}, array, "In-place Reverse von gemischten Zahlen sollte korrekt sein");
    }

    @Test
    void max1() {
        int[][] array = {{4,5},{6,7},{1,2}};
        assertEquals(7, Arrays.maxElement(array), "Fall mit Array {4,5},{6,7},{1,2} funktioniert nicht");
    }

    @Test
    void max2() {
        int[][] array = {{9,5},{6,7},{1}};
        assertEquals(9, Arrays.maxElement(array), "Fall mit Array {9,5},{6,7},{1} funktioniert nicht");
    }

    @Test
    void maxEmpty() {
        int[][] array = {};
        assertEquals(0, Arrays.maxElement(array), "Fall mit leerem Array funktioniert nicht");
    }

    @Test
    void max3() {
        int[][] array = {{1,2,6,4}};
        assertEquals(6, Arrays.maxElement(array), "Fall mit 1x4 Array funktioniert nicht");
    }

    @Test
    void max4() {
        int[][] array = {{-5,-1,-3,-2}};
        assertEquals(-1, Arrays.maxElement(array), "Fall mit 1x4 Array funktioniert nicht");
    }

}
