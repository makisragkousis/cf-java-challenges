package gr.aueb.cf.ch14;

/**
 * Κλάση που αναπαριστά μία γάτα. Κληρονομεί από την Animal.
 */
public class Cat extends Animal {

    public Cat() {}

    public Cat(String name, int age) {
        super(name, age);
    }

    /**
     * Εκτυπώνει το χαρακτηριστικό μήνυμα ομιλίας της γάτας.
     */
    @Override
    public void speak() {
        System.out.println("I am a cat.");
    }

    /**
     * Επιστρέφει την αναπαράσταση της γάτας σε μορφή κειμένου.
     * @return ένα String που περιέχει το όνομα και την ηλικία της γάτας.
     */
    @Override
    public String toString() {
        return "(" + getName() + ", " + getAge() + ")";
    }
}
