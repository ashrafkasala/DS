package Tree;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class zigzaglevelordertraversal {
    public static void main(String[] args) {

    }
     public class TreeNode {
    int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
//
//    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//        List<List<Integer>> result = new LinkedList<List<Integer>>();
//        Stack<Integer> stack1 = new Stack<>();
//        Stack<Integer> stack2 = new Stack<>();
//
//        if(root.left != null )
//        stack1.push(root.val);
//        if(root.left != null )
//            stack1.push(root.val);
//
//
//
//    }
}
