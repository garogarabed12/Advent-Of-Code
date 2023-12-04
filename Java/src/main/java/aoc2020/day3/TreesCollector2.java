package aoc2020.day3;

/**
 * Slope: Right 1, down 1
 */

public class TreesCollector2 extends TreesCollector {

    public TreesCollector2() {
        super();
    }

    public void reduction(String line) {
        if (downIndex > 0) {
            rightIndex = (rightIndex + 1) % line.length();
            if (isTree(line.charAt(rightIndex))) {
                numberOfEncounteredTrees++;
            }
        }
        downIndex++;
    }
}
