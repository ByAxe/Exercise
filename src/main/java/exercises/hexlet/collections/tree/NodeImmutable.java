package exercises.hexlet.collections.tree;

public class NodeImmutable implements INode {

    private final int value;
    private final INode left;
    private final INode right;

    public NodeImmutable(final int value, final INode left, final INode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    @Override
    public INode add(int value) {
        if (value == this.value) return this;
        if (value < this.value) {
            if (left == null) return new NodeImmutable(this.value, new NodeImmutable(value, null, null), right);
            return new NodeImmutable(this.value, left.add(value), right);
        }
        if (right == null) return new NodeImmutable(this.value, left, new NodeImmutable(value, null, null));
        return new NodeImmutable(this.value, left, right.add(value));
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
