//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最小深度 2. 
// Related Topics 树 深度优先搜索 广度优先搜索

  
  package leetcode.editor.cn;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Stack;

public class MinimumDepthOfBinaryTree{
      public static void main(String[] args) {
           Solution solution = new MinimumDepthOfBinaryTree().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int minDepth(TreeNode root) {
        //深度优先，递归
//        if(root==null) return 0;
//        if(root.left==null && root.right==null) return 1;
//        int min = Integer.MAX_VALUE;
//        if(root.left!=null){
//            min = Math.min(min,minDepth(root.left));
//        }
//        if(root.right!=null){
//            min = Math.min(min,minDepth(root.right));
//        }
//        return min+1;
        //深度优先，迭代
//        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
//        if(root==null) return 0;
//        stack.push(new Pair<>(root,1));
//        int min = Integer.MAX_VALUE;
//        while (!stack.isEmpty()){
//            Pair<TreeNode,Integer> current = stack.pop();
//            TreeNode node=current.getKey();
//            int current_dep = current.getValue();
//            if(node.left==null&&node.right==null) min = Math.min(current_dep,min);
//            if(node.left!=null) stack.push(new Pair<>(node.left,current_dep+1));
//            if(node.right!=null) stack.push(new Pair<>(node.right,current_dep+1));
//        }
//        return min;
        //广度优先，迭代
        LinkedList<Pair<TreeNode,Integer>> linkedList = new LinkedList<>();
        if(root==null) return 0;
        linkedList.add(new Pair<>(root,1));
        int min=0;
        while (!linkedList.isEmpty()){
            Pair<TreeNode,Integer> current=linkedList.poll();
            TreeNode node=current.getKey();
            min=current.getValue();
            if(node.left==null&&node.right==null) break;
            if(node.left!=null) linkedList.add(new Pair<>(node.left,min+1));
            if(node.right!=null) linkedList.add(new Pair<>(node.right,min+1));
        }
        return min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
  }