package codeadvent.day3;

/**
 * Slope: Right 7, down 1
 */

public class TreesCollector4 extends TreesCollector {

    public TreesCollector4() {
        super();
    }

    public void reduction(String line) {
        if (downCounter > 0) {
            rightCounter = (rightCounter + 7) % 31;
            if (isTree(line.charAt(rightCounter))) {
                numberOfEncounteredTrees++;
            }
        }
        downCounter++;
    }
}
