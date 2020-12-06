//给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: [1,2,2]
//输出:
//[
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
//] 
// Related Topics 数组 回溯算法

  
  package leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetsIi{
      public static void main(String[] args) {
           Solution solution = new SubsetsIi().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> ans=new LinkedList<>();
    List<Integer> temp=new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums,0);
        return ans;
    }

    void backtrack(int[] nums, int pos){
        ans.add(new LinkedList<>(temp));
        for (int i=pos; i<nums.length; ++i){
            if(i!=pos&&nums[i]==nums[i-1])
                continue;
            temp.add(nums[i]);
            backtrack(nums,i+1);
            temp.remove(temp.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }