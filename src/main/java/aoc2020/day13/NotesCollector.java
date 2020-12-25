package aoc2020.day13;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class NotesCollector {

    private Notes notes;
    private long earliestDepartureTimestamp;

    private final AtomicInteger atomicInteger = new AtomicInteger(1);

    public void reduce(String line) {
        if (atomicInteger.get() == 1) {
            earliestDepartureTimestamp = Long.parseLong(line);
            atomicInteger.getAndIncrement();
        }

        String[] splitBusIds = line.split(",");
        List<Integer> busIdsList = Arrays.stream(splitBusIds).filter(x -> !x.contains("x"))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        notes = new Notes(earliestDepartureTimestamp, busIdsList);
    }

    public void join(NotesCollector that) {
        this.notes = that.notes;
    }

    public Notes getNotes() {
        return notes;
    }
}
