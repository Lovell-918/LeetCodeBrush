//统计一个数字在排序数组中出现的次数。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
// Related Topics 数组 二分查找 
// 👍 43 👎 0

  
  package leetcode.editor.cn;
  public class ZaiPaiXuShuZuZhongChaZhaoShuZiLcof{
      public static void main(String[] args) {
           Solution solution = new ZaiPaiXuShuZuZhongChaZhaoShuZiLcof().new Solution();
           solution.search(new int[]{5,7,7,8,8,10},8);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==0) return 0;
        int le=findLeft(nums,target);
        int ri=findRight(nums,target);
        if(le==ri&&le==-1) return 0;
        return ri-le+1;
    }

    int findLeft(int[] nums, int target){
        int start=0, end=nums.length-1;
        int mid;
        while (start+1<end){
            mid=start+(end-start)/2;
            if(nums[mid]>=target) end=mid;
            else start=mid;
        }
        if(nums[start]==target) return start;
        else if(nums[end]==target) return end;
        else return -1;
    }

    int findRight(int[] nums, int target){
        int start=0, end=nums.length-1;
        int mid;
        while (start+1<end){
            mid=start+(end-start)/2;
            if(nums[mid]<=target) start=mid;
            else end=mid;
        }
        if(nums[end]==target) return end;
        else if(nums[start]==target) return start;
        else return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }