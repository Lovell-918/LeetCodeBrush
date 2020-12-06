//给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。 
//
// 返回符合要求的最少分割次数。 
//
// 示例: 
//
// 输入: "aab"
//输出: 1
//解释: 进行一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
// 
// Related Topics 动态规划

  
  package leetcode.editor.cn;
  public class PalindromePartitioningIi{
      public static void main(String[] args) {
           Solution solution = new PalindromePartitioningIi().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minCut(String s) {
        if(s.length()<=1) return 0;
        int[] dp=new int[s.length()+1];
        dp[0]=-1;
        for(int i=1; i<=s.length(); ++i){
            dp[i]=i-1;
            if(isPali(s,0,i-1)){
                dp[i]=0;
                continue;
            }
            for(int j=0; j<i; ++j){
                if(isPali(s,j,i-1))
                dp[i]=Math.min(dp[i], dp[j]+1);
            }
        }
        return dp[s.length()];
    }

    boolean isPali(String s, int i, int j){
        while (i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }