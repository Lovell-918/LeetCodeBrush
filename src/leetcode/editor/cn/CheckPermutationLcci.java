//给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。 
//
// 示例 1： 
//
// 输入: s1 = "abc", s2 = "bca"
//输出: true 
// 
//
// 示例 2： 
//
// 输入: s1 = "abc", s2 = "bad"
//输出: false
// 
//
// 说明： 
//
// 
// 0 <= len(s1) <= 100 
// 0 <= len(s2) <= 100 
// 
// Related Topics 数组 字符串 
// 👍 15 👎 0

  
  package leetcode.editor.cn;
  public class CheckPermutationLcci{
      public static void main(String[] args) {
           Solution solution = new CheckPermutationLcci().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        if(s1.length()!=s2.length()) return false;
        int len=s1.length();
        int[] nums1=new int[26];
        int[] nums2=new int[26];
        for(int i=0; i<len; ++i){
            nums1[s1.charAt(i)-'a']++;
            nums2[s2.charAt(i)-'a']++;
        }
        for(int i=0; i<26; ++i){
            if(nums1[i]!=nums2[i]) return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }