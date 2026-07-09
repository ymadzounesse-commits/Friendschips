import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

class FriendshipsTest {

    @Test
    void testInitNegative() {
        int[] result = Friendships.init(-1);
        assertNotNull(Arrays.toString(result), "Result darf nicht null sein");
        assertEquals(0, result.length, "Fall n < 0 funktioniert nicht");
    }

    @Test
    void testInitZero() {
        int[] result = Friendships.init(0);
        assertNotNull(Arrays.toString(result), "Result darf nicht null sein");
        assertEquals(0, result.length, "Fall n = 0 funktioniert nicht");
    }

    @Test
    void testInitPositive() {
        int n = 5;
        int[] result = Friendships.init(n);
        assertEquals(n, result.length, "Die Laenge soll " + n + "sein");
        for (int i = 0; i < n; i++) {
            assertEquals(i, result[i], "Das Element an Position " + i + " soll " + i + "sein");
        }
    }

    @Test
    void testFindIndexTooLarge() {
        int[] friends = {0, 1, 2};
        assertEquals(-1, Friendships.find(5, friends));
    }

    @Test
    void testFindNegativeIndex() {
        int[] friends = {0, 1, 2};
        assertEquals(-1, Friendships.find(-1, friends));
    }

    @Test
    void testFindValidIndex() {
        int[] friends = {0, 0, 2};
        assertEquals(0, Friendships.find(1, friends));
    }

    @Test
    void testFindEmptyArray() {
        int[] friends = {};
        assertEquals(-1, Friendships.find(0, friends));
    }

    @Test
    void testMakeFriendsBothInvalid() {
        int[] friends = {0, 1, 2};
        Friendships.make_friends(10, 11, friends);
        assertArrayEquals(new int[]{0, 1, 2}, friends);
    }

    @Test
    void testMakeFriendsOneInvalid() {
        int[] friends = {0, 1, 2};
        Friendships.make_friends(0, 10, friends);
        assertArrayEquals(new int[]{0, 1, 2}, friends);
    }

    @Test
    void testMakeFriendsBothValid() {
        int[] friends = {0, 1, 2};
        int[] expected = {0, 0, 2};
        Friendships.make_friends(0, 1, friends);
        assertArrayEquals(expected, friends);
    }

    @Test
    void testMakeFriendsFirstInvalid() {
        int[] friends = {0, 1, 2};
        Friendships.make_friends(10, 0, friends);
        assertArrayEquals(new int[]{0, 1, 2}, friends);
    }

    @Test
    void testMakeFriendsSamePerson() {
        int[] friends = {0, 1, 2};
        Friendships.make_friends(1, 1, friends);
        assertArrayEquals(new int[]{0, 1, 2}, friends);
    }

    @Test
    void testMakeFriendsAlreadyInSameGroup() {
        int[] friends = {0, 0, 2};
        Friendships.make_friends(0, 1, friends);
        assertArrayEquals(new int[]{0, 0, 2}, friends);
    }

    @Test
    void testMakeFriendsTransitive() {
        int[] friends = {0, 1, 2};
        Friendships.make_friends(0, 1, friends);
        Friendships.make_friends(1, 2, friends);
        assertTrue(Friendships.are_friends(friends, 0, 2));
        assertTrue(Friendships.are_friends(friends, 1, 2));
    }

    @Test
    void testMakeFriendsMergeTwoGroups() {
        int[] friends = {0, 0, 2, 2};
        Friendships.make_friends(0, 2, friends);
        assertArrayEquals(new int[]{0, 0, 0, 0}, friends);
    }

    @Test
    void testCountFriendsNegativeIndex() {
        int[] friends = {0, 1, 2};
        assertEquals(-1, Friendships.count_friends(-1, friends));
    }

    @Test
    void testCountFriendsIndexTooLarge() {
        int[] friends = {0, 1, 2};
        assertEquals(-1, Friendships.count_friends(10, friends));
    }

    @Test
    void testCountFriendsValid() {
        int[] friends = {0, 0, 2};
        assertEquals(1, Friendships.count_friends(0, friends));
    }

    @Test
    void testCountFriendsAlone() {
        int[] friends = {0, 1, 2};
        assertEquals(0, Friendships.count_friends(1, friends));
    }

    @Test
    void testCountFriendsLargerGroup() {
        int[] friends = {0, 0, 0, 0};
        assertEquals(3, Friendships.count_friends(2, friends));
    }

    @Test
    void testAreFriendsBothInvalid() {
        int[] friends = {0, 1, 2};
        assertFalse(Friendships.are_friends(friends, 10, 11));
    }

    @Test
    void testAreFriendsOneInvalid() {
        int[] friends = {0, 1, 2};
        assertFalse(Friendships.are_friends(friends, 0, 10));
    }

    @Test
    void testAreFriendsBothValidTrue() {
        int[] friends = {0, 0, 2};
        assertTrue(Friendships.are_friends(friends, 0, 1));
    }

    @Test
    void testAreFriendsBothValidFalse() {
        int[] friends = {0, 1, 2};
        assertFalse(Friendships.are_friends(friends, 0, 1));
    }

    @Test
    void testAreFriendsSamePerson() {
        int[] friends = {0, 1, 2};
        assertTrue(Friendships.are_friends(friends, 1, 1));
    }

    @Test
    void testCountPopularEmpty() {
        int[] friends = {};
        assertEquals(0, Friendships.count_popular(friends));
    }

    @Test
    void testCountPopularNoneConnected() {
        int[] friends = {0, 1, 2, 3, 4};
        assertEquals(0, Friendships.count_popular(friends));
    }

    @Test
    void testCountPopularGroupOfThree() {
        int[] friends = {0, 0, 0};
        assertEquals(0, Friendships.count_popular(friends));
    }

    @Test
    void testCountPopularGroupOfFour() {
        int[] friends = {0, 0, 0, 0};
        assertEquals(4, Friendships.count_popular(friends));
    }

    @Test
    void testCountPopularMixed() {
        int[] friends = {0, 0, 0, 0, 4};
        assertEquals(4, Friendships.count_popular(friends));
    }

    @Test
    void testCountPopularMultipleGroups() {
        int[] friends = {0, 0, 0, 0, 0, 5, 5};
        assertEquals(5, Friendships.count_popular(friends));
    }

    @Test
    void testCountPopularTwoPopularGroups() {
        int[] friends = {0, 0, 0, 0, 4, 4, 4, 4};
        assertEquals(8, Friendships.count_popular(friends));
    }

    @Test
    void testCountPopularSinglePerson() {
        int[] friends = {0};
        assertEquals(0, Friendships.count_popular(friends));
    }
}