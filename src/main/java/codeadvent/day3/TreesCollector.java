package codeadvent.day3;

public class TreesCollector {
    protected int numberOfEncounteredTrees;
    protected int downIndex;
    protected int rightIndex;

    public TreesCollector() {
        downIndex = 0;
        rightIndex = 0;
        numberOfEncounteredTrees = 0;
    }

    public void join(TreesCollector that) {
        setNumberOfEncounteredTrees(that.numberOfEncounteredTrees);
    }

    public void setNumberOfEncounteredTrees(int numberOfEncounteredTrees) {
        this.numberOfEncounteredTrees = numberOfEncounteredTrees;
    }

    public int getNumberOfEncounteredTrees() {
        return numberOfEncounteredTrees;
    }

    public boolean isTree(char c) {
        return c == '#';
    }
}
