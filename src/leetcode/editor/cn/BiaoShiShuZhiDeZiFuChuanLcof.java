//请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"0123"都表示数值，但
//"12e"、"1a3.14"、"1.2.3"、"+-5"、"-1E-16"及"12e+5.4"都不是。 
//
// 
//
// 注意：本题与主站 65 题相同：https://leetcode-cn.com/problems/valid-number/ 
// Related Topics 数学 
// 👍 25 👎 0

  
  package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class BiaoShiShuZhiDeZiFuChuanLcof{
      public static void main(String[] args) {
           Solution solution = new BiaoShiShuZhiDeZiFuChuanLcof().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isNumber(String s) {
        Map[] states={
                new HashMap<Character,Integer>(){{put(' ',0);put('s',1);
                put('.',4);put('d',2);}},
                new HashMap<Character,Integer>(){{put('.',4);put('d',2);}},
                new HashMap<Character,Integer>(){{put('d',2);put('.',3);
                put('e',5);put(' ',8);}},
                new HashMap<Character,Integer>(){{put('d',3);put(' ',8);
                put('e',5);}},
                new HashMap<Character,Integer>(){{put('d',3);}},
                new HashMap<Character,Integer>(){{put('s',6);put('d',7);}},
                new HashMap<Character,Integer>(){{put('d',7);}},
                new HashMap<Character,Integer>(){{put('d',7);put(' ',8);}},
                new HashMap<Character,Integer>(){{put(' ',8);}}
        };
        char t;
        int p=0;
        for(char c:s.toCharArray()){
            if(Character.isDigit(c)) t='d';
            else if(c=='+'||c=='-') t='s';
            else if(c==' '||c=='.'||c=='e') t=c;
            else t='?';
            if(!states[p].containsKey(t)) return false;
            p = (int)states[p].get(t);
        }
        return p==2||p==3||p==7||p==8;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }