package gr.aueb.cf.ch05;

import java.util.Scanner;

/**
 * Λαμβάνει έναν ακέραιο από τον χρήστη και υπολογίζει
 * το τετράγωνο του αριθμού με τη χρήση μεθόδου.
 */
public class SquareMethodApp {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int base = 0;
        int result = 0;

        System.out.println("Εισάγετε έναν ακέραιο:");
        base = getInt();

        result = square(base);
        System.out.printf("Το %d υψωμένος στο τετράγωνο ισούται με: %d.%n", base, result);
    }

    /**
     * Λαμβάνει έναν ακέραιο από τον χρήστη
     * @return τον ακέραιο
     */
    public static int getInt() {
        return scanner.nextInt();
    }

    /**
     * Υψώνει στο τετράγωνο έναν ακέραιο
     * @param base ο ακέραιος που θα τετραγωνιστεί
     * @return τον ακέραιο ^ 2
     */
    public static int square(int base) {
        return base * base;

//        int result = 1;
//
//        for (int i = 1; i <= 2; i++) {
//            result *= base;
//        }
//        return result;
    }
}
