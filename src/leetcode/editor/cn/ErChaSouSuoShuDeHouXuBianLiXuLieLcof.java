//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。 
//
// 
//
// 参考以下这颗二叉搜索树： 
//
//      5
//    / \
//   2   6
//  / \
// 1   3 
//
// 示例 1： 
//
// 输入: [1,6,3,2,5]
//输出: false 
//
// 示例 2： 
//
// 输入: [1,3,2,6,5]
//输出: true 
//
// 
//
// 提示： 
//
// 
// 数组长度 <= 1000 
// 
// 👍 66 👎 0

  
  package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class ErChaSouSuoShuDeHouXuBianLiXuLieLcof{
      public static void main(String[] args) {
           Solution solution = new ErChaSouSuoShuDeHouXuBianLiXuLieLcof().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean verifyPostorder(int[] postorder) {
//        Stack<Integer> stack=new Stack<>();
//        int root=Integer.MAX_VALUE;
//        for(int i=postorder.length-1; i>=0; --i){
//            if(postorder[i]>root) return false;
//            while (!stack.isEmpty()&&postorder[i]<stack.peek()){
//                root=stack.pop();
//            }
//            stack.push(postorder[i]);
//        }
//        return true;
        return verify(postorder,0,postorder.length-1);

    }

    boolean verify(int[] postorder, int begin, int end){
        if(begin>=end) return true;
        int i=begin;
        while (postorder[i]<postorder[end]) ++i;
        int mid=i;
        while (postorder[i]>postorder[end]) ++i;
        return i==end&&verify(postorder,begin,mid-1)
                &&verify(postorder,mid,end-1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }