package codeadvent.day3;

public class TreesCollector {
    protected int numberOfEncounteredTrees;
    protected int downCounter;
    protected int rightCounter;

    public TreesCollector() {
        downCounter = 0;
        rightCounter = 0;
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
