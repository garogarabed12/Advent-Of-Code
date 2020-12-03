package codeadvent.day3;

/**
 * Slope: Right 1, down 2
 */

public class TreesCollector5 extends TreesCollector {

    public TreesCollector5() {
        super();
    }

    public void reduction(String line) {
        if (downCounter > 0 && downCounter % 2 == 0) {
            rightCounter = (rightCounter + 1) % 31;
            if (isTree(line.charAt(rightCounter))) {
                numberOfEncounteredTrees++;
            }
        }
        downCounter++;
    }
}
