package codeadvent.day3;

/**
 * Slope: Right 3, down 1
 * From part 1
 */

public class TreesCollector1 extends TreesCollector {

    public TreesCollector1() {
        super();
    }

    public void reduction(String line) {
        if (downIndex > 0) {
            rightIndex = (rightIndex + 3) % line.length();
            if (isTree(line.charAt(rightIndex))) {
                numberOfEncounteredTrees++;
            }
        }
        downIndex++;
    }
}
