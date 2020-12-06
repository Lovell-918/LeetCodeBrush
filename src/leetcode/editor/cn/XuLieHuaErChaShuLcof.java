//请实现两个函数，分别用来序列化和反序列化二叉树。 
//
// 示例: 
//
// 你可以将以下二叉树：
//
//    1
//   / \
//  2   3
//     / \
//    4   5
//
//序列化为 "[1,2,3,null,null,4,5]" 
//
// 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-b
//inary-tree/ 
// Related Topics 树 设计 
// 👍 44 👎 0

  
  package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class XuLieHuaErChaShuLcof{
      public static void main(String[] args) {
          Codec solution = new XuLieHuaErChaShuLcof().new Codec();
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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> ansList=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node=queue.poll();
            if(node!=null){
                ansList.add(String.valueOf(node.val));
                queue.offer(node.left);
                queue.offer(node.right);
            }else {
                ansList.add("NULL");
            }
        }
        return String.join(",",ansList);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("NULL")) return null;
        String[] datas=data.split(",");
        TreeNode root=new TreeNode(Integer.parseInt(datas[0]));
        int index=1;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (index<datas.length){
            TreeNode node=queue.poll();
            String left=datas[index];
            String right=datas[index+1];
            if(!left.equals("NULL")){
                TreeNode leftNode=new TreeNode(Integer.parseInt(left));
                node.left=leftNode;
                queue.offer(leftNode);
            }
            if(!right.equals("NULL")){
                TreeNode rightNode= new TreeNode(Integer.parseInt(right));
                node.right = rightNode;
                queue.offer(rightNode);
            }
            index+=2;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
  }