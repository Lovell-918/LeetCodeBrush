//给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。 
//
// 示例： 
//
// 输入: S = "ADOBECODEBANC", T = "ABC"
//输出: "BANC" 
//
// 说明： 
//
// 
// 如果 S 中不存这样的子串，则返回空字符串 ""。 
// 如果 S 中存在这样的子串，我们保证它是唯一的答案。 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window

  
  package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring{
      public static void main(String[] args) {
           Solution solution = new MinimumWindowSubstring().new Solution();
           solution.minWindow("ADOBECODEBANC","ABC");
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> win = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for(char c:t.toCharArray()){
            need.put(c,need.getOrDefault(c,0)+1);
        }
        int left=0, right=0, match=0;
        int start=0, end=0;
        int min = Integer.MAX_VALUE;
        char c;
        while (right<s.length()){
            c=s.charAt(right);
            right++;
            if(need.containsKey(c)){
                win.put(c,win.getOrDefault(c,0)+1);
                if(win.get(c).equals(need.get(c))){
                    match++;
                }
            }
            while (match==need.size()){
                if(right-left<min){
                    min=right-left;
                    start=left;
                    end=right;
                }
                c=s.charAt(left);
                left++;
                if(need.containsKey(c)){
                    if(win.get(c).equals(need.get(c))){
                        match--;
                    }
                    win.put(c,win.getOrDefault(c,0)-1);
                }
            }
        }
        if(min == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(start,end);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }