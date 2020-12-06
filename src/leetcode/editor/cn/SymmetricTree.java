//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索

  
  package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree{
      public static void main(String[] args) {
           Solution solution = new SymmetricTree().new Solution();
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
    public boolean isSymmetric(TreeNode root) {
//        return isMirror(root,root);
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()){
            TreeNode t1=q.poll();
            TreeNode t2=q.poll();
            if(t1==null&&t2==null) continue;
            if(t1==null||t2==null) return false;
            if(t1.val!=t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }
    //递归
    boolean isMirror(TreeNode t1, TreeNode t2){
        if(t1==null && t2==null) return true;
        else if(t1==null || t2==null) return false;
        else return (t1.val==t2.val) && isMirror(t1.left,t2.right) && isMirror(t1.right,t2.left);
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