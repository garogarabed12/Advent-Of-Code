package codeadvent.day3;

/**
 * Slope: Right 1, down 2
 */

public class TreesCollector5 extends TreesCollector {

    public TreesCollector5() {
        super();
    }

    public void reduction(String line) {
        if (downIndex > 0 && downIndex % 2 == 0) {
            rightIndex = (rightIndex + 1) % 31;
            if (isTree(line.charAt(rightIndex))) {
                numberOfEncounteredTrees++;
            }
        }
        downIndex++;
    }
}
