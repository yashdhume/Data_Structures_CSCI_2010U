package Labs.Lab9;

public class AVLNode {
    public AVLNode left = null;
    public AVLNode right = null;
    public int value = 0;
    public AVLNode parent = null;
    public AVLNode insert(int newValue) {
        // perform binary-search style insertion
        if (newValue < this.value) {
            // insert the value to the left sub-tree
            if (this.left == null) {
                AVLNode newNode = new AVLNode();
                newNode.value = newValue;
                newNode.parent = this;
                this.left = newNode;
            } else {
                this.left.insert(newValue);
            }
        } else {
            // insert the value into the right sub-tree
            if (this.right == null) {
                AVLNode newNode = new AVLNode();
                newNode.value = newValue;
                newNode.parent = this;
                this.right = newNode;
            } else {
                this.right.insert(newValue);
            }
        }

        return rebalance();
    }
    public AVLNode rebalance() {
        AVLNode node  = new AVLNode();
        if (node.getBalance()<= -2) {
            if (left.getBalance() >= 1)
                return rotateLeftThenRight(node);
            else
                return rotateRight(node);

        } else if (node.getBalance() >= 2) {
            if (right.getBalance()<=-1)
                return rotateRightThenLeft(node);
            else
                return rotateLeft(node);
        }

        if (node.parent != null) {
            node.parent.rebalance();
        } else {
            parent = node;
        }
        return null;
    }
    AVLNode rotateRight(AVLNode x) {
        AVLNode y = x.right;
        y.parent = x.parent;

        x.right = y.left;

        if (x.right != null)
            x.right.parent = x;

        y.left = x;
        x.parent = y;

        if (y.parent != null) {
            if (y.parent.right == x) {
                y.parent.right = y;
            } else {
                y.parent.left = y;
            }
        }
        return y;
    }


    AVLNode rotateLeft(AVLNode x) {
        AVLNode y = x.left;
        y.parent = x.parent;

        x.left = y.right;

        if (x.left != null)
            x.left.parent = x;

        y.right = x;
        x.parent = y;

        if (y.parent != null) {
            if (y.parent.right == x) {
                y.parent.right = y;
            } else {
                y.parent.left = y;
            }
        }
        return y;
    }
    private AVLNode rotateLeftThenRight(AVLNode node) {
        node.left = rotateLeft(node.left);
        return rotateRight(node);
    }

    private AVLNode rotateRightThenLeft(AVLNode node) {
        node.right = rotateRight(node.right);
        return rotateLeft(node);
    }
    public int getBalance() {
        int rightHeight = 0;
        if (this.right != null) {
            rightHeight = this.right.getHeight();
        }

        int leftHeight = 0;
        if (this.left != null) {
            leftHeight = this.left.getHeight();
        }

        return rightHeight - leftHeight;
    }

    public void print(int depth) {
        if (this.right != null) {
            this.right.print(depth + 1);
        }

        for (int i = 0; i < depth; i++) {
            System.out.print("\t");
        }
        System.out.println(this.value);

        if (this.left != null) {
            this.left.print(depth + 1);
        }
    }

    public int getHeight() {
        int leftHeight = 1;
        if (left != null) {
            leftHeight = left.getHeight() + 1;
        }
        int rightHeight = 0;
        if (right != null) {
            rightHeight = right.getHeight() + 1;
        }
        return (leftHeight > rightHeight) ? leftHeight : rightHeight;
    }
}
