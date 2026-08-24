package gr.aueb.cf.ch04;

import java.util.Scanner;

/**
 * Λαμβάνει έναν αριθμό από το 1 έως και το 7
 * επιστρέφει το αντίστοιχο όνομα της εβδομάδας
 * π.χ. 1 -> Δευτέρα.
 */

public class DayNameApp {

    public static void main(String[] args) {

        //Δήλωση και Αρχικοποίηση Μεταβλητών
        Scanner scanner = new Scanner(System.in);
        int userChoice = 0;

        //Λογική - Εντολές
        System.out.println("Εισάγετε έναν αριθμό από 1-7:");
        userChoice = scanner.nextInt();

//        switch (userChoice) {
//
//            case 1:
//                System.out.println("Δευτέρα");
//                break;
//
//            case 2:
//                System.out.println("Τρίτη");
//                break;
//
//            case 3:
//                System.out.println("Τετάρτη");
//                break;
//
//            case 4:
//                System.out.println("Πέμπτη");
//                break;
//
//            case 5:
//                System.out.println("Παρασκευή");
//                break;
//
//            case 6:
//                System.out.println("Σάββατο");
//                break;
//
//            case 7:
//                System.out.println("Κυριακή");
//                break;
//
//            default:
//                System.out.println("Μη έγκυρη επιλογή. Παρακαλώ προσπαθήστε ξανά.");
//        }

        switch (userChoice) {

            case 1 -> System.out.println("Δευτέρα");
            case 2 -> System.out.println("Τρίτη");
            case 3 -> System.out.println("Τετάρτη");
            case 4 -> System.out.println("Πέμπτη");
            case 5 -> System.out.println("Παρασκευή");
            case 6 -> System.out.println("Σάββατο");
            case 7 -> System.out.println("Κυριακή");
            default -> System.out.println("Μη έγκυρη επιλογή. Παρακαλώ προσπαθήστε ξανά.");
        }
    }
}
