//编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。 
//
// 
//
// 示例 1： 
//
// 输入：
//[
//  [1,1,1],
//  [1,0,1],
//  [1,1,1]
//]
//输出：
//[
//  [1,0,1],
//  [0,0,0],
//  [1,0,1]
//]
// 
//
// 示例 2： 
//
// 输入：
//[
//  [0,1,2,0],
//  [3,4,5,2],
//  [1,3,1,5]
//]
//输出：
//[
//  [0,0,0,0],
//  [0,4,5,0],
//  [0,3,1,0]
//]
// 
// Related Topics 数组 
// 👍 14 👎 0

  
  package leetcode.editor.cn;
  public class ZeroMatrixLcci{
      public static void main(String[] args) {
           Solution solution = new ZeroMatrixLcci().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        boolean row0=false, cow0=false;
        for(int i=0; i<m; ++i){
            if(matrix[i][0]==0){
                cow0=true;
                break;
            }
        }
        for(int i=0; i<n; ++i){
            if(matrix[0][i]==0){
                row0=true;
                break;
            }
        }
        for(int i=1; i<m; ++i){
            for (int j=1; j<n; ++j){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        for(int i=1; i<m; ++i){
            if(matrix[i][0]==0) matrix[i]=new int[n];
        }
        for(int i=1; i<n; ++i){
            if(matrix[0][i]==0){
                for(int j=0; j<m; ++j) matrix[j][i]=0;
            }
        }
        if(row0) matrix[0]=new int[n];
        if(cow0){
            for(int i=0;i<m;++i) matrix[i][0]=0;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }