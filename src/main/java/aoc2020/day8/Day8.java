package aoc2020.day8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Day8 {
    public static void main(String[] args) throws IOException {
        System.out.println("Part 1:");

        Path path = Paths.get("./src/main/java/aoc2020/day8/DayEightInput.txt");
        Map<Integer, Instruction> instructionsMap = Files.lines(path).collect(
                InstructionsCollector::new,
                InstructionsCollector::reduce,
                InstructionsCollector::join).getInstructionsMap();

        OperationsManager operationsManager = new OperationsManager(instructionsMap);
        operationsManager.executeOperationsUntilACycleIsFound();
    }
}
