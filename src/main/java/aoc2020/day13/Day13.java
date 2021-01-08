package aoc2020.day13;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Day13 {
    public static void main(String[] args) throws IOException {
        System.out.println("Part 1:");

        Path path = Paths.get("src/main/java/aoc2020/day13/DayThirteenInput.txt");

        Notes notes = Files.lines(path)
                .collect(NotesCollector::new,
                        NotesCollector::reduce,
                        NotesCollector::join).getNotes();

        EarliestBusCalculator earliestBusCalculator = new EarliestBusCalculator(notes);
        long answer = earliestBusCalculator.calculateEarliestBusId();
        System.out.println("The answer is: " + answer);
        System.out.println("=================================");
        System.out.println("Part 2:");

        /*long result = earliestBusCalculator.calculateEarliestTimestampForPartTwo();
        System.out.println("result = " + result);*/
    }
}
