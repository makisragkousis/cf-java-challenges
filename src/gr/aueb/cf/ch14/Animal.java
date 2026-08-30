package gr.aueb.cf.ch14;

/**
 * Βασική κλάση που αναπαριστά ένα ζώο.
 */
public class Animal {
    private String name;
    private int age;

    public Animal() {}

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Εκτυπώνει ένα γενικό μήνυμα ομιλίας για το ζώο.
     */
    public void speak() {
        System.out.println("I am an animal.");
    }

    /**
     * Επιστρέφει την αναπαράσταση του ζώου σε μορφή κειμένου.
     * @return ένα String που περιέχει το όνομα και την ηλικία.
     */
    @Override
    public String toString() {
        return "(" + name + ", " + age + ")";
    }
}
