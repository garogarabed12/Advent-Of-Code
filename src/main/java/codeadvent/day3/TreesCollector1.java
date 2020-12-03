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
        if (downCounter > 0) {
            rightCounter = (rightCounter + 3) % 31;
            if (isTree(line.charAt(rightCounter))) {
                numberOfEncounteredTrees++;
            }
        }
        downCounter++;
    }
}
