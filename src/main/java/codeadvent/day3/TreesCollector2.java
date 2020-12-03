package codeadvent.day3;

/**
 * Slope: Right 1, down 1
 */

public class TreesCollector2 extends TreesCollector {

    public TreesCollector2() {
        super();
    }

    public void reduction(String line) {
        if (downCounter > 0) {
            rightCounter = (rightCounter + 1) % 31;
            if (isTree(line.charAt(rightCounter))) {
                numberOfEncounteredTrees++;
            }
        }
        downCounter++;
    }
}
