//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串

  
  package leetcode.editor.cn;
  public class ValidPalindrome{
      public static void main(String[] args) {
           Solution solution = new ValidPalindrome().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        if(s==null||s.equals("")) return true;
        char[] chars = s.toCharArray();
        int i=0, j=chars.length-1;
        while (i<j){
            while (!Character.isLetterOrDigit(chars[i])&&i<j) i++;
            while (!Character.isLetterOrDigit(chars[j])&&i<j) j--;
            if(Character.toLowerCase(chars[i])!=Character.toLowerCase(chars[j])) return false;
            i++;
            j--;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }