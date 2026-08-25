package gr.aueb.cf.ch05;

import java.util.Scanner;

/**
 * Εμφανίζει ένα μενού με 6 επιλογές,
 * ο χρήστης εισάγει μία επιλογή και το σύστημα τυπώνει
 * την ανάλογη μορφή από n(τα δίνει ο χρήστης) *.
 */

public class StarsMethodApp {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int menuChoice = 0;
        int starsChoice = 0;
        final int EXIT = 6;

        while (true) {
            printMenu();
            menuChoice = inputInt();

            if (menuChoice == EXIT) {
                System.out.println("Έξοδος.");
                break;
            }

            if (!isChoiceValid(menuChoice)) {
                System.out.println("Μη έγκυρη επιλογή. Παρακαλώ προσπαθήστε ξανά.");
                continue;
            }

            System.out.println("Εισάγετε τα αστεράκια(ακέραιο αριθμό):");
            starsChoice = inputInt();

            userChoice(menuChoice, starsChoice);
        }

    }

    /**
     * Τυπώνει το μενού
     */
    public static void printMenu() {

        System.out.println("""
                1. Εμφάνισε n αστεράκια οριζόντια.
                2. Εμφάνισε n αστεράκια κάθετα.
                3. Εμφάνισε n γραμμές με n αστεράκια.
                4. Εμφάνισε n γραμμές με αστεράκια 1 έως n.
                5. Εμφάνισε n γραμμές με αστεράκια n έως 1.
                6. Έξοδος από το πρόγραμμα.
                Δώσε επιλογή:""");
    }

    /**
     * Λαμβάνει έναν ακέραιο από τον χρήστη
     * @return Ο ακέραιος που εισάγει ο χρήστης
     */
    public static int inputInt() {
        return scanner.nextInt();
    }

    /**
     * Για να ελέγξει αν η επιλογή ακεραίου είναι νόμιμη
     * @param choice ο ακέραιος
     * @return true αν τηρούνται οι προϋποθέσεις, αλλιώς false
     */
    public static boolean isChoiceValid(int choice) {
        return choice >= 1 && choice <= 6;
    }

    /**
     * Τυπώνει όσα * δηλώσει ο χρήστης οριζοντίως
     * @param stars τα * που δηλώνει ο χρήστης
     */
    public static void starsHorizontally(int stars) {
        for (int i = 1; i <= stars; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    /**
     * Τυπώνει όσα * δηλώσει ο χρήστης καθέτως
     * @param stars τα * που δηλώνει ο χρήστης
     */
    public static void starsVertically(int stars) {
        for (int i = 1; i <= stars; i++) {
            System.out.println("*");
        }
    }

    /**
     * Τυπώνει n γραμμές με n *
     * @param stars τα * που δηλώνει ο χρήστης
     */
    public static void starsBox(int stars) {
        for (int i = 1; i <= stars; i++) {
            starsHorizontally(stars);
        }
    }

    /**
     * Τυπώνει n γραμμές με * 1 έως n
     * @param stars τα * που δηλώνει ο χρήστης
     */
    public static void starsAscend(int stars) {
        for (int i = 1; i <= stars; i++) {
            starsHorizontally(i); //Το ίδιο με stars-(stars-i). To i σε κάθε iteration αυξάνεται και αντικατοπτρίζει το πόσα αστέρια θα μπουν στην εκάστοτε γραμμή.
        }
    }

    /**
     * Τυπώνει n γραμμές με * n έως 1
     * @param stars τα * που δηλώνει ο χρήστης
     */
    public static void starsDescend(int stars) {
        for (int i = 0; i <= (stars - 1); i++) {
            starsHorizontally(stars-i); // To i-1 σε κάθε iteration μειώνεται και αντικατοπτρίζει το πόσα αστέρια θα μπουν στην εκάστοτε γραμμή, ξεκινώντας από τα μέγιστα.
        }
    }

    /**
     * Ανάλογα την επιλογή του χρήστη, τυπώνει την κατάλληλη μορφή *
     * @param choice επιλογή του χρήστη στο printMenu
     */
    public static void userChoice(int choice, int stars) {
        switch (choice) {
            case 1 -> starsHorizontally(stars);
            case 2 -> starsVertically(stars);
            case 3 -> starsBox(stars);
            case 4 -> starsAscend(stars);
            case 5 -> starsDescend(stars);
            case 6 -> System.out.println("Έξοδος.");
            default -> System.out.println("Μη έγκυρη επιλογή. Παρακαλώ προσπαθήστε ξανά.");
        }
    }
}
