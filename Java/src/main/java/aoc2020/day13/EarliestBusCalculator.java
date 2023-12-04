package aoc2020.day13;

import java.util.*;

public class EarliestBusCalculator {

    private final Notes notes;
    private final long earliestDepartureTimestamp;
    private List<Integer> busIds = new ArrayList<>();
    private final Map<Integer, List<Long>> departureTimesPerBus = new HashMap<>();

    public EarliestBusCalculator(Notes notes) {
        this.notes = notes;
        earliestDepartureTimestamp = notes.getEarliestDepartureTimestamp();
        busIds.addAll(notes.getBusIds());
        fillDepartureTimesMap();
    }

    private void fillDepartureTimesMap() {
        //generates timestamps for bus Id's
        for (Integer busId : busIds) {
            List<Long> departureTimes = new ArrayList<>();
            long i = 1;
            //50 can also be 100 or any number enough larger than earliestDepartureTimestamp
            while ((busId * i) <= earliestDepartureTimestamp * 10000) {
                departureTimes.add((long) busId * i);
                i++;
            }
            departureTimesPerBus.put(busId, departureTimes);
        }
    }

    long calculateEarliestBusId() {
        List<Long> current = departureTimesPerBus.get(busIds.get(0));
        Optional<Long> earliest = current.stream().filter(x -> x >= earliestDepartureTimestamp).findFirst();
        int earliestBusId = busIds.get(0);

        for (int i = 1; i < departureTimesPerBus.keySet().size(); i++) {

            List<Long> tmp = departureTimesPerBus.get(busIds.get(i));
            Optional<Long> possiblyEarlier = tmp.stream().filter(x -> x >= earliestDepartureTimestamp).findFirst();

            if (possiblyEarlier.isPresent() && earliest.isPresent() && possiblyEarlier.get() < earliest.get()) {
                earliest = possiblyEarlier;
                earliestBusId = busIds.get(i);
            }
        }

        if (earliest.isPresent()) {

            long minutesToWait = earliest.get() - earliestDepartureTimestamp;
            System.out.println("Departure Timestamp: " + earliestDepartureTimestamp);
            System.out.println("Earliest bus arrival: " + earliest.get());
            System.out.println("Earliest Bus Id: " + earliestBusId);
            System.out.println("Minutes to wait: " + minutesToWait);
            System.out.println();

            return earliestBusId * minutesToWait;
        }

        return 0;
    }

    /*long calculateEarliestTimestampForPartTwo() {

        List<Long> departureTimesForFirstBus = departureTimesPerBus.get(busIds.get(0));
        for (long departureTime : departureTimesForFirstBus) {

        }

    }*/
}
