//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。 
//
// 
//
// 示例 1: 
//
// 输入: [7,5,6,4]
//输出: 5 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
// 👍 189 👎 0

  
  package leetcode.editor.cn;

import java.util.Arrays;

public class ShuZuZhongDeNiXuDuiLcof{
      public static void main(String[] args) {
           Solution solution = new ShuZuZhongDeNiXuDuiLcof().new Solution();
           solution.reversePairs(new int[]{7,5,6,4});
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reversePairs(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int[] copy= Arrays.copyOf(nums,nums.length);
        return merge(nums,copy,0,nums.length-1);
    }

    int merge(int[] nums, int[] copy, int start, int end){
        if(start==end){
            copy[start]=nums[start];
            return 0;
        }

        int mid=(end-start)/2;
        int left=merge(copy,nums,start,start+mid);
        int right=merge(copy,nums,start+mid+1,end);
        int i=start+mid, j=end, inCopy=end;
        int count=0;
        while (i>=start&&j>=start+mid+1){
            if(nums[i]>nums[j]){
                copy[inCopy]=nums[i];
                count+=j-start-mid;
                inCopy--;
                i--;
            }else {
                copy[inCopy]=nums[j];
                inCopy--;
                j--;
            }
        }
        while (i>=start){
            copy[inCopy]=nums[i];
            inCopy--;
            i--;
        }
        while (j>=start+mid+1){
            copy[inCopy]=nums[j];
            inCopy--;
            j--;
        }
        return count+left+right;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }