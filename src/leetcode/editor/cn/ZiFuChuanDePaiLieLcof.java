//输入一个字符串，打印出该字符串中字符的所有排列。 
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
// Related Topics 回溯算法 
// 👍 55 👎 0

  
  package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ZiFuChuanDePaiLieLcof{
      public static void main(String[] args) {
           Solution solution = new ZiFuChuanDePaiLieLcof().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Set<String> ans=new HashSet<>();
    StringBuilder sb=new StringBuilder();
    public String[] permutation(String s) {
        if(s==null||s.length()==0) return new String[0];
        char[] chars=s.toCharArray();
        boolean[] visited=new boolean[chars.length];
        backtrack(chars,visited);
        return ans.toArray(new String[0]);
    }

    void backtrack(char[] chars, boolean[] visited){
        if(sb.length()==chars.length) {
            ans.add(sb.toString());
            return;
        }
        for(int i=0; i<chars.length; ++i){
            if(visited[i]) continue;
            sb.append(chars[i]);
            visited[i]=true;
            backtrack(chars,visited);
            sb.delete(sb.length()-1,sb.length());
            visited[i]=false;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }