//给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。 
//
// 示例 : 
//
// 输入: [1,2,1,3,2,5]
//输出: [3,5] 
//
// 注意： 
//
// 
// 结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。 
// 你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？ 
// 
// Related Topics 位运算

  
  package leetcode.editor.cn;
  public class SingleNumberIii{
      public static void main(String[] args) {
           Solution solution = new SingleNumberIii().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] singleNumber(int[] nums) {
        int mask = 0;
        for(int n:nums) mask^=n;
        int diff = mask&(-mask);
        int x=0;
        for (int n:nums) if((n&diff)!=0) x^=n;
        return new int[]{x,mask^x};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }