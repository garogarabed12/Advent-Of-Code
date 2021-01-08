package aoc2020.day8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OperationsManager {

    int currentInstructionsIndex = 1;
    int previousInstructionsIndex = 0;
    private int accumulator = 0;
    List<Integer> executedInstructions = new ArrayList<>();

    private final Map<Integer, Instruction> instructionsMap;

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

    private boolean noCircleWasFound() {
        return executedInstructions.containsAll(instructionsMap.keySet());
    }

    private void executeInstruction(Instruction instruction) {

        switch (instruction.getOperation()) {
            case "acc":
                previousInstructionsIndex = currentInstructionsIndex;
                accumulator += instruction.getArgument();
                currentInstructionsIndex++;
                break;

            case "jmp":
                previousInstructionsIndex = currentInstructionsIndex;
                currentInstructionsIndex += instruction.getArgument();
                break;

            case "nop":
                previousInstructionsIndex = currentInstructionsIndex;
                currentInstructionsIndex++;
                break;
        }
    }

    public boolean circleIsFoundAfterExecution() {
        while (true) {
            Instruction currentInstruction = instructionsMap.get(currentInstructionsIndex);

            if (!cycleIsFound(currentInstructionsIndex)) {
                executedInstructions.add(currentInstructionsIndex);
                executeInstruction(currentInstruction);
                if(noCircleWasFound()) {
                    return false;
                }
            } else {
                return true;
            }
        }
    }

    private boolean cycleIsFound(int currentInstructionsIndex) {
        return executedInstructions.contains(currentInstructionsIndex);
    }

    public void removeCircle() {
        //List<Instruction> instructions = new ArrayList<>(instructionsMap.values());
        for(int i=1; i<=9; i++) {
            Instruction instruction = instructionsMap.get(i);
            if(instruction.getOperation().equals("nop")) {
                if(changingNopToJmpWorked(i, instruction)) {
                    System.out.println("Cycle was removed and the accumulator has the value of: " + accumulator);
                    instructionsMap.entrySet().forEach(System.out::println);
                    break;
                } else {
                    instructionsMap.put(i, new Instruction(instruction.getOperation(), instruction.getArgument()));
                }
            }
            else if(instruction.getOperation().equals("jmp")) {
                if(changingJmpToNopWorked(i, instruction)) {
                    System.out.println("Cycle was removed and the accumulator has the value of: " + accumulator);
                    instructionsMap.entrySet().forEach(System.out::println);
                    break;
                } else {
                    instructionsMap.put(i, new Instruction(instruction.getOperation(), instruction.getArgument()));
                }
            }
        }
    }

    private boolean changingJmpToNopWorked(int i, Instruction instruction) {
        instructionsMap.put(i, new Instruction("nop", instruction.getArgument()));
        resetOperationsManager();
        return !circleIsFoundAfterExecution();
    }

    private boolean changingNopToJmpWorked(int i, Instruction instruction) {
        instructionsMap.put(i, new Instruction("jmp", instruction.getArgument()));
        resetOperationsManager();
        return !circleIsFoundAfterExecution();
    }

    private void resetOperationsManager() {
        accumulator = 0;
        currentInstructionsIndex = 1;
        previousInstructionsIndex = 0;
        executedInstructions.clear();
    }
}
