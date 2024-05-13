class BstNode {
    Integer data;
    Integer sumToNode;

    BstNode left;
    BstNode right;

    public BstNode(Integer data, Integer sumToNode) {
        this.data = data;
        this.sumToNode = sumToNode;
    }

    public static BstNode create(Integer data) {
        return new BstNode(data, 0);
    }
}

public class Bst {
    BstNode root;

    public Bst() {
        this.root = null;
    }

    public void insert(Integer data) {
        if (this.root == null) {
            this.root = BstNode.create(data);
            return;
        }

        BstNode current = this.root;
        Integer sum = 0;

        while (true) {
            sum += current.data;

            if (data > current.data) {
                if (current.right == null) {
                    current.right = new BstNode(data, sum);
                    return;
                }

                current = current.right;
            } else {
                if (current.left == null) {
                    current.left = new BstNode(data, sum);
                    return;
                }

                current = current.left;
            }
        }
    }

    public void print() {
        printRecursive(this.root, 10, 0);
    }

    private void printRecursive(BstNode node, Integer incrementBy, Integer start) {
        if (node == null) {
            return;
        }

        start += incrementBy;

        printRecursive(node.right, incrementBy, start);

        System.out.println();

        for (int i = incrementBy; i < start; i++) {
            System.out.print(" ");
        }

        System.out.println(node.data + "(" + node.sumToNode.toString() + ")");

        printRecursive(node.left, incrementBy, start);
    }
}
