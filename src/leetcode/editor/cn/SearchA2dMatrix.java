//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 示例 1: 
//
// 输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 13
//输出: false 
// Related Topics 数组 二分查找

  
  package leetcode.editor.cn;
  public class SearchA2dMatrix{
      public static void main(String[] args) {
           Solution solution = new SearchA2dMatrix().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0||matrix[0].length==0) return false;
        int row = matrix.length;
        int line = matrix[0].length;
        int start=0, end=row*line-1, mid, val;
        while (start+1<end){
            mid = start+(end-start)/2;
            val = matrix[mid/line][mid%line];
            if(val==target) return true;
            else if(val<target) start=mid;
            else if(val>target) end=mid;
        }
        if(matrix[start/line][start%line]==target
                ||matrix[end/line][end%line]==target) return true;
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }