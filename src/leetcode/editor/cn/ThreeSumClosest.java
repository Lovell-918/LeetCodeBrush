//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 
//
// 示例： 
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 双指针 
// 👍 516 👎 0

  
  package leetcode.editor.cn;

import java.util.Arrays;

public class ThreeSumClosest{
      public static void main(String[] args) {
           Solution solution = new ThreeSumClosest().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans=1000000;
        for(int a=0; a<nums.length; ++a){
            if(a>0&&nums[a]==nums[a-1]){
                continue;
            }
            int b=a+1, c=nums.length-1;
            while (b<c){
                int sum=nums[a]+nums[b]+nums[c];
                if(sum==target) return sum;
                if(Math.abs(sum-target)<Math.abs(ans-target)){
                    ans=sum;
                }
                if(sum<target){
                    int b0=b+1;
                    while (b0<c&&nums[b0]==nums[b]) b0++;
                    b=b0;
                }else {
                    int c0=c-1;
                    while (b<c0&&nums[c0]==nums[c]) c0--;
                    c=c0;
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }