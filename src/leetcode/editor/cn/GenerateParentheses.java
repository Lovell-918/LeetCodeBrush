//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1193 👎 0

  
  package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses{
      public static void main(String[] args) {
           Solution solution = new GenerateParentheses().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> ans=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtrack(new StringBuilder(),0,0,n);
        return ans;
    }

    void backtrack(StringBuilder sb, int left, int right, int n){
        if(sb.length()==2*n){
            ans.add(sb.toString());
            return;
        }
        if(left<n){
            sb.append('(');
            backtrack(sb,left+1,right,n);
            sb.deleteCharAt(sb.length()-1);
        }
        if(right<left){
            sb.append(')');
            backtrack(sb,left,right+1,n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }