//给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。注意，路径不一定非得从二叉树的
//根节点或叶节点开始或结束，但是其方向必须向下(只能从父节点指向子节点方向)。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// 3
//解释：和为 22 的路径有：[5,4,11,2], [5,8,4,5], [4,11,7] 
//
// 提示： 
//
// 
// 节点总数 <= 10000 
// 
// Related Topics 树 深度优先搜索 
// 👍 30 👎 0

  
  package leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedList;

public class PathsWithSumLcci{
      public static void main(String[] args) {
           Solution solution = new PathsWithSumLcci().new Solution();
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
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSumCount=new HashMap<>();
        preSumCount.put(0,1);
        return recPathSum(root,preSumCount,sum,0);
    }

    int recPathSum(TreeNode root, HashMap<Integer, Integer> preSumCount, int target, int cursum){
        if(root==null) return 0;
        cursum+=root.val;
        int ans=preSumCount.getOrDefault(cursum-target,0);
        preSumCount.put(cursum,preSumCount.getOrDefault(cursum,0)+1);
        ans+=recPathSum(root.left,preSumCount,target,cursum);
        ans+=recPathSum(root.right,preSumCount,target,cursum);
        preSumCount.put(cursum,preSumCount.get(cursum)-1);
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