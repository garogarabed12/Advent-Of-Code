package codeadvent.day2;

import java.util.ArrayList;
import java.util.List;

public class PasswordCollector {

    private final List<Password> passwords;

    public PasswordCollector() {
        passwords = new ArrayList<>();
    }

    public void reduction(String line) {
        String[] tokens = line.split(" ");
        String nums = tokens[0];
        String letterString = tokens[1];
        String pass = tokens[2];
        String[] numTokens = nums.split("-");
        int min = Integer.parseInt(numTokens[0]);
        int max = Integer.parseInt(numTokens[1]);
        char letter = letterString.charAt(0);
        passwords.add( new Password(
                min, max, letter, pass
        ));
    }

    public void join(PasswordCollector that) {
        passwords.addAll(that.passwords);
    }

    public List<Password> getPasswords() {
        return passwords;
    }
}
