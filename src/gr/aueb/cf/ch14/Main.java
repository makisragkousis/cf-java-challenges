package gr.aueb.cf.ch14;

/**
 * Η κύρια κλάση (Main) για την εκτέλεση και τον έλεγχο
 * της πολυμορφικής συμπεριφοράς των ζώων.
 */
public class Main {

    public static void main(String[] args) {
        Animal animal = new Animal("Άγνωστο Ζώο", 5);
        Animal dog = new Dog("Ρεξ", 3);
        Animal cat = new Cat("Γκάρφιλντ", 4);

        doPrint(animal);
        doPrint(dog);
        doPrint(cat);

        System.out.println();

        doSpeak(animal);
        doSpeak(dog);
        doSpeak(cat);
    }

    /**
     * Πολυμορφική μέθοδος που δέχεται οποιοδήποτε αντικείμενο τύπου Animal
     * (ή υποκλάσης του) και καλεί τη μέθοδο speak() που του αντιστοιχεί.
     * @param animal το ζώο που θα "μιλήσει".
     */
    public static void doSpeak(Animal animal) {
        animal.speak();
    }

    /**
     * Πολυμορφική μέθοδος που εκτυπώνει τα στοιχεία οποιουδήποτε ζώου.
     * Καλεί δυναμικά την κατάλληλη toString() ανάλογα με τον τύπο του αντικειμένου.
     * @param animal το ζώο του οποίου τα στοιχεία θα εκτυπωθούν.
     */
    public static void doPrint(Animal animal) {
        System.out.println(animal.toString());
    }
}
