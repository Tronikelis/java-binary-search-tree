class BstNode {
    Integer data;

    BstNode parent;
    BstNode left;
    BstNode right;

    public BstNode(Integer data) {
        this.data = data;
    }
}

public class Bst {
    BstNode root;

    public Bst() {
        this.root = null;
    }

    private void detachFromParent(BstNode node) {
        BstNode parent = node.parent;

        if (node == this.root) {
            this.root = null;
            return;
        }

        if (parent.left == node) {
            parent.left = null;
        } else {
            parent.right = null;
        }
    }

    public void remove(Integer data) {
        BstNode toRemove = this.find(data);
        if (toRemove == null) {
            return;
        }

        if (toRemove.left == null && toRemove.right == null) {
            detachFromParent(toRemove);
            return;
        }

        if (toRemove.right == null) {
            // removing root
            if (toRemove == this.root) {
                this.root = toRemove.left;
                this.root.parent = null;
                return;
            }

            toRemove.left.parent = toRemove.parent;
            toRemove.parent.left = toRemove.left;

            return;
        }

        if (toRemove.left == null) {
            // removing root
            if (toRemove == this.root) {
                this.root = toRemove.right;
                this.root.parent = null;
                return;
            }

            toRemove.right.parent = toRemove.parent;
            toRemove.parent.right = toRemove.right;

            return;
        }

        // find the least biggest and replace `toRemove` with that
        BstNode leastBiggest = toRemove.right;

        while (leastBiggest.left != null) {
            leastBiggest = leastBiggest.left;
        }

        remove(leastBiggest.data);
        toRemove.data = leastBiggest.data;
    }

    public BstNode find(Integer data) {
        BstNode current = this.root;

        while (true) {
            if (current == null) {
                return null;
            }

            if (current.data == data) {
                return current;
            }

            if (data < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
    }

    public void insert(Integer data) {
        if (this.root == null) {
            this.root = new BstNode(data);
            return;
        }

        BstNode current = this.root;

        while (true) {
            if (data > current.data) {
                if (current.right == null) {
                    current.right = new BstNode(data);
                    current.right.parent = current;
                    return;
                }

                current = current.right;
            } else {
                if (current.left == null) {
                    current.left = new BstNode(data);
                    current.left.parent = current;
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

        System.out.println(node.data);

        printRecursive(node.left, incrementBy, start);
    }
}
