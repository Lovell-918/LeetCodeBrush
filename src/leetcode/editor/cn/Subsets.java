//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法

  
  package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class Subsets{
      public static void main(String[] args) {
           Solution solution = new Subsets().new Solution();
           solution.subsets(new int[]{1,2,3});
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> ans = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums,0, new LinkedList<>());
        return ans;
    }

    void backtrack(int[] nums, int pos, List<Integer> temp){
        ans.add(new LinkedList<>(temp));
        for(int i=pos; i<nums.length; ++i){
            temp.add(nums[i]);
            backtrack(nums,i+1, temp);
            temp.remove(temp.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }