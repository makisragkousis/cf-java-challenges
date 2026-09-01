package gr.aueb.cf.ch17;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ModernCharacterStats {

    public static void main(String[] args) {
        Path filePath = Path.of("C:/tmp/file.txt");
        LinkedList<Character> charList = new LinkedList<>();

        if (!Files.exists(filePath)) {
            System.out.println("File not found: " + filePath);
            return;
        }

        try {
            // 1. Διάβασμα του αρχείου και γέμισμα της LinkedList
            String content = Files.readString(filePath);
            for (char ch : content.toCharArray()) {
                if (ch != '\r' && ch != '\n') {
                    charList.add(ch);
                }
            }

            int totalChars = charList.size();
            if (totalChars == 0) {
                System.out.println("Το αρχείο είναι άδειο.");
                return;
            }

            // 2. Παίρνουμε τη λίστα, την κάνουμε Stream και ομαδοποιούμε τους χαρακτήρες μετρώντας τους
            Map<Character, Long> frequencies = charList.stream()
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            // 3. Ταξινόμηση ανά Χαρακτήρα (Ascending)
            System.out.println("--- Ανά χαρακτήρα (ascending) ---");
            frequencies.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey()) // Ταξινόμηση βάσει Κλειδιού (Χαρακτήρα)
                    .forEach(entry -> printStats(entry.getKey(), entry.getValue(), totalChars));

            // 4. Ταξινόμηση ανά Συχνότητα/Ποσοστό (Descending)
            System.out.println("\n--- Ανά ποσοστό (descending) ---");
            frequencies.entrySet().stream()
                    .sorted(Map.Entry.<Character, Long>comparingByValue().reversed()) // Ταξινόμηση βάσει Τιμής (Συχνότητας) Αντίστροφα
                    .forEach(entry -> printStats(entry.getKey(), entry.getValue(), totalChars));

        } catch (IOException e) {
            System.err.println("Σφάλμα κατά την ανάγνωση του αρχείου: " + e.getMessage());
        }
    }

    // Μια βοηθητική μέθοδος για καθαρότερο κώδικα στην εκτύπωση
    private static void printStats(char ch, long count, int totalChars) {
        double percentage = ((double) count / totalChars) * 100;
        System.out.printf("Value: %c - Frequency: %.2f%%\n", ch, percentage);
    }
}


//### Η Λογική της Μοντέρνας Προσέγγισης (Η Αντιστοιχία)
//
//        1. Αντί για την κλάση ListNode και τα if/else (Έλεγχος αν υπάρχει το γράμμα):
//Tο Collectors.groupingBy(..., Collectors.counting()). Αυτό κάνει ακριβώς την ίδια δουλειά:
//παίρνει τη λίστα των χαρακτήρων και φτιάχνει ένα Λεξικό (`Map`). Αν το γράμμα δεν υπάρχει το βάζει με τιμή
// 1. Αν υπάρχει, του αυξάνει την τιμή. Όλα σε μία γραμμή, χωρίς καθόλου if/else.
//
//        2. Αντί για τα διπλά `for` loop του Selection Sort:
//Tο .sorted(...) των Streams. Δεν χρειάζεται να πούμε στη Java πώς να ταξινομήσει. Της λέμε απλώς τι θέλουμε:
//        .sorted(Map.Entry.comparingByKey()) : "Ταξινόμησε τα με βάση το κλειδί (το γράμμα)".
//        .sorted(Map.Entry.comparingByValue().reversed())` : "Ταξινόμησε τα με βάση την τιμή (το count) αλλά ανάποδα (φθίνουσα)".
//Η Java από πίσω χρησιμοποιεί έναν εξαιρετικά γρήγορο αλγόριθμο (TimSort) που είναι πολύ πιο αποδοτικός από τον Selection Sort.
//
//        3. Αντί για τη χειροκίνητη μέθοδο traverse:
//Tο .forEach(...). Αυτό απλώς περνάει από το ταξινομημένο αποτέλεσμα και για κάθε στοιχείο του καλεί την printStats().
//
//        H μοντέρνα Java επικεντρώνεται στο "Τι θέλω να κάνω" (Δηλωτικός προγραμματισμός) και όχι στο
//        "Πώς ακριβώς θα το κάνω βήμα-βήμα" (Προστακτικός προγραμματισμός).
