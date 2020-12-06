//给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。 
//
// 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。 
//
// 说明: 
//
// 
// 返回的下标值（index1 和 index2）不是从零开始的。 
// 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。 
// 
//
// 示例: 
//
// 输入: numbers = [2, 7, 11, 15], target = 9
//输出: [1,2]
//解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。 
// Related Topics 数组 双指针 二分查找

  
  package leetcode.editor.cn;
  public class TwoSumIiInputArrayIsSorted{
      public static void main(String[] args) {
           Solution solution = new TwoSumIiInputArrayIsSorted().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //双指针
//        int left=0, right=numbers.length-1;
//        while (left<right){
//            int t=numbers[left]+numbers[right];
//            if(t==target) return new int[]{left+1,right+1};
//            if(t<target) left++;
//            else right--;
//        }
        //二分法
        for (int i=0; i<numbers.length; ++i){
            int t=binarySearch(numbers,target-numbers[i],i+1,numbers.length-1);
            if(t!=-1) return new int[]{i+1,t+1};
        }
        return new int[2];
    }
    int binarySearch(int[] numbers,int tar, int left, int right){
        while (left<=right) {
            int mid = (left + right) / 2;
            if(numbers[mid]==tar) return mid;
            else if(numbers[mid]<tar) left = mid+1;
            else right = mid-1;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }