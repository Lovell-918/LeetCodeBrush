//稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。 
//
// 示例1: 
//
//  输入: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""],
// s = "ta"
// 输出：-1
// 说明: 不存在返回-1。
// 
//
// 示例2: 
//
//  输入：words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], 
//s = "ball"
// 输出：4
// 
//
// 提示: 
//
// 
// words的长度在[1, 1000000]之间 
// 
// Related Topics 二分查找 
// 👍 18 👎 0

  
  package leetcode.editor.cn;
  public class SparseArraySearchLcci{
      public static void main(String[] args) {
           Solution solution = new SparseArraySearchLcci().new Solution();
          String[] words=new String[]{"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
          System.out.println(solution.findString(words,"ball"));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findString(String[] words, String s) {
        int left=0, right=words.length;
        int mid;
        int temp;
        while(left<right){
            mid=left+(right-left)/2;
            temp=mid;
            while(mid<right&&words[mid].equals("")){
                mid++;
            }
            if(mid==right){
                right=temp;
                continue;
            }
            if(words[mid].equals(s)) return mid;
            else if(words[mid].compareTo(s)>0){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }