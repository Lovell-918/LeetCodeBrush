//从左向右遍历一个数组，通过不断将其中的元素插入树中可以逐步地生成一棵二叉搜索树。给定一个由不同节点组成的二叉搜索树，输出所有可能生成此树的数组。 
//
// 
//
// 示例： 
//给定如下二叉树 
//
//         2
//       / \
//      1   3
// 
//
// 返回： 
//
// [
//   [2,1,3],
//   [2,3,1]
//]
// 
// Related Topics 树 动态规划 
// 👍 35 👎 0

  
  package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class BstSequencesLcci{
      public static void main(String[] args) {
           Solution solution = new BstSequencesLcci().new Solution();
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
    public List<List<Integer>> BSTSequences(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) {
            ans.add(new ArrayList<>());
            return ans;
        }
        List<TreeNode> items=new ArrayList<>();
        items.add(root);
        List<Integer> single=new ArrayList<>();
        backtrack(ans,items,single);
        return ans;
    }

    void backtrack(List<List<Integer>> ans, List<TreeNode> items, List<Integer> single){
        if(items.isEmpty()){
            ans.add(new ArrayList<>(single));
            return;
        }
        int len=items.size();
        for(int i=0; i<len; ++i){
            TreeNode cur=items.get(i);
            items.remove(i);
            if(cur.left!=null) items.add(cur.left);
            if(cur.right!=null) items.add(cur.right);
            single.add(cur.val);
            backtrack(ans,items,single);
            single.remove(single.size()-1);
            items.add(i,cur);
            items.remove(cur.left);
            items.remove(cur.right);
        }
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