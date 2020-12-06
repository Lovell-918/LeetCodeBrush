//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。 
//
// 换句话说，第一个字符串的排列之一是第二个字符串的子串。 
//
// 示例1: 
//
// 
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
// 
//
// 
//
// 示例2: 
//
// 
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
// 
//
// 
//
// 注意： 
//
// 
// 输入的字符串只包含小写字母 
// 两个字符串的长度都在 [1, 10,000] 之间 
// 
// Related Topics 双指针 Sliding Window

  
  package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString{
      public static void main(String[] args) {
           Solution solution = new PermutationInString().new Solution();
           solution.checkInclusion("abcdxabcde","abcdeabcdx");
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> win = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for(char c:s1.toCharArray()){
            need.put(c,need.getOrDefault(c,0)+1);
        }
        int left=0, right=0, match=0;
        char c;
        while (right<s2.length()){
            c=s2.charAt(right);
            right++;
            if(need.containsKey(c)){
                win.put(c,win.getOrDefault(c,0)+1);
                if(win.get(c).equals(need.get(c))){
                    match++;
                }
            }
            while (right-left>=s1.length()){
                if(match==need.size()) return true;
                c = s2.charAt(left);
                left++;
                if(need.containsKey(c)){
                    if(win.get(c).equals(need.get(c))){
                        match--;
                    }
                    win.put(c,win.getOrDefault(c,0)-1);
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }