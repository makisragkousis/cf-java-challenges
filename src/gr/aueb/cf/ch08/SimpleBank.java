package gr.aueb.cf.ch08;

/**
 * Προσομοιώνει τις διαδικασίες κατάθεσης και ανάληψης χρημάτων
 * μιας τράπεζας, μέσω της χρήσης δύο μεθόδων. Οι μέθοδοι κάνουν
 * throw Exception και rethrow στον caller(main).
 */

import java.time.LocalDateTime;
import java.util.Scanner;

public class SimpleBank {
    static double balance = 500;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        double amount = 0.0;
        int userChoice = 0;
        final int EXIT = 4;

        while (true) {
            printMenu();
            userChoice = getInt();

            if (userChoice == EXIT) {
                System.out.println("Ευχαριστούμε που χρησιμοποιήσατε την υπηρεσία μας.");
                break;
            }

            if (userChoice < 1 || userChoice > 4) {
                System.out.println("Μη έγκυρη επιλογή. Παρακαλώ προσπαθήστε ξανά.");
                continue;
            }

            try {
                getUserChoice(userChoice, amount);
            } catch (Exception e) {
                System.out.println("Η συναλλαγή απέτυχε: " + e.getMessage());
                // Δεν υπάρχει break εδώ, άρα η λούπα θα συνεχίσει κανονικά να βγάζει το μενού!
            }
        }
    }


    public static void printMenu() {
        System.out.println("""
                Παρακαλώ επιλέξτε μία από τις παρακάτω επιλογές:
                1) Κατάθεση.
                2) Ανάληψη.
                3) Υπόλοιπο.
                4) Έξοδος.""");
    }

    /**
     * Λαμβάνει και επιστρέφει έναν ακέραιο αριθμό από τον χρήστη,
     * ο οποίος χρησιμοποιείται κυρίως για την πλοήγηση στο μενού.
     *
     * Η μέθοδος διαχειρίζεται εσωτερικά τυχόν InputMismatchException.
     * Σε περίπτωση που ο χρήστης εισάγει μη έγκυρους χαρακτήρες (π.χ. γράμματα),
     * δεν τερματίζεται το πρόγραμμα, αλλά εμφανίζεται μήνυμα σφάλματος
     * και η διαδικασία επαναλαμβάνεται μέχρι να δοθεί έγκυρος ακέραιος.
     *
     * @return Την έγκυρη ακέραιη επιλογή του χρήστη.
     */
    public static int getInt() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("\n*** Σφάλμα: Πρέπει να εισάγετε αριθμό! Προσπαθήστε ξανά. ***\n");
                scanner.nextLine();
            }
        }
    }

    /**
     * Λαμβάνει και επιστρέφει έναν αριθμό κινητής υποδιαστολής (double)
     * από τον χρήστη, ο οποίος αντιστοιχεί στο ποσό ανάληψης ή κατάθεσης.
     *
     * Η μέθοδος διαχειρίζεται εσωτερικά τυχόν InputMismatchException.
     * Σε περίπτωση που ο χρήστης εισάγει μη έγκυρη τιμή (π.χ. κείμενο
     * αντί για αριθμό), καθαρίζει τον buffer του Scanner, εμφανίζει
     * μήνυμα σφάλματος και του ζητάει νέα εισαγωγή.
     *
     * @return Το έγκυρο ποσό (double) που εισήγαγε ο χρήστης.
     */
    public static double getDouble() {
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (java.util.InputMismatchException e) {
                System.out.println("\n*** Σφάλμα: Πρέπει να εισάγετε αριθμό! Προσπαθήστε ξανά. ***\n");
                scanner.nextLine();
            }
        }
    }

    /**
     * Πραγματοποιεί την αριθμητική πράξη για τον υπολογισμό
     * της κατάθεσης. Δίνει Exception αν η διαδικασία είναι μη δυνατή
     * @param amount το ποσό που θα κατατεθεί
     * @throws Exception αν το ποσό που κατατεθεί είναι <= 0, δίνει Exception
     *                   και σταματάει η διαδικασία
     */
    public static void deposit(double amount) throws Exception {
        try {
            if (amount <= 0) {
                throw new Exception("Το ποσό κατάθεσης δεν μπορεί να είναι αρνητικό ή μηδέν(0).");
            }
            balance += amount;
            System.out.printf("Το υπόλοιπο σας είναι: %.2f ευρώ.%n", balance);
        } catch (Exception e) {
            System.err.println(LocalDateTime.now() + e.getMessage());
            throw e;
        }
    }

    /**
     * Πραγματοποιεί την αριθμητική πράξη για τον υπολογισμό
     * της ανάληψης. Δίνει Exception αν η διαδικασία είναι μη δυνατή
     * @param amount το ποσό που θα αναληφθεί
     * @throws Exception αν το ποσό που κατατεθεί είναι <= 0, δίνει Exception
     *                   και σταματάει η διαδικασία ή αν το υπόλοιπο είναι 0,
     *                   πάλι δίνει Exception και σταματάει την διαδικασία
     */
    public static void withdraw(double amount) throws Exception {
        try {
            if (amount <= 0) {
                throw new Exception("Το ποσό ανάληψης δεν μπορεί να είναι αρνητικό ή μηδέν(0).");

            } else if (amount > balance) {
                throw new Exception("Ανεπαρκές υπόλοιπο για την πραγματοποίηση της ανάληψης.");
            }
            balance -= amount;
            System.out.printf("Το υπόλοιπο σας είναι: %.2f ευρώ.%n", balance);
        } catch (Exception e) {
            System.err.println(LocalDateTime.now() + e.getMessage());
            throw e;
        }
    }

    public static void getUserChoice(int choice, double amount) throws Exception {
        switch (choice) {
            case 1 -> {
                System.out.println("Παρακαλώ εισάγετε ένα ποσό");
                amount = getDouble();
                deposit(amount);
            }
            case 2 -> {
                System.out.println("Παρακαλώ εισάγετε ένα ποσό");
                amount = getDouble();
                withdraw(amount);
            }
            case 3 -> System.out.printf("Το υπόλοιπο σας είναι: %.2f ευρώ.%n", balance);
            default -> System.out.println("Μη έγκυρη επιλογή. Παρακαλώ προσπαθήστε ξανά.");
        }
    }
}
