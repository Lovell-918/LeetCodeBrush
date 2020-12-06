//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
// Related Topics 树 广度优先搜索 
// 👍 23 👎 0

  
  package leetcode.editor.cn;

import java.util.*;

public class CongShangDaoXiaDaYinErChaShuIiiLcof{
      public static void main(String[] args) {
           Solution solution = new CongShangDaoXiaDaYinErChaShuIiiLcof().new Solution();
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        boolean flag=true;
        TreeNode temp;
        while (!queue.isEmpty()){
            List<Integer> sin=new ArrayList<>();
            int len= queue.size();
            for (int i=0; i<len; ++i){
                temp=queue.poll();
                sin.add(temp.val);
                if(temp.right!=null) queue.offer(temp.right);
                if(temp.left!=null) queue.offer(temp.left);
            }
            if(flag) Collections.reverse(sin);
            flag=!flag;
            ans.add(sin);
        }
        return ans;
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