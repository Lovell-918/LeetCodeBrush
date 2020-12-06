//一只蚂蚁坐在由白色和黑色方格构成的无限网格上。开始时，网格全白，蚂蚁面向右侧。每行走一步，蚂蚁执行以下操作。 
//
// (1) 如果在白色方格上，则翻转方格的颜色，向右(顺时针)转 90 度，并向前移动一个单位。 
//(2) 如果在黑色方格上，则翻转方格的颜色，向左(逆时针方向)转 90 度，并向前移动一个单位。 
//
// 编写程序来模拟蚂蚁执行的前 K 个动作，并返回最终的网格。 
//
// 网格由数组表示，每个元素是一个字符串，代表网格中的一行，黑色方格由 'X' 表示，白色方格由 '_' 表示，蚂蚁所在的位置由 'L', 'U', 'R',
// 'D' 表示，分别表示蚂蚁 左、上、右、下 的朝向。只需要返回能够包含蚂蚁走过的所有方格的最小矩形。 
//
// 示例 1: 
//
// 输入: 0
//输出: ["R"]
// 
//
// 示例 2: 
//
// 输入: 2
//输出:
//[
//  "_X",
//  "LX"
//]
// 
//
// 示例 3: 
//
// 输入: 5
//输出:
//[
//  "_U",
//  "X_",
//  "XX"
//]
// 
//
// 说明： 
//
// 
// K <= 100000 
// 
// Related Topics 数组 
// 👍 9 👎 0

  
  package leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.*;

public class LangtonsAntLcci{
      public static void main(String[] args) {
           Solution solution = new LangtonsAntLcci().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> printKMoves(int K) {
        char[] direction=new char[]{'L', 'U', 'R', 'D'};
        int[][] offset=new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
        Position antPos=new Position(0,0);
        int antDir=2;
        Set<Position> blackPos=new HashSet<>();
        while (K>0){
            Position temp=new Position(antPos.x,antPos.y);
            if(blackPos.contains(temp)){
                antDir=(antDir+3)%4;
                blackPos.remove(temp);
            }else {
                blackPos.add(temp);
                antDir=(antDir+1)%4;
            }
            antPos.x+=offset[antDir][0];
            antPos.y+=offset[antDir][1];
            --K;
        }
        int left=antPos.x, right=antPos.x, top=antPos.y, bottom=antPos.y;
        for(Position pos:blackPos){
            left=Math.min(pos.x,left);
            right=Math.max(pos.x,right);
            top=Math.min(pos.y,top);
            bottom=Math.max(pos.y,bottom);
        }
        char[][] grid=new char[bottom-top+1][right-left+1];
        for(char[] chars:grid){
            Arrays.fill(chars,'_');
        }
        for(Position pos:blackPos){
            grid[pos.y-top][pos.x-left]='X';
        }
        grid[antPos.y-top][antPos.x-left]=direction[antDir];
        List<String> ans=new ArrayList<>();
        for(char[] chars:grid){
            ans.add(String.valueOf(chars));
        }
        return ans;
    }

    class Position{
        int x,y;
        public Position(int x, int y){
            this.x=x;
            this.y=y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return x == position.x &&
                    y == position.y;
        }

        @Override
        public int hashCode() {
            return 31*x+y;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }