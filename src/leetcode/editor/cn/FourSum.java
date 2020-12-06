//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意： 
//
// 答案中不可以包含重复的四元组。 
//
// 示例： 
//
// 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics 数组 哈希表 双指针 
// 👍 521 👎 0

  
  package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum{
      public static void main(String[] args) {
           Solution solution = new FourSum().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        for(int a=0; a<nums.length; ++a){
            if(a>0&&nums[a]==nums[a-1]) continue;
            for (int b=a+1;b<nums.length;++b){
                if(b>a+1&&nums[b]==nums[b-1]) continue;
                int c=b+1, d=nums.length-1;
                while (c<d){
                    int sum=nums[a]+nums[b]+nums[c]+nums[d];
                    if(sum<target) c++;
                    else if(sum>target) d--;
                    else {
                        ans.add(Arrays.asList(nums[a],nums[b],
                                nums[c],nums[d]));
                        while (c<d&&nums[c]==nums[c+1])
                            c++;
                        c++;
                        while (c<d&&nums[d]==nums[d-1])
                            d--;
                        d--;
                    }
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }