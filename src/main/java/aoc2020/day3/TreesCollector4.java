package aoc2020.day3;

/**
 * Slope: Right 7, down 1
 */

public class TreesCollector4 extends TreesCollector {

    public TreesCollector4() {
        super();
    }

    public void reduction(String line) {
        if (downIndex > 0) {
            rightIndex = (rightIndex + 7) % line.length();
            if (isTree(line.charAt(rightIndex))) {
                numberOfEncounteredTrees++;
            }
        }
        downIndex++;
    }
}
