//给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。 
//
// 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。 
//
// 
//
// 示例 1： 
//
// 输入：
//  s = "barfoothefoobarman",
//  words = ["foo","bar"]
//输出：[0,9]
//解释：
//从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
//输出的顺序不重要, [9,0] 也是有效答案。
// 
//
// 示例 2： 
//
// 输入：
//  s = "wordgoodgoodgoodbestword",
//  words = ["word","good","best","word"]
//输出：[]
// 
// Related Topics 哈希表 双指针 字符串 
// 👍 309 👎 0

  
  package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringWithConcatenationOfAllWords{
      public static void main(String[] args) {
           Solution solution = new SubstringWithConcatenationOfAllWords().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        if(words==null||words.length==0) return new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        HashMap<String, Integer> map=new HashMap<>();
        int wordLen=words[0].length();
        for(String w:words){
            map.put(w,map.getOrDefault(w,0)+1);
        }
        for(int i=0; i<wordLen; ++i){
            int left=i, right=i, count=0;
            HashMap<String, Integer> tempMap=new HashMap<>();
            while (right+wordLen<=s.length()){
                String temp=s.substring(right,right+wordLen);
                tempMap.put(temp,tempMap.getOrDefault(temp,0)+1);
                right+=wordLen;
                count++;
                while (tempMap.get(temp)>map.getOrDefault(temp,0)){
                    String tempL=s.substring(left,left+wordLen);
                    tempMap.put(tempL,tempMap.getOrDefault(tempL,0)-1);
                    count--;
                    left+=wordLen;
                }
                if(count==words.length) ans.add(left);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }