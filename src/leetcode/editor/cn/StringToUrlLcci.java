//URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，
//请使用字符数组实现，以便直接在数组上操作。） 
//
// 示例1: 
//
//  输入："Mr John Smith    ", 13
// 输出："Mr%20John%20Smith"
// 
//
// 示例2: 
//
//  输入："               ", 5
// 输出："%20%20%20%20%20"
// 
//
// 提示： 
//
// 
// 字符串长度在[0, 500000]范围内。 
// 
// Related Topics 字符串 
// 👍 17 👎 0

  
  package leetcode.editor.cn;
  public class StringToUrlLcci{
      public static void main(String[] args) {
           Solution solution = new StringToUrlLcci().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String replaceSpaces(String S, int length) {
        char[] ans=new char[3*length];
        int j=0;
        char c;
        for (int i=0; i<length; ++i){
            c=S.charAt(i);
            if(c==' '){
                ans[j++]='%';
                ans[j++]='2';
                ans[j++]='0';
            }else ans[j++]=c;
        }
        return new String(ans,0,j);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }