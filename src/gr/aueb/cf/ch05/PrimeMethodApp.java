package gr.aueb.cf.ch05;

import java.util.Scanner;

/**
 * Λαμβάνει έναν ακέραιο και τυπώνει αν
 * είναι πρώτος, δηλαδή διαιρείται ακριβώς μόνο
 * με τον εαυτό του και το 1.
 */

public class PrimeMethodApp {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int inputNum = 0;
        boolean isNumPrime = false;

        System.out.println("Εισάγετε έναν ακέραιο:");
        inputNum = getInt();

        isNumPrime = isPrime(inputNum);

        System.out.printf("Το %d είναι πρώτος: %b.%n", inputNum, isNumPrime);
    }

    /**
     * Λαμβάνει έναν ακέραιο από τον χρήστη
     * @return τον ακέραιο
     */
    public static int getInt() {
        return scanner.nextInt();
    }

    /**
     * Ελέγχει αν ένας αριθμός είναι πρώτος ή όχι
     * @param num ο αριθμός που δίνει ο χρήστης
     * @return true αν είναι πρώτος, αλλιώς false
     */
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i <= (num / 2); i++) { //Μέχρι το num/2, αντί για num-1. Κανένας αριθμός δεν μπορεί να έχει ακέραιο διαιρέτη μεγαλύτερο από το μισό του (π.χ. το μεγαλύτερο νούμερο που διαιρεί το 100 είναι το 50).
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
