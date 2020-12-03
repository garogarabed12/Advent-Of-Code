package codeadvent.day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class day2 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("./src/main/java/codeadvent/day2/dayTwoInput.txt");

        List<Password> passwords = Files.lines(path)
                .collect(PasswordCollector::new,
                        PasswordCollector::reduction,
                        PasswordCollector::join
                ).getPasswords();

        int size = passwords.size();
        System.out.println("size = " + size);

        long count1 = passwords.stream().filter(Password::isValid)
                .count();
        System.out.println("First validity count = " + count1);

        long count2 = passwords.stream().filter(Password::isValidV2).count();
        System.out.println("Second validity count = " + count2);
    }
}
