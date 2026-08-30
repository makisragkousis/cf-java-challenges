package gr.aueb.cf.ch14;

/**
 * Κλάση που αναπαριστά έναν σκύλο. Κληρονομεί από την Animal.
 */
public class Dog extends Animal {

    public Dog() {}

    public Dog(String name, int age) {
        super(name, age);
    }

    /**
     * Εκτυπώνει το χαρακτηριστικό μήνυμα ομιλίας του σκύλου.
     */
    @Override
    public void speak() {
        System.out.println("I am a dog.");
    }

    /**
     * Επιστρέφει την αναπαράσταση του σκύλου σε μορφή κειμένου.
     * @return ένα String που περιέχει το όνομα και την ηλικία του σκύλου.
     */
    @Override
    public String toString() {
        return "(" + getName() + ", " + getAge() + ")";
    }
}
