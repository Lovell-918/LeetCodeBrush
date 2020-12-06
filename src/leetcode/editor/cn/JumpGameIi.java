//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。 
//
// 示例: 
//
// 输入: [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 说明: 
//
// 假设你总是可以到达数组的最后一个位置。 
// Related Topics 贪心算法 数组

  
  package leetcode.editor.cn;
  public class JumpGameIi{
      public static void main(String[] args) {
           Solution solution = new JumpGameIi().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int jump(int[] nums) {
        //动态规划超时
//        int len=nums.length;
//        int[] dp=new int[len];
//        dp[0]=0;
//        for(int i=1; i<len; ++i){
//            dp[i]=i;
//            for(int j=0; j<i; ++j){
//                if(nums[j]+j>=i)
//                dp[i]=Math.min(dp[j]+1,dp[i]);
//            }
//        }
//        return dp[len-1];
        int len=nums.length;
        int end=0;
        int maxPos=0;
        int ans=0;
        for(int i=0; i<len-1; ++i){
            maxPos = Math.max(maxPos, i+nums[i]);
            if(i==end){
                end=maxPos;
                ans++;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }