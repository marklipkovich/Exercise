import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SolutionTree {
    private TreeNode root;

    private void fromArray(int [] nums){
        Queue<TreeNode> treeQueue = new LinkedList<>();
        root = new TreeNode(nums[0]);
        treeQueue.add(root);
        int i = 1;
        while (i < nums.length){
            TreeNode current = treeQueue.poll();
            assert current != null;
            current.left = new TreeNode(nums[i]);
            current.right = new TreeNode(nums[i+1]);
            treeQueue.add (current.left);
            treeQueue.add (current.right);
            i = i +2;
        }
    }

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
        int[] nums = {5,2,7,1,4,6,9};
        theTree.fromArray(nums);

        //theTree.addNode(0);
        //theTree.addNode(7);
        //theTree.addNode(10);

        //theTree.addNode(11);
        //theTree.addNode(9);
        //theTree.addNode(2);
        //theTree.addNode(3);
        //theT ree.addNode(5);
        //theTree.addNode(1);
        //theTree.addNode(6);

        //System.out.print( isValidBST(null));
        System.out.print(theTree.isValidBST(theTree.root));

        System.out.print( theTree.isValid((theTree.root)));
        //System.out.print(maxDepth(theTree.root,1));
        //System.out.print(maximum_depth(theTree.root,0));
        }
    private boolean isValidBST(TreeNode root) {
        inorderTraversal(root);
        System.out.println(result);
        if (result.size() < 2) return true;
        for (int i = 1; i < result.size(); i++) {
            if (result.get(i) <= result.get(i - 1)) return false;
        }
        return true;
    }

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
    private static void inorderTraversal(TreeNode root) {
        if (root != null) {

            inorderTraversal(root.left);
            result.add(root.val);
            inorderTraversal(root.right);

        }

    }

    public  boolean isValid(TreeNode root) {
        return isValid(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    private boolean isValid(TreeNode p, double min, double max){
        if(p==null)
            return true;

        //if(p.val <= min || p.val >= max)
            //return false;

        return isValid(p.left, min, p.val) && isValid(p.right, p.val, max);
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x)
        { val = x; }
}
