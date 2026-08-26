package gr.aueb.cf.ch07;

import java.util.Scanner;

/**
 * Δημιουργεί δύο μεθόδους, μία για κρυπτογράφηση και
 * μία για αποκρυπτογράφηση. Και οι δύο λαμβάνουν String.
 *
 * Η πρώτη κρυπτογραφεί αντικαθιστώντας κάθε χαρακτήρα του
 * String με τον λεξικογραφικά επόμενο (το Ζ γίνεται Α).
 *
 * Η δεύτερη λαμβάνει ως είσοδο ένα κρυπτογραφημένο String και το
 * αποκρυπτογραφεί, αντικαθιστώντας κάθε χαρακτήρα
 * του String με τον λεξικογραφικά προηγούμενο.
 */

public class EncryptionApp {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String userChoice = "";
        String encrypted = "";
        String decrypted = "";

        System.out.println("Εισάγετε μία λέξη για κρυπτογράφηση:");
        userChoice = getString();

        encrypted = encryption(userChoice);
        System.out.println("Η κρυπτογραφημένη λέξη είναι " + encrypted + ".");

        System.out.println();

        System.out.println("Εισάγετε μία λέξη για αποκρυπτογράφηση:");
        userChoice = getString();

        decrypted = decryption(userChoice);
        System.out.println("Η αποκρυπτογραφημένη λέξη είναι " + decrypted + ".");
    }

    /**
     * Λαμβάνει και επιστρέφει ένα String από τον χρήστη
     * @return το String που εισήγαγε ο χρήστης
     */
    public static String getString() {
        return scanner.nextLine();
    }

    /**
     * Κρυπτογραφεί ένα κείμενο αντικαθιστώντας κάθε χαρακτήρα του
     * με τον λεξικογραφικά επόμενο (π.χ. το A γίνεται B, το Z γίνεται A).
     *
     * @param s Το αρχικό String που θέλουμε να κρυπτογραφήσουμε.
     * @return  Το νέο, κρυπτογραφημένο String.
     */
    public static String encryption(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'Z') {
                sb.append('A');
            } else if (s.charAt(i) == 'z') {
                sb.append('a');
            } else {
                sb.append( (char) (s.charAt(i) + 1));
            }
        }
        return sb.toString();
    }

    /**
     * Αποκρυπτογραφεί ένα κείμενο αντικαθιστώντας κάθε χαρακτήρα του
     * με τον λεξικογραφικά προηγούμενο (π.χ. το B γίνεται A, το A γίνεται Z).
     *
     * @param s Το κρυπτογραφημένο String που θέλουμε να αποκρυπτογραφήσουμε.
     * @return  Το νέο, αποκρυπτογραφημένο String.
     */
    public static String decryption(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                sb.append('Z');
            } else if (s.charAt(i) == 'a') {
                sb.append('z');
            } else {
                sb.append((char) (s.charAt(i) - 1));
            }
        }
        return sb.toString();
    }
}
