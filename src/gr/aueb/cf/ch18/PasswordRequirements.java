package gr.aueb.cf.ch18;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordRequirements {

    public static void main(String[] args) {
        String passwordTest = "C0d1ngF@ctory10";

        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[#?!@$%^&*-]).{8,}$");
        Matcher matcher = pattern.matcher(passwordTest);

        System.out.println(matcher.matches());
    }
}
