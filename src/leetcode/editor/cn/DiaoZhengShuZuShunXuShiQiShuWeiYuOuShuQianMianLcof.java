//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。 
//
// 
//
// 示例： 
//
// 输入：nums = [1,2,3,4]
//输出：[1,3,2,4] 
//注：[3,1,2,4] 也是正确的答案之一。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50000 
// 1 <= nums[i] <= 10000 
// 
// 👍 29 👎 0

  
  package leetcode.editor.cn;
  public class DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof{
      public static void main(String[] args) {
           Solution solution = new DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] exchange(int[] nums) {
        int begin=0, end=nums.length-1;
        int t;
        while (begin<end){
            while ((nums[begin]&1)==1&&begin<end) begin++;
            while ((nums[end]&1)==0&&begin<end) end--;
            t=nums[begin];
            nums[begin]=nums[end];
            nums[end]=t;
            begin++;
            end--;
        }
        return nums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }