//给定一个可包含重复数字的序列，返回所有不重复的全排列。 
//
// 示例: 
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//] 
// Related Topics 回溯算法

  
  package leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermutationsIi{
      public static void main(String[] args) {
           Solution solution = new PermutationsIi().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> ans=new LinkedList<>();
    List<Integer> temp=new LinkedList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] visited=new boolean[nums.length];
        backtrack(nums,visited);
        return ans;
    }
    void backtrack(int[] nums, boolean[] visited){
        if(nums.length==temp.size()){
            ans.add(new LinkedList<>(temp));
            return;
        }
        for(int i=0; i<nums.length; ++i){
            if(visited[i]) continue;
            if(i!=0&&nums[i]==nums[i-1]&&!visited[i-1]) continue;
            visited[i]=true;
            temp.add(nums[i]);
            backtrack(nums,visited);
            temp.remove(temp.size()-1);
            visited[i]=false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }