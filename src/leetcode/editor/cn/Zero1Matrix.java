//给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。 
//
// 两个相邻元素间的距离为 1 。 
//
// 示例 1: 
//输入: 
//
// 
//0 0 0
//0 1 0
//0 0 0
// 
//
// 输出: 
//
// 
//0 0 0
//0 1 0
//0 0 0
// 
//
// 示例 2: 
//输入: 
//
// 
//0 0 0
//0 1 0
//1 1 1
// 
//
// 输出: 
//
// 
//0 0 0
//0 1 0
//1 2 1
// 
//
// 注意: 
//
// 
// 给定矩阵的元素个数不超过 10000。 
// 给定矩阵中至少有一个元素是 0。 
// 矩阵中的元素只在四个方向上相邻: 上、下、左、右。 
// 
// Related Topics 深度优先搜索 广度优先搜索

  
  package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class Zero1Matrix{
      public static void main(String[] args) {
           Solution solution = new Zero1Matrix().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix==null||matrix.length==0) return null;
        int row=matrix.length, line=matrix[0].length;
        int[][] ans = new int[row][line];
        boolean[][] visited = new boolean[row][line];
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<row; ++i){
            for(int j=0; j<line; ++j){
                if(matrix[i][j]==0){
                    visited[i][j]=true;
                    queue.offer(new int[]{i,j});
                }
            }
        }
        int[][] dire = {{-1,0},{1,0},{0,-1},{0,1}};
        while (!queue.isEmpty()){
            int[] pos=queue.poll();
            int n=pos[0], m=pos[1];
            for (int i=0; i<4; ++i){
                int posI=n+dire[i][0], posJ=m+dire[i][1];
                if(posI>=0&&posI<row&&posJ>=0&&posJ<line&&!visited[posI][posJ]){
                    ans[posI][posJ]=ans[n][m]+1;
                    visited[posI][posJ]=true;
                    queue.offer(new int[]{posI,posJ});
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }