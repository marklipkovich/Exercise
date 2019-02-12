import java.util.ArrayList;
import java.util.List;

public class SolutionTree {

    private TreeNode root;
    private void addNode(int val) {
        TreeNode newNode = new TreeNode(val);
        if (root == null) {
            root = newNode;
        } else {
            TreeNode aNode = root;
            TreeNode parent;
            while (true) {
                parent = aNode;
                if (val < aNode.val) {
                    aNode = aNode.left;
                    if (aNode == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    aNode = aNode.right;
                    if (aNode == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    public  static void main(String arg[]){

        SolutionTree theTree = new SolutionTree();
        theTree.addNode(0);
        theTree.addNode(7);
        theTree.addNode(10);

        //theTree.addNode(11);
        //theTree.addNode(9);
        //theTree.addNode(2);
        //theTree.addNode(3);
        //theT ree.addNode(5);
        //theTree.addNode(1);
        //theTree.addNode(6);


        System.out.print(preorderTraversal(theTree.root));
        System.out.print(maxDepth(theTree.root,1));
        //System.out.print(maximum_depth(theTree.root,0));
    }

    //public static int maxDepth(TreeNode root) {

        //return maximum_depth(root,1);

    //}

    private static int res;
    private static int maxDepth(TreeNode root, int depth) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            res = Math.max(res, depth);
        }
        maxDepth(root.left, depth + 1);
        maxDepth(root.right, depth + 1);
        return res;
    }

    private static List<Integer>result = new ArrayList<>();
    private static List<Integer> preorderTraversal(TreeNode root) {

        if (root != null) {
            result.add(root.val);

            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return result;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x)
        { val = x; }
}
