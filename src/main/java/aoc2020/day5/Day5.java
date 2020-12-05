package aoc2020.day5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Day5 {
    public static void main(String[] args) throws IOException {
        System.out.println("Part 1:");

        Path path = Paths.get("./src/main/java/aoc2020/day5/dayFiveInput.txt");
        SeatIdGenerator seatIdGenerator = new SeatIdGenerator();

        List<Integer> seatIds = Files.lines(path).map(seatIdGenerator::generateSeatId).sorted().collect(Collectors.toList());
        int size = seatIds.size();

        System.out.println("Highest seat ID on a boarding pass is: " + seatIds.get(size-1));

        System.out.println("==========================================");
        System.out.println("Part 2:");

        for (int i= 1; i<size-1; i++) {
            if(seatIds.get(i+1) != seatIds.get(i) + 1) {
                System.out.println("the ID of my seat is: " + (seatIds.get(i) + 1));
            }
        }
    }
}
