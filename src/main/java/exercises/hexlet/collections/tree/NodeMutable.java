package exercises.hexlet.collections.tree;

public class NodeMutable implements INode {

    private final int value;

    private INode left = null;

    private INode right = null;

    public NodeMutable(final int value) {
        this.value = value;
    }

    @Override
    public INode add(int value) {
        if (value == this.value) return this;
        if (value < this.value) {
            if (left == null) left = new NodeMutable(value);
            else left = left.add(value);
            return this;
        }
        if (right == null) right = new NodeMutable(value);
        else right = right.add(value);
        return this;
    }

    @Override
    public int count() {
        int leftCount = left != null ? left.count() : 0;
        int rightCount = right != null ? right.count() : 0;
        return leftCount + 1 + rightCount;
    }

    @Override
    public void print() {
        if (left != null) left.print();
        System.out.println(value);
        if (right != null) right.print();
    }
}
