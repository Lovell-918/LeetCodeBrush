//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。 
//
// 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。 
//
// 你可以假设 nums1 和 nums2 不会同时为空。 
//
// 
//
// 示例 1: 
//
// nums1 = [1, 3]
//nums2 = [2]
//
//则中位数是 2.0
// 
//
// 示例 2: 
//
// nums1 = [1, 2]
//nums2 = [3, 4]
//
//则中位数是 (2 + 3)/2 = 2.5
// 
// Related Topics 数组 二分查找 分治算法 
// 👍 2901 👎 0

  
  package leetcode.editor.cn;
  public class MedianOfTwoSortedArrays{
      public static void main(String[] args) {
           Solution solution = new MedianOfTwoSortedArrays().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1=nums1.length, len2=nums2.length;
        int sum=len1+len2;
        if(sum%2==1){
            return findKthElement(nums1,nums2,sum/2+1);
        }else {
            int i=findKthElement(nums1,nums2,sum/2);
            int j=findKthElement(nums1,nums2,sum/2+1);
            return (i+j)/2.0;
        }
    }

    int findKthElement(int[] nums1, int[] nums2, int k){
        int index1=0, index2=0;
        while (true){
            if(index1==nums1.length){
                return nums2[index2+k-1];
            }
            if(index2==nums2.length){
                return nums1[index1+k-1];
            }
            if(k==1){
                return Math.min(nums1[index1],nums2[index2]);
            }
            int half=k/2-1;
            int nIndex1=Math.min(index1+half,nums1.length-1);
            int nIndex2=Math.min(index2+half,nums2.length-1);
            if(nums1[nIndex1]<nums2[nIndex2]){
                k-=(nIndex1-index1)+1;
                index1=nIndex1+1;
            }else {
                k-=(nIndex2-index2)+1;
                index2=nIndex2+1;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }