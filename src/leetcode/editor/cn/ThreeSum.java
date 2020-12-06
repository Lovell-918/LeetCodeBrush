//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2411 👎 0

  
  package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum{
      public static void main(String[] args) {
           Solution solution = new ThreeSum().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        for(int first=0; first<nums.length; ++first){
            if(first>0&&nums[first]==nums[first-1]) continue;
            int third=nums.length-1, target=-nums[first];
            for(int second=first+1; second<nums.length; ++second){
                if(second>first+1&&nums[second]==nums[second-1]) continue;
                while (second<third&&nums[second]+nums[third]>target)
                    third--;
                if(second==third) break;
                if(nums[second]+nums[third]==target){
                    ans.add(Arrays.asList(
                            nums[first],nums[second],nums[third]));
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }