//下一个数。给定一个正整数，找出与其二进制表达式中1的个数相同且大小最接近的那两个数（一个略大，一个略小）。 
//
// 示例1: 
//
// 
// 输入：num = 2（或者0b10）
// 输出：[4, 1] 或者（[0b100, 0b1]）
// 
//
// 示例2: 
//
// 
// 输入：num = 1
// 输出：[2, -1]
// 
//
// 提示: 
//
// 
// num的范围在[1, 2147483647]之间； 
// 如果找不到前一个或者后一个满足条件的正数，那么输出 -1。 
// 
// Related Topics 位运算 
// 👍 11 👎 0

  
  package leetcode.editor.cn;
  public class ClosedNumberLcci{
      public static void main(String[] args) {
           Solution solution = new ClosedNumberLcci().new Solution();
           solution.findClosedNumbers(2);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int[] findClosedNumbers(int num) {
        int count=count1(num);
        int[] ans=new int[]{-1,-1};
        for(int i=num+1; i<Integer.MAX_VALUE; ++i){
            if(count1(i)==count){
                ans[0]=i;
                break;
            }
        }
        for(int i=num-1; i>=1; --i){
            if(count1(i)==count){
                ans[1]=i;
                break;
            }
        }
        return ans;
    }

    int count1(int num){
        int ans=0;
        while (num!=0){
            if((num&1)==1) ans++;
            num>>=1;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }