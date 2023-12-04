package aoc2020.day10;

import java.util.List;
import java.util.stream.Collectors;

public class JoltageDifferencesCalculator {
    private final List<Integer> numbers;

    private int differenceOneCounter;
    private int differenceThreeCounter;
    private final int highestRatedAdapter;
    private final int myDevicesAdapterRating;

    public JoltageDifferencesCalculator(List<Integer> numbers) {
        this.numbers = numbers;
        highestRatedAdapter = numbers.get(numbers.size() - 1);
        myDevicesAdapterRating = highestRatedAdapter + 3;
    }

    void calculateJoltDifferences() {
        int initial = 0;
        while (true) {
            if (numbers.contains(initial + 1)) {
                differenceOneCounter++;
                initial++;
            } else if (numbers.contains(initial + 3)) {
                differenceThreeCounter++;
                initial += 3;
            }
            else {
                differenceThreeCounter++;
                return;
            }
        }
    }

    public void calculateTotalNumberOfDistinctWaysToArrangeAdapters() {

    }

    public int getDifferenceOneCounter() {
        return differenceOneCounter;
    }

    public int getDifferenceThreeCounter() {
        return differenceThreeCounter;
    }
}
