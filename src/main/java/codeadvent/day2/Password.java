package codeadvent.day2;

public class Password {
    private final int min;
    private final int max;
    private final char letter;
    private final String pass;

    public Password(int min, int max, char letter, String pass) {
        this.min = min;
        this.max = max;
        this.letter = letter;
        this.pass = pass;
    }

    public static boolean isValid(Password password) {
        int letterCounter = 0;
        String pass = password.pass;
        for (int i = 0; i < pass.length(); i++) {
            if (pass.charAt(i) == password.letter) {
                letterCounter++;
            }
        }
        return letterCounter <= password.max
                && letterCounter >= password.min;
    }

    public static boolean isValidV2(Password password) {
        int firstPosition = password.min - 1;
        int secondPosition = password.max - 1;
        String pass = password.pass;
        return (pass.charAt(firstPosition) == password.letter
                && pass.charAt(secondPosition) != password.letter)
                ||  (pass.charAt(firstPosition) != password.letter
                && pass.charAt(secondPosition) == password.letter);
    }
}
