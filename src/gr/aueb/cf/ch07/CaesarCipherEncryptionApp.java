package gr.aueb.cf.ch07;

import java.util.Scanner;

public class CaesarCipherEncryptionApp {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String userChoice = "";
        String caesarEncrypted = "";
        String caesarDecrypted = "";
        int cipherKey = 0;

        while (true) {
            System.out.println("Εισάγετε ένα ακέραιο κλειδί(για έξοδο πατήστε -1):");
            cipherKey = getInt();

            if (cipherKey == -1) {
                System.out.println("Έξοδος.");
                break;
            }

            if (cipherKey < 1 || cipherKey > 25) {
                System.out.println("Μη έγκυρη επιλογή. Παρακαλώ προσπαθήστε ξανά.");
                continue;
            }

            System.out.println("Εισάγετε μία λέξη για κρυπτογράφηση:");
            userChoice = getString();

            caesarEncrypted = caesarEncryption(userChoice, cipherKey);
            System.out.println("Η κρυπτογραφημένη λέξη είναι " + caesarEncrypted + ".");

            System.out.println();

            System.out.println("Εισάγετε μία λέξη για αποκρυπτογράφηση:");
            userChoice = getString();

            caesarDecrypted = caesarDecryption(userChoice, cipherKey);
            System.out.println("Η αποκρυπτογραφημένη λέξη είναι " + caesarDecrypted + ".");
        }

    }

    /**
     * Λαμβάνει έναν ακέραιο από τον χρήστη.
     * Σημείωση Υλοποίησης: Διαβάζουμε την είσοδο του χρήστη ως ολόκληρη
     * γραμμή (String) μέσω της scanner.nextLine() και έπειτα τη
     * μετατρέπουμε σε ακέραιο με την Integer.parseInt().
     * Αυτό γίνεται σκόπιμα για να αποφύγουμε το συχνό πρόβλημα του Scanner,
     * όπου η scanner.nextInt() αφήνει τον χαρακτήρα αλλαγής γραμμής (\n)
     * (το Enter) μέσα στον buffer, προκαλώντας παραλείψεις εισόδου σε επόμενες
     * κλήσεις της nextLine().
     * @return τον ακέραιο που εισήγαγε ο χρήστης
     */
    public static int getInt() {
        String lexeme = scanner.nextLine();
        return Integer.parseInt(lexeme);
    }

    /**
     * Λαμβάνει και επιστρέφει ένα String από τον χρήστη
     * @return το String που εισήγαγε ο χρήστης
     */
    public static String getString() {
        return scanner.nextLine();
    }

//    /**
//     * Λαμβάνει ένα String και ένα ακέραιο κλειδί και κάνει κρυπτογράφηση
//     * key λεξικογραφικά θέσεις
//     * @param s Το αρχικό String που θέλουμε να κρυπτογραφήσουμε.
//     * @param key Το ακέραιο κλειδί για να το πόσες θέσεις θα μετατοπίστεί
//     * @return Το νέο, κρυπτογραφημένο String.
//     */
//    public static String caesarEncryption(String s, int key) {
//        StringBuilder sb = new StringBuilder();
//
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
//                if ((s.charAt(i) + key) > 'Z') {
//                    sb.append((char)(('A' - 1) + ((s.charAt(i) + key) - 'Z')));
//                } else {
//                    sb.append((char)(s.charAt(i) + key));
//                }
//            } else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
//                if ((s.charAt(i) + key) > 'z') {
//                    sb.append((char)(('a' - 1) + ((s.charAt(i) + key) - 'z')));
//                } else {
//                    sb.append((char)(s.charAt(i) + key));
//                }
//            } else {
//                sb.append(s.charAt(i));
//            }
//        }
//        return sb.toString();
//    }
//
//    /**
//     * Λαμβάνει ένα String και ένα ακέραιο κλειδί και κάνει αποκρυπτογράφηση
//     * key λεξικογραφικά θέσεις
//     * @param s Το αρχικό String που θέλουμε να αποκρυπτογραφήσουμε.
//     * @param key Το ακέραιο κλειδί για να το πόσες θέσεις θα μετατοπίστεί
//     * @return Το νέο, αποκρυπτογραφημένο String.
//     */
//    public static String caesarDecryption(String s, int key) {
//        StringBuilder sb = new StringBuilder();
//
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
//                if ((s.charAt(i) - key) < 'A') {
//                    sb.append((char) (('Z' + 1) - ('A' - (s.charAt(i) - key))));
//                } else {
//                    sb.append((char)(s.charAt(i) - key));
//                }
//            } else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
//                if ((s.charAt(i) - key) < 'a') {
//                    sb.append((char) (('z' + 1) - ('a' - (s.charAt(i) - key))));
//                } else {
//                    sb.append((char)(s.charAt(i) - key));
//                }
//            } else {
//                sb.append(s.charAt(i));
//            }
//        }
//        return sb.toString();
//    }


    private static final int ALPHABET_SIZE = 26;

    /**
     * Κρυπτογραφεί ένα κείμενο σύμφωνα με τον Αλγόριθμο του Καίσαρα.
     *
     * @param text Το αρχικό κείμενο (plaintext).
     * @param key  Ο αριθμός θέσεων για τη δεξιά μετατόπιση.
     * @return Το κρυπτογραφημένο κείμενο (ciphertext).
     */
    public static String caesarEncryption(String text, int key) {
        StringBuilder sb = new StringBuilder();

        // Κανονικοποίηση του κλειδιού ώστε να είναι πάντα εντός ορίων του αλφαβήτου
        key = key % ALPHABET_SIZE;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                char shifted = (char) ('A' + (ch - 'A' + key) % ALPHABET_SIZE);
                sb.append(shifted);
            } else if (ch >= 'a' && ch <= 'z') {
                char shifted = (char) ('a' + (ch - 'a' + key) % ALPHABET_SIZE);
                sb.append(shifted);
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    /**
     * Αποκρυπτογραφεί ένα κείμενο που έχει κρυπτογραφηθεί με τον Αλγόριθμο του Καίσαρα.
     *
     * Σημείωση Υλοποίησης: Η αποκρυπτογράφηση είναι ουσιαστικά μια κρυπτογράφηση
     * με αντίστροφη φορά. Υπολογίζουμε το "συμπληρωματικό" κλειδί και καλούμε
     * την caesarEncryption.
     *
     * @param text Το κρυπτογραφημένο κείμενο (ciphertext).
     * @param key  Το κλειδί που χρησιμοποιήθηκε για την κρυπτογράφηση.
     * @return Το αρχικό, αποκρυπτογραφημένο κείμενο (plaintext).
     */
    public static String caesarDecryption(String text, int key) {
        // Υπολογισμός του αντίστροφου κλειδιού με χρήση της σταθεράς
        int decryptKey = (ALPHABET_SIZE - (key % ALPHABET_SIZE)) % ALPHABET_SIZE;

        return caesarEncryption(text, decryptKey);
    }
}
