package codeadvent.day3;

/**
 * Slope: Right 7, down 1
 */

public class TreesCollector4 extends TreesCollector {

    public TreesCollector4() {
        super();
    }

    public void reduction(String line) {
        if (downIndex > 0) {
            rightIndex = (rightIndex + 7) % 31;
            if (isTree(line.charAt(rightIndex))) {
                numberOfEncounteredTrees++;
            }
        }
        downIndex++;
    }
}
