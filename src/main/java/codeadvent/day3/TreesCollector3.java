package codeadvent.day3;

/**
 * Slope: Right 5, down 1
 */

public class TreesCollector3 extends TreesCollector {

    public TreesCollector3() {
        super();
    }

    public void reduction(String line) {
        if (downIndex > 0) {
            rightIndex = (rightIndex + 5) % 31;
            if (isTree(line.charAt(rightIndex))) {
                numberOfEncounteredTrees++;
            }
        }
        downIndex++;
    }
}
