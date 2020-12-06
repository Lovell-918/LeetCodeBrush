//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。 
//
// 示例: 
//
// s = "abaccdeff"
//返回 "b"
//
//s = "" 
//返回 " "
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
// Related Topics 哈希表 
// 👍 34 👎 0

  
  package leetcode.editor.cn;

import java.util.LinkedHashMap;
import java.util.Map;

public class DiYiGeZhiChuXianYiCiDeZiFuLcof{
      public static void main(String[] args) {
           Solution solution = new DiYiGeZhiChuXianYiCiDeZiFuLcof().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char firstUniqChar(String s) {
        Map<Character,Boolean> map=new LinkedHashMap<>();
        for(char c:s.toCharArray()){
            map.put(c,!map.containsKey(c));
        }
        for(Map.Entry<Character,Boolean> entry:map.entrySet()){
            if(entry.getValue()) return entry.getKey();
        }
        return ' ';
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }