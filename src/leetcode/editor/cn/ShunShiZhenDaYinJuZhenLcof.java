//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
// Related Topics 数组 
// 👍 103 👎 0

  
  package leetcode.editor.cn;
  public class ShunShiZhenDaYinJuZhenLcof{
      public static void main(String[] args) {
           Solution solution = new ShunShiZhenDaYinJuZhenLcof().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return new int[0];
        }
        int row=matrix.length, line=matrix[0].length;
        int[] ans=new int[row*line];
        int left=0, right=line-1, top=0, bottom=row-1;
        int index=0;
        while (left<=right&&top<=bottom){
            for(int c=left; c<=right; c++){
                ans[index]=matrix[top][c];
                index++;
            }
            for (int r=top+1; r<=bottom; ++r){
                ans[index]=matrix[r][right];
                index++;
            }
            if(right>left&&bottom>top) {
                for (int c = right - 1; c >= left; --c) {
                    ans[index] = matrix[bottom][c];
                    index++;
                }
                for (int r = bottom-1; r > top; --r) {
                    ans[index] = matrix[r][left];
                    index++;
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }