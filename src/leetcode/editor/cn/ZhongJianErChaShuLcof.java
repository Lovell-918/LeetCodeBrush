//输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 递归 
// 👍 131 👎 0

  
  package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class ZhongJianErChaShuLcof{
      public static void main(String[] args) {
           Solution solution = new ZhongJianErChaShuLcof().new Solution();
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||preorder.length==0) return null;
        Map<Integer,Integer> indexOfIn = new HashMap<>();
        for(int i=0; i<inorder.length; ++i){
            indexOfIn.put(inorder[i],i);
        }
        return construct(preorder,0, preorder.length-1,
                inorder, 0, inorder.length-1, indexOfIn);
    }

    TreeNode construct(int[] preorder, int startPre, int endPre,
                       int[] inorder, int startIn, int endIn,
                       Map<Integer, Integer> indexOfIn){
        if(startPre>endPre) return null;
        TreeNode root=new TreeNode(preorder[startPre]);
        if(startPre==endPre) return root;
        int indexOfRoot=indexOfIn.get(preorder[startPre]);
        int leftNum=indexOfRoot-startIn, rightNum=endIn-indexOfRoot;
        TreeNode left=construct(preorder,startPre+1,startPre+leftNum,
                inorder,startIn,indexOfRoot-1,indexOfIn);
        TreeNode right=construct(preorder,startPre+leftNum+1,endPre,
                inorder,indexOfRoot+1,endIn,indexOfIn);
        root.left=left; root.right=right;
        return root;
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