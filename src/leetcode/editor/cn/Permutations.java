//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法

  
  package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class Permutations{
      public static void main(String[] args) {
           Solution solution = new Permutations().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> ans=new LinkedList<>();
    List<Integer> temp=new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        backtrack(nums,visited);
        return ans;
    }

    void backtrack(int[] nums,boolean[] visited){
        if(temp.size()==nums.length){
            ans.add(new LinkedList<>(temp));
            return;
        }
        for(int i=0; i<nums.length; ++i){
            if(visited[i]) continue;
            temp.add(nums[i]);
            visited[i]=true;
            backtrack(nums,visited);
            visited[i]=false;
            temp.remove(temp.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }