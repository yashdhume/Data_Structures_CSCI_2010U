// @author Yash Dhume (100653618)
package Assignment3.ExpressionTree;

public class OpNode implements TreeNode{
    String operation;
    TreeNode leftNode;
    TreeNode rightNode;
    OpNode(TreeNode leftNode, String operation, TreeNode rightNode){//constuctor
        this.leftNode = leftNode;
        this.operation = operation;
        this.rightNode = rightNode;
    }
    @Override
    public void print(int depth) {//add spaces and print the leftNode and right node add spaces for operator
        leftNode.print(depth+1);
        for (int i = 0; i <depth; i++) {
            System.out.print("\t");
        }
        System.out.println(operation);
        rightNode.print(depth+1);
    }
    @Override
    public double evaluate() {//evaluate 2 nodes with given  operator
        double value = 0;
        if(operation == "/")value = leftNode.evaluate() / rightNode.evaluate();
        if(operation == "*")value = leftNode.evaluate() * rightNode.evaluate();
        if(operation == "+")value = leftNode.evaluate() + rightNode.evaluate();
        if(operation == "-")value = leftNode.evaluate() - rightNode.evaluate();
        return value;
    }
}
