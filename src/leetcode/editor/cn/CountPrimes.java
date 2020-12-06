//统计所有小于非负整数 n 的质数的数量。 
//
// 示例: 
//
// 输入: 10
//输出: 4
//解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
// 
// Related Topics 哈希表 数学

  
  package leetcode.editor.cn;

import java.util.Arrays;

public class CountPrimes{
      public static void main(String[] args) {
           Solution solution = new CountPrimes().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countPrimes(int n) {
        if(n<2) return 0;
        boolean[] prims = new boolean[n];
        Arrays.fill(prims,true);
        for(int i=2; i*i<n; ++i){
            if(prims[i]){
                for(int j=i*i; j<n; j+=i){
                    prims[j]=false;
                }
            }
        }
        int count=0;
        for (int i=2; i<n; ++i){
            if(prims[i]) count++;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }