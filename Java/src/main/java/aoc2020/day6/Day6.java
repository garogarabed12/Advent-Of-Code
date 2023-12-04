package aoc2020.day6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Day6 {
    public static void main(String[] args) throws IOException {
        System.out.println("Part 1:");
        Path path = Paths.get("./src/main/java/aoc2020/day6/daySixInput.txt");
        List<String> lines = Files.lines(path).collect(Collectors.toList());

        QuestionsCounter questionsCounter = new QuestionsCounter();
        questionsCounter.calculateV1(lines);

        System.out.print("The sum of the number of questions to which anyone answered \"yes\" is: ");
        System.out.println(questionsCounter.getYesAnswersCounter());

        System.out.println("================================");
        System.out.println("Part 2");

        questionsCounter.calculateV2(lines);

        System.out.print("The sum of the number of questions to which everyone answered \"yes\" is: ");
        System.out.println(questionsCounter.getYesAnswersCounter());
    }
}
