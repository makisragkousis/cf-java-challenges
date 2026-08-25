package gr.aueb.cf.ch05;

import java.util.Scanner;

/**
 * Βρίσκει και τυπώνει τον μεγαλύτερο
 * από τρεις ακέραιους αριθμούς με τη
 * χρήση μεθόδου.
 */

public class FindMaxMethodApp {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int a = 0;
        int b = 0;
        int c = 0;
        int max = 0;

        System.out.println("Εισάγετε τρεις ακεραίους:");
        a = getInt();
        b = getInt();
        c = getInt();

        max = findMax(a, b, c);

        System.out.printf("Ο μεγαλύτερος εκ των τριών ακεραίων είναι ο: %d.%n", max);
    }

    /**
     * Λαμβάνει έναν ακέραιο από τον χρήστη
     * @return τον ακέραιο
     */
    public static int getInt() {
        return scanner.nextInt();
    }

    /**
     * Βρίσκει τον μεγαλύτερο μεταξύ τριών ακεραίων.
     * @param a ο πρώτος ακέραιος
     * @param b ο δεύτερος ακέραιος
     * @param c ο τρίτος ακέραιος
     * @return τον μεγαλύτερο ακέραιο
     */
    public static int findMax (int a, int b, int c) {
        return Math.max(a, Math.max(b, c));

//        if (a > b) {
//            if (a > c) {
//                return a;
//            }
//            return c;
//        } else if (b > c) {
//            if (b > a) {
//                return b;
//            }
//            return a;
//        }
//        return c;
//
//        Ή και
//
//        if (a > b) {
//            return Math.max(a, c);
//        } else if (b > c) {
//            return b;
//        }
//        return c;
    }
}
