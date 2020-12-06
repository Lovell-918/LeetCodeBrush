//输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。 
//
// 
//
// 示例 1: 
//
// 输入: [10,2]
//输出: "102" 
//
// 示例 2: 
//
// 输入: [3,30,34,5,9]
//输出: "3033459" 
//
// 
//
// 提示: 
//
// 
// 0 < nums.length <= 100 
// 
//
// 说明: 
//
// 
// 输出结果可能非常大，所以你需要返回一个字符串而不是整数 
// 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0 
// 
// Related Topics 排序 
// 👍 59 👎 0

  
  package leetcode.editor.cn;
  public class BaShuZuPaiChengZuiXiaoDeShuLcof{
      public static void main(String[] args) {
           Solution solution = new BaShuZuPaiChengZuiXiaoDeShuLcof().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minNumber(int[] nums) {
        qsort(nums,0,nums.length-1);
        StringBuilder sb=new StringBuilder();
        for(int i:nums){
            sb.append(i);
        }
        return sb.toString();
    }

    void qsort(int[] nums, int start, int end){
        if(start<end){
            int p=partition(nums,start,end);
            qsort(nums,start,p-1);
            qsort(nums,p+1,end);
        }
    }

    int partition(int[] nums, int start, int end){
        int p=nums[end];
        int i=start;
        for(int j=start; j<end; ++j){
            if(lessThan(nums[j],p)){
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

    boolean lessThan(int i, int j){
        String s1=String.valueOf(i);
        String s2 = String.valueOf(j);
        return Long.parseLong(s1 + s2) <
                Long.parseLong(s2 + s1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }