// @author Yash Dhume (100653618)
package Assignment3.ExpressionTree;

public class ValueNode implements TreeNode {
    double value;
    ValueNode(double value){//constructor
        this.value = value;
    }
    public void print(int depth) {//Print and add spaces for values
        for (int i = 0; i < depth; i++) {
            System.out.print("\t");
        }
        System.out.println(value);
    }
    @Override
    public double evaluate() {
        return value;
    }

}