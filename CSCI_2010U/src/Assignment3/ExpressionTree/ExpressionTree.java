// @author Yash Dhume (100653618)
package Assignment3.ExpressionTree;

public class ExpressionTree{
    OpNode node;
    ExpressionTree(OpNode node){
        this.node = node;
    }//Constructor
    public void print() {//main print of tree
        int depth = 0;
        node.print(depth);
    }
    public double evaluate() {//main evaluate for tree
        double value = node.evaluate();
        return value;
    }

}
