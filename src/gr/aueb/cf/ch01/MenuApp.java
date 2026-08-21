package gr.aueb.cf.ch01;

/**
 * Τυπώνει ένα menu, με συγκεκριμένες επιλογές.
 */
public class MenuApp {

    public static void main(String[] args) {

        // Δήλωση και Αρχικοποίηση Μεταβλητών
        String headliner = "Επιλέξτε μία από τις παρακάτω επιλογές:";
        String option1 = "1. Εισαγωγή";
        String option2 = "2. Διαγραφή";
        String option3 = "3. Αναζήτηση";
        String option4 = "4. Ενημέρωση";
        String option5 = "5. Έξοδος";
        String underliner = "Δώστε αριθμό επιλογής:";

        // Εκτύπωση menu

        System.out.printf("%s%n%n%s%n%s%n%s%n%s%n%s%n%n%s%n", headliner, option1, option2, option3,
                option4, option5, underliner);
    }
}
