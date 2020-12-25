package aoc2020.day10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Day10 {
    public static void main(String[] args) throws IOException {
        System.out.println("Part 1:");

        Path path = Paths.get("src/main/java/aoc2020/day10/DayTenInput.txt");
        List<Integer> numbers = Files.lines(path)
                .map(Integer::valueOf)
                .sorted()
                .collect(Collectors.toList());

        JoltageDifferencesCalculator joltageDifferencesCalculator = new JoltageDifferencesCalculator(numbers);
        joltageDifferencesCalculator.calculateJoltDifferences();

        int differenceOneCounter = joltageDifferencesCalculator.getDifferenceOneCounter();
        System.out.println("differenceOneCounter = " + differenceOneCounter);

        int differenceThreeCounter = joltageDifferencesCalculator.getDifferenceThreeCounter();
        System.out.println("differenceThreeCounter = " + differenceThreeCounter);

        System.out.println("The number of 1-jolt differences multiplied by the number of 3-jolt differences is: " + differenceOneCounter * differenceThreeCounter);
    }
}
