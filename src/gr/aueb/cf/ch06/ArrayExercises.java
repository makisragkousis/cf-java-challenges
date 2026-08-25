package gr.aueb.cf.ch06;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Εμφανίζει ένα μενού και αναλόγως την επιλογή του χρήστη
 * πραγματοποιείται η αντίστοιχη επιλογή του πίνακα,
 * μέσω μεθόδων.
 */

public class ArrayExercises {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int userChoice = 0;
        final int EXIT = 6;

        int[] exampleNumbers = {2, -5, 8, 2, 10, 3};

        while (true) {
            printMenu();

            userChoice = getInt();

            if (userChoice < 0 || userChoice > 6) {
                System.out.println("Μη έγκυρη επιλογή. Παρακαλώ προσπαθήστε ξανά.");
                continue;
            }

            if (userChoice == EXIT) {
                System.out.println("Έξοδος.");
                break;
            }

            getChoice(userChoice, exampleNumbers);
        }
    }

    /**
     * Επιστρέφει ένα μενού με 5 επιλογές για να επιλέξει ο χρήστης
     */
    static public void printMenu() {
        System.out.println("""
                Επιλέξτε μία απί τις παρακάτω επιλογές:
                1. Μέτρηση Εμφανίσεων Στοιχείου.
                2. Φιλτράρισμα των Ζυγών. (επιστρέφει void, μόνο εκτύπωση των ζυγών)
                3. Mapping κάθε στοιχείου του πίνακα με το διπλάσιο. (η μέθοδος επιστρέφει πίνακα)
                4. Έλεγχος αν υπάρχει έστω ένας θετικός αριθμός. (η μέθοδος πρέπει να επιστρέφει boolean)
                5. Έλεγχος αν όλα τα στοιχεία του πίνακα είναι θετικοί. (η μέθοδος πρέπει να επιστρέφει boolean)
                6. Έξοδος""");
    }

    /**
     * Λαμβάνει έναν ακέραιο από τον χρήστη
     * @return τον ακέραιο
     */
    public static int getInt() {
        return scanner.nextInt();
    }

    /**
     * 1) Βρίσκει τον αριθμό των εμφανίσεων ενός στοιχείου
     * @param arr ο πίνακας υπό εξέταση
     * @return τον αριθμό των εμφανίσεων του στοιχείου
     */
    public static int getElementCount(int[] arr, int target) {
        if (arr == null) return -1;
        int count = 0;

        for (int el : arr) {
            if (el == target) {
                count++;
            }
        }
        return count;
    }

    /**
     * 2) Επιστρέφει μόνο τους ζυγούς αριθμούς ενός πίνακα
     * @param arr ο πίνακας τον οποίο θα ψάξουμε για ζυγούς
     */
    public static void getEvenNumbers(int[] arr) {
        if (arr == null) return;

        for (int el : arr) {
            if (el % 2 == 0) {
                System.out.print(el + " ");
            }
        }
        System.out.println();
    }

    /**
     * 3) Παίρνει έναν πίνακα και επιστρέφει έναν νέο με στοιχεία του αρχικού διπλασιασμένα
     * @param arr ο αρχικός πίνακας
     * @return ο νέος πίνακας με τα στοιχεία του αρχικού διπλασιασμένα
     */
    public static int[] getDouble(int[] arr) {
        if (arr == null || arr.length == 0) return new int[0];

        int[] doubledNumbers = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            doubledNumbers[i] = arr[i] * 2;
        }
        return doubledNumbers;
    }

    /**
     * 4) Ελέγχει αν υπάρχει έστω και ένας θετικός αριθμός σε έναν πίνακα
     * @param arr ο πίνακας υπό εξέταση
     * @return true αν βρεθεί έστω και ένας θετικός αριθμός, false αν δε βρεθεί
     */
    public static boolean isAnyPositive(int[] arr) {
        if (arr == null) return false;

        for (int el : arr) {
            if (el > 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * 5) Ελέγχει αν όλα τα στοιχεία σε έναν πίνακα είναι θετικοί, ψάχνοντας αν υπάρχει έστω και ένας αρνητικός
     * @param arr ο πίνακας υπό εξέταση
     * @return true αν δεν υπάρχει κανένας αρνητικός, false αν υπάρχει
     */
    public static boolean areAllPositive(int[] arr) {
        if (arr == null || arr.length == 0) return false;

        for (int el : arr) {
            if (el <= 0) {
                return false; // early exit
            }
        }
        return true;
    }

    public static void getChoice(int userChoice, int[] arr) {
        switch (userChoice) {
            case 1 -> {
                System.out.println("Εισάγετε έναν αριθμό για αναζήτηση εντός του πίνακα:");
                int target = getInt();
                System.out.println("Ο αριθμός υπάρχει " + getElementCount(arr, target) + " φορές.");
            }
            case 2 -> getEvenNumbers(arr);
            case 3 -> System.out.println(Arrays.toString(getDouble(arr)));
            case 4 -> System.out.println(isAnyPositive(arr));
            case 5 -> System.out.println(areAllPositive(arr));
            default -> System.out.println("Μη έγκυρη επιλογή. Παρακαλώ προσπαθήστε ξανά.");
        }
    }
}
