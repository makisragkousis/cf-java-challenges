package gr.aueb.cf.ch11;

public class Main {

    public static void main(String[] args) {
        User user = new User(1L, "Firstname", "Lastname");

        System.out.println("{" + user.getId() + ", " + user.getFirstname() + ", " + user.getLastname() + "}");
    }
}
