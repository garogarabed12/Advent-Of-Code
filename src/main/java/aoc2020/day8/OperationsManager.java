package aoc2020.day8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OperationsManager {
    private int accumulator = 0;
    private final Map<Integer, Instruction> instructionsMap;

    int currentInstructionsIndex = 1;
    int previousIntructionsIndex = 0;
    List<Integer> executedInstructions = new ArrayList<>();

    public OperationsManager(Map<Integer, Instruction> instructionsMap) {
        this.instructionsMap = instructionsMap;
    }

    public void executeOperationsUntilACycleIsFound() {
        while (true) {
            Instruction currentInstruction = instructionsMap.get(currentInstructionsIndex);

            if (!cycleIsFound(currentInstructionsIndex)) {
                executedInstructions.add(currentInstructionsIndex);
                executeInstruction(currentInstruction);
            } else {
                System.out.println("Cycle was found and the accumulator's value is: " + accumulator);
                break;
            }
        }
    }

    private void executeInstruction(Instruction instruction) {

        switch (instruction.getOperation()) {
            case "acc":
                previousIntructionsIndex = currentInstructionsIndex;
                accumulator += instruction.getArgument();
                currentInstructionsIndex++;
                break;

            case "jmp":
                previousIntructionsIndex = currentInstructionsIndex;
                currentInstructionsIndex += instruction.getArgument();
                break;

            case "nop":
                previousIntructionsIndex = currentInstructionsIndex;
                currentInstructionsIndex++;
                break;
        }
    }

    private boolean cycleIsFound(int currentInstructionsIndex) {
        return executedInstructions.contains(currentInstructionsIndex);
    }
}
