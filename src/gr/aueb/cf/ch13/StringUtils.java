package gr.aueb.cf.ch13;

/**
 * Utility class για string manipulation,
 * όπως να γίνεται reverse ένα string, να
 * μετατρέπεται ένα string σε uppercase, και να
 * ελέγχεται εάν ένα string είναι παλινδρομικό
 */

public class StringUtils {

    private StringUtils() {}

    /**
     * Αντιστρέφει ένα δοσμένο String.
     * @param s το String που θέλουμε να αντιστρέψουμε.
     * @return το ανεστραμμένο String, ή null αν δοθεί null ως είσοδος.
     */
    public static String getReverse(String s) {
        if (s == null) return null;

        return new  StringBuilder(s).reverse().toString();
    }

    /**
     * Μετατρέπει όλους τους χαρακτήρες ενός δοσμένου String σε κεφαλαία.
     * @param s το String που θέλουμε να μετατρέψουμε.
     * @return το String με κεφαλαίους χαρακτήρες, ή null αν δοθεί null ως είσοδος.
     */
    public static String getUpper(String s) {
        if (s == null) return null;

        return s.toUpperCase();
    }

    /**
     * Ελέγχει εάν ένα δοσμένο String είναι παλινδρομικό
     * (δηλαδή εάν διαβάζεται ακριβώς το ίδιο από την αρχή προς το τέλος και αντίστροφα).
     * @param s το String προς έλεγχο.
     * @return true αν το String είναι παλινδρομικό, false αν δεν είναι ή αν δοθεί null ως είσοδος.
     */
    public static boolean isPalindrome(String s) {
        if (s == null) return false;

//        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
//            if (s.charAt(i) != s.charAt(j)) return false;
//        }
//        return true;

        return new StringBuilder(s).reverse().toString().equals(s);
    }
}
