//给定一个32位整数 num，你可以将一个数位从0变为1。请编写一个程序，找出你能够获得的最长的一串1的长度。 
//
// 示例 1： 
//
// 输入: num = 1775(110111011112)
//输出: 8
// 
//
// 示例 2： 
//
// 输入: num = 7(01112)
//输出: 4
// 
// Related Topics 位运算 
// 👍 13 👎 0

  
  package leetcode.editor.cn;
  public class ReverseBitsLcci{
      public static void main(String[] args) {
           Solution solution = new ReverseBitsLcci().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverseBits(int num) {
        int ans=0;
        int right=0;
        int i=0;
        while (i<32){
            if((num&1)==0){
                int left=0;
                num>>=1;
                i++;
                while (num!=0&&(num&1)!=0){
                    left++;
                    num>>=1;
                    i++;
                }
                ans=Math.max(ans,left+right+1);
                right=left;
            }else {
                right++;
                num>>=1;
                i++;
            }
        }
        return Math.max(ans,right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }