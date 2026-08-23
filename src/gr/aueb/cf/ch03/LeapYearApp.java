package gr.aueb.cf.ch03;

import java.util.Scanner;

/**
 * Λαμβάνει ένα έτος από τον χρήστη και
 * δείχνει αν είναι δίσεκτο ή όχι.
 * Αν ένα έτος διαιρείται ακριβώς με το 4,
 * αλλά όχι ακριβώς με το 100, τότε είναι δίσεκτο.
 * Αν διαιρείται ακριβώς με το 100, ελέγχουμε αν διαιρείται ακριβώς με το 400.
 * Αν ναι, τότε είναι δίσεκτο.
 */

public class LeapYearApp {

    public static void main(String[] args) {

        // Δήλωση και Αρχικοποίηση Μεταβλητών
        Scanner scanner = new Scanner(System.in);
        int inputYear = 0;
        int remainder4 = 0;
        int remainder100 = 0;
        int remainder400 = 0;

        // Λογική - Εντολές
        while (true) {
            boolean isLeapYear = false;
            System.out.println("Παρακαλώ εισάγετε ένα έτος (πατήστε 0 για έξοδο):");
            inputYear = scanner.nextInt();

            if (inputYear == 0) {
                System.out.println("Ευχαριστούμε που επιλέξατε την εφαρμογή μας");
                break;
            }

            if (inputYear < 0) {
                System.out.println("Δεν μπορείτε να εισάγετε αρνητικό. Παρακαλώ ξαναπροσπαθήστε.");
                System.out.println();
                continue;
            }

            remainder4 = inputYear % 4;
            remainder100 = inputYear % 100;
            remainder400 = inputYear % 400;

            isLeapYear = (remainder4 == 0 && remainder100 != 0) || remainder400 == 0; // Δεν χρειάζεται if, βλέπε SnowingApp. Αν το RHS ισχύει, τότε ισχύει και το boolean στο LHS.

            // Εκτύπωση
            System.out.printf("Το έτος που εισάγατε είναι δίσεκτο: %b%n", isLeapYear); // Ενιαία εκτύπωση αποτελέσματος για όλα τα σενάρια (Κανόνας DRY). Η εκτύπωση γίνεται μόνο μία φορά εδώ στο τέλος.
            System.out.println();
            System.out.println("Ευχαριστούμε που επιλέξατε την εφαρμογή μας");
            break;
        }
    }
}
