//给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。 
//
// 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。 
//
// 回文串不一定是字典当中的单词。 
//
// 
//
// 示例1： 
//
// 输入："tactcoa"
//输出：true（排列有"tacocat"、"atcocta"，等等）
// 
//
// 
// Related Topics 哈希表 字符串 
// 👍 32 👎 0

  
  package leetcode.editor.cn;

import java.util.HashMap;

public class PalindromePermutationLcci{
      public static void main(String[] args) {
           Solution solution = new PalindromePermutationLcci().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPermutePalindrome(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(char c:s.toCharArray()){
            if(map.getOrDefault(c,0)==0){
                map.put(c,1);
            }else {
                map.remove(c);
            }
        }
        return map.size()==1||map.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }