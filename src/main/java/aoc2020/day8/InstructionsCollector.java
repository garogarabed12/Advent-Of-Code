package aoc2020.day8;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class InstructionsCollector {
    private final Map<Integer, Instruction> instructionsMap = new HashMap<>();
    AtomicInteger lineIndex = new AtomicInteger(1);

    public void reduce(String line) {
        String[] splitLine = line.split(" ");
        instructionsMap.put(lineIndex.get(), new Instruction(splitLine[0], Integer.parseInt(splitLine[1])));
        lineIndex.getAndIncrement();
    }

    public void join(InstructionsCollector that) {
        instructionsMap.putAll(that.instructionsMap);
    }

    public Map<Integer, Instruction> getInstructionsMap() {
        return instructionsMap;
    }
}
