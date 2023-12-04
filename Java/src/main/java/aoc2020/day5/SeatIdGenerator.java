package aoc2020.day5;

import java.util.List;

public class SeatIdGenerator {

    public int generateSeatId(String ticketCode) {
        int rowIndex = 64;
        int seatIndex = 4;
        int front = 0, back = 127;
        int left = 0, right = 7;

        for (int i = 0; i < ticketCode.length(); i++) {
            switch (ticketCode.charAt(i)) {
                case 'F':
                    back = back - rowIndex;
                    rowIndex = rowIndex / 2;
                    break;

                case 'B':
                    front = front + rowIndex;
                    rowIndex = rowIndex / 2;
                    break;

                case 'R':
                    left = left + seatIndex;
                    seatIndex = seatIndex / 2;
                    break;

                case 'L':
                    right = right - seatIndex;
                    seatIndex = seatIndex / 2;
                    break;
            }
        }

        /*these two are the same.
        back * 8 + right;*/
        return front * 8 + left;
    }

    public void calculateMySeatId(List<Integer> seatIds, int size) {
        for (int i = 0; i < size-1; i++) {
            if (seatIds.get(i + 1) != seatIds.get(i) + 1) {
                System.out.println("The ID of my seat is: " + (seatIds.get(i) + 1));
            }
        }
    }
}
