package aoc2020.day13;

import java.util.List;

public class Notes {

    private final long earliestDepartureTimestamp;
    private final List<Integer> busIds;

    public Notes(long earliestDepartureTimestamp, List<Integer> busIds) {
        this.earliestDepartureTimestamp = earliestDepartureTimestamp;
        this.busIds = busIds;
    }

    public long getEarliestDepartureTimestamp() {
        return earliestDepartureTimestamp;
    }

    public List<Integer> getBusIds() {
        return busIds;
    }
}
