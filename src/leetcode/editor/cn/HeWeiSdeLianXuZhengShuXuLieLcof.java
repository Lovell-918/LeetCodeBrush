//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。 
//
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。 
//
// 
//
// 示例 1： 
//
// 输入：target = 9
//输出：[[2,3,4],[4,5]]
// 
//
// 示例 2： 
//
// 输入：target = 15
//输出：[[1,2,3,4,5],[4,5,6],[7,8]]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= target <= 10^5 
// 
//
// 
// 👍 121 👎 0

  
  package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class HeWeiSdeLianXuZhengShuXuLieLcof{
      public static void main(String[] args) {
           Solution solution = new HeWeiSdeLianXuZhengShuXuLieLcof().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] findContinuousSequence(int target) {
        int end=(target&1)==0?target/2:(target+1)/2;
        int[] nums=new int[end];
        for(int i=1; i<=end; ++i){
            nums[i-1]=i;
        }
        List<List<Integer>> ansList=new ArrayList<>();
        LinkedList<Integer> sinList=new LinkedList<>();
        int left=0, right=0;
        int sum=0;
        while (right<end){
            while (sum<target&&right<end){
                sinList.add(nums[right]);
                sum+=nums[right];
                right++;
            }
            while (sum>=target&&left<end){
                if(sum==target){
                    ansList.add(new ArrayList<>(sinList));
                }
                sinList.removeFirst();
                sum-=nums[left];
                left++;
            }
        }
        int[][] ans=new int[ansList.size()][];
        for(int i=0; i<ansList.size(); ++i){
            int[] temp=new int[ansList.get(i).size()];
            for(int j=0; j<ansList.get(i).size(); ++j){
                temp[j]=ansList.get(i).get(j);
            }
            ans[i]= temp;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }