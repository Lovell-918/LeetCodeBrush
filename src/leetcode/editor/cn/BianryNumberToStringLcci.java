//二进制数转字符串。给定一个介于0和1之间的实数（如0.72），类型为double，打印它的二进制表达式。如果该数字不在0和1之间，或者无法精确地用32位以内
//的二进制表示，则打印“ERROR”。 
//
// 示例1: 
//
//  输入：0.625
// 输出："0.101"
// 
//
// 示例2: 
//
//  输入：0.1
// 输出："ERROR"
// 提示：0.1无法被二进制准确表示
// 
//
// 提示： 
//
// 
// 32位包括输出中的"0."这两位。 
// 
// Related Topics 字符串 
// 👍 8 👎 0

  
  package leetcode.editor.cn;
  public class BianryNumberToStringLcci{
      public static void main(String[] args) {
           Solution solution = new BianryNumberToStringLcci().new Solution();
           solution.printBin(0.625);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String printBin(double num) {
        StringBuilder sb=new StringBuilder();
        sb.append("0.");
        while (num!=0){
            num*=2;
            if(num>=1){
                sb.append(1);
                num-=1;
            }else {
                sb.append(0);
            }
            if(sb.length()>32) return "ERROR";
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }