package gr.aueb.cf.ch02;

import java.util.Scanner;

/**
 * Διαβάζει την απόσταση που δίνεται και
 * υπολογίζει το συνολικό κόστος μια διαδρομής ταξί,
 * σταθερής τιμής εκκίνησης ίσης με 300 λεπτά του ευρώ,
 * όπου κάθε επιπλέον km ισούται με 74 λεπτά του ευρώ .
 */
public class TaxiApp {

    public static void main(String[] args) {

        // Δήλωση και Αρχικοποίηση Μεταβλητών
        Scanner scanner = new Scanner(System.in);
        final int STARTING_COST = 300; // Πάντα η τιμή εκκίνησης θα είναι 300.
        final int COST_PER_KM = 74; // Πάντα το κόστος του km θα είναι 74.
        int distance = 0;
        int totalCost = 0;

        // Λογική - Εντολές
        System.out.println("Παρακαλώ εισάγετε την απόσταση σε χιλιόμετρα:");
        distance = scanner.nextInt();
        totalCost = (distance * COST_PER_KM) + STARTING_COST;

        // Εκτύπωση
        System.out.printf("Κόστος: %d ευρώ και %d λεπτά.%n", totalCost / 100, totalCost % 100);

    }
}
