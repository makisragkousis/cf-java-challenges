package gr.aueb.cf.ch16;

public interface IPrintable {

    default void print() {
        System.out.println("Printing...");
    }
}
