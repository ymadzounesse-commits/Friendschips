public class Friendships {

    /**
     * Initialisiert ein Array zur Verwaltung von Freundschaftsgruppen.
     * Jede Person ist zunächst ihr eigener Repräsentant (friends[i] = i).
     *
     * @param n die Anzahl der Personen (0 bis n-1)
     * @return ein Array der Größe n, wobei friends[i] = i für alle i, oder leeres Array falls n <= 0
     */
    public static int[] init(int n) {

        if (n <= 0) {
            return new int[]{};
        }
        int[] newArray = new int[n];
        for (int i = 0; i < n; i++) {
            newArray[i] = i;
        }
        return newArray;

    }

    public static int find(int i, int[] friends) {
        if (i < 0 || i >= friends.length) {
            return -1;
        }
        return friends[i];
    }


    static void make_friends(int i, int j, int[] friends) {
        if (i < 0 || i >= friends.length || j < 0 || j >= friends.length) {
            return;
        }

        int repI = Friendships.find(i, friends);
        int repJ = Friendships.find(j, friends);

        if (repI == repJ) {
            return;
        }

        for (int k = 0; k < friends.length; k++) {
            if (friends[k] == repJ) {
                friends[k] = repI;
            }
        }
    }

    static int count_friends(int i, int[] friends) {
        if (i < 0 || i >= friends.length) {
            return -1;
        }

        int repI = Friendships.find(i, friends);


        int count = 0;
        for (int k = 0; k < friends.length; k++) {
            if (k != i && friends[k] == repI) {
                count++;
            }
        }

        return count;
    }

    static boolean are_friends(int[] friends, int i, int j) {
        if (i < 0 || i >= friends.length || j < 0 || j >= friends.length) {
            return false;
        }

        return Friendships.find(i, friends) == Friendships.find(j, friends);
    }

    static int count_popular(int[] friends) {
        int popularCount = 0;

        for (int i = 0; i < friends.length; i++) {

            int amis = count_friends(i, friends);

            if (amis >= 3) {
                popularCount++;
            }
        }

        return popularCount;
    }

}
