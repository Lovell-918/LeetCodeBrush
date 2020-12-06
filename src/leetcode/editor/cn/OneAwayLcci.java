//字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。 
//
// 
//
// 示例 1: 
//
// 输入: 
//first = "pale"
//second = "ple"
//输出: True 
//
// 
//
// 示例 2: 
//
// 输入: 
//first = "pales"
//second = "pal"
//输出: False
// 
// Related Topics 字符串 动态规划 
// 👍 36 👎 0

  
  package leetcode.editor.cn;
  public class OneAwayLcci{
      public static void main(String[] args) {
           Solution solution = new OneAwayLcci().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean oneEditAway(String first, String second) {
        if(Math.abs(first.length()-second.length())>1) return false;
        if(first.length()==second.length()&&first.equals(second)) return true;
        int i=0;
        int j=first.length()-1, k=second.length()-1;
        while (i<first.length()&&i<second.length()){
            if (first.charAt(i)==second.charAt(i)){
                i++;
            }else break;
        }
        while (j>=0&&k>=0){
            if(first.charAt(j)==second.charAt(k)){
                j--;
                k--;
            }else break;
        }
        return j-i<1&&k-i<1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }