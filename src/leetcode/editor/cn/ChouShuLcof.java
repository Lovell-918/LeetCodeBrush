//我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。 
//
// 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
//
// 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/ 
// Related Topics 数学 
// 👍 41 👎 0

  
  package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class ChouShuLcof{
      public static void main(String[] args) {
           Solution solution = new ChouShuLcof().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nthUglyNumber(int n) {
        List<Integer> uglyList=new ArrayList<>();
        uglyList.add(1);
        int pre=1;
        int m2=0, m3=0, m5=0;
        while (uglyList.size()<n){
            for(int i:uglyList){
                m2=2*i;
                if(m2>pre) break;
            }
            for(int i:uglyList){
                m3=3*i;
                if(m3>pre) break;
            }
            for(int i:uglyList){
                m5=5*i;
                if(m5>pre) break;
            }
            pre = Math.min(m2,Math.min(m3,m5));
            uglyList.add(pre);
        }
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }