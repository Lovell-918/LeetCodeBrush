//给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。 
//
// 
//
// 示例： 
//
// 输入：3
//输出：
//[
//  [1,null,3,2],
//  [3,2,null,1],
//  [3,1,null,null,2],
//  [2,1,3],
//  [1,null,2,null,3]
//]
//解释：
//以上的输出对应以下 5 种不同结构的二叉搜索树：
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 8 
// 
// Related Topics 树 动态规划

  
  package leetcode.editor.cn;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class UniqueBinarySearchTreesIi{
      public static void main(String[] args) {
           Solution solution = new UniqueBinarySearchTreesIi().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n==0) return new LinkedList<TreeNode>();
        return generate(1,n);
    }

    List<TreeNode> generate(int start, int end){
        if(start>end) return Collections.singletonList(null);
        List<TreeNode> ans = new LinkedList<>();
        for(int i=start; i<=end; ++i){
            List<TreeNode> leftTree = generate(start,i-1);
            List<TreeNode> rightTree = generate(i+1, end);
            for(TreeNode l:leftTree){
                for (TreeNode r:rightTree){
                    TreeNode cur=new TreeNode(i,l,r);
                    ans.add(cur);
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
class TreeNode {
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
  }