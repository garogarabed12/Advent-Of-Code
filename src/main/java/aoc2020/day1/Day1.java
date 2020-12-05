package aoc2020.day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Day1 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("./src/main/java/codeadvent/day1/dayOneInput.txt");

        List<Integer> input = Files.lines(path)
                .map(Integer::parseInt)
                .filter(x -> x <= 2020)
                .collect(Collectors.toList());

        int size = input.size();

        // Part 1 and 2 together here.
        for (int i = 0; i < size - 2; i++) {
            for (int j = i + 1; j < size - 1; j++) {
                for (int k = j + 1; k < size; k++) {
                    if (input.get(i) + input.get(j) + input.get(k) == 2020) {
                        System.out.println("FOUND! The numbers are: " + input.get(j) + " and " + input.get(i)
                                + " and " + input.get(k)
                                + " and their product is: " + input.get(j) * input.get(i) * input.get(k));
                    }
                }
            }
        }
    }
}
