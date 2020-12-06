//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。 
//
// 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
//输出: 2 
//
// 
//
// 限制： 
//
// 1 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 169 题相同：https://leetcode-cn.com/problems/majority-element/ 
//
// 
// Related Topics 位运算 分治算法 
// 👍 38 👎 0

  
  package leetcode.editor.cn;
  public class ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof{
      public static void main(String[] args) {
           Solution solution = new ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
//        qsort(nums,0,nums.length-1);
//        return nums[nums.length/2];
        int vote=0, ans=-1;
        for(int i=0; i<nums.length; ++i){
            if(vote==0) ans=nums[i];
            vote+=nums[i]==ans?1:-1;
        }
        return ans;
    }

    void qsort(int[] nums, int begin, int end){
        if(begin<end){
            int p=partition(nums,begin,end);
            qsort(nums,begin,p-1);
            qsort(nums,p+1,end);
        }
    }

    int partition(int[] nums, int begin, int end){
        int p=nums[end];
        int i=begin;
        for(int j=begin; j<end; ++j){
            if(nums[j]<p){
                swap(nums,i,j);
                i++;
            }
        }
        swap(nums,i,end);
        return i;
    }

    void swap(int[] nums, int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }