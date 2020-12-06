//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法 
// 👍 806 👎 0

  
  package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber{
      public static void main(String[] args) {
           Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Map<String, String> map=new HashMap<String,String>(){{
        put("2","abc");
        put("3","def");
        put("4","ghi");
        put("5","jkl");
        put("6","mno");
        put("7","pqrs");
        put("8","tuv");
        put("9","wxyz");
    }};
    List<String> ans=new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits!=null&&digits.length()!=0){
            backtrack("",digits);
        }
        return ans;
    }

    void backtrack(String pre, String nextNum){
        if(nextNum.length()==0) ans.add(pre);
        else {
            String num=nextNum.substring(0,1);
            String letters=map.get(num);
            for(int i=0; i<letters.length(); ++i){
                String s=letters.substring(i,i+1);
                backtrack(pre+s,nextNum.substring(1));
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }