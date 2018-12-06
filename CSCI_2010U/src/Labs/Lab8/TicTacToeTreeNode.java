package Labs.Lab8;
public class TicTacToeTreeNode {


    private String data;
    private TicTacToeTreeNode childNodes[];

    private TicTacToeTreeNode(String data) {
        this.data = data;
    }
    private static void printTree(TicTacToeTreeNode root) {
        printTree("", root);
    }
    private static TicTacToeTreeNode createNode(String board, String player) {
        TicTacToeTreeNode root = new TicTacToeTreeNode(board);
        int count = emptySpaces(board);
        root.childNodes = new TicTacToeTreeNode[count];
        int index = 0;
        String nextPlayer = player.equalsIgnoreCase("x") ? "o" : "x";
        for (int i = 0; i < count; i++) {
            index = board.indexOf(" ", index + 1);
            board = makeMove(board, index, player);
            root.childNodes[i] = createNode(board, nextPlayer);
            board = makeMove(board, index, " ");
        }
        return root;
    }
    private static int emptySpaces(String board) {
        int count = 0;
        for (int i = 0; i < board.length(); i++)
            if (board.charAt(i) == ' ') count++;
        return count;

    }
    private static String makeMove(String old, int pos, String player) {
        String before = old.substring(0, pos);
        String after = old.substring(pos + 1);
        return before + player + after;
    }
    private static void printTree(String spaces, TicTacToeTreeNode node) {
        if (node != null) {
            System.out.println(spaces + node.data);
            for (int i = 0; i < node.childNodes.length; i++) printTree(spaces + "\t", node.childNodes[i]);
        }
    }
    public static void main(String[] args) {
        String board = "x ox xo o";
        TicTacToeTreeNode root = createNode(board, "x");
        printTree(root);
    }
}
