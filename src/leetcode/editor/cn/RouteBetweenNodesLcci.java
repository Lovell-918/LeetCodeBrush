//节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。 
//
// 示例1: 
//
//  输入：n = 3, graph = [[0, 1], [0, 2], [1, 2], [1, 2]], start = 0, target = 2
// 输出：true
// 
//
// 示例2: 
//
//  输入：n = 5, graph = [[0, 1], [0, 2], [0, 4], [0, 4], [0, 1], [1, 3], [1, 4], [
//1, 3], [2, 3], [3, 4]], start = 0, target = 4
// 输出 true
// 
//
// 提示： 
//
// 
// 节点数量n在[0, 1e5]范围内。 
// 节点编号大于等于 0 小于 n。 
// 图中可能存在自环和平行边。 
// 
// Related Topics 图 
// 👍 12 👎 0

  
  package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RouteBetweenNodesLcci{
      public static void main(String[] args) {
           Solution solution = new RouteBetweenNodesLcci().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        List<Integer>[] adj=new ArrayList[n];
        for(int[] e:graph){
            int f=e[0];
            int t=e[1];
            if(adj[f]==null) adj[f]=new ArrayList<>();
            adj[f].add(t);
        }
        return bfs(n,adj,start,target);
    }

    boolean bfs(int n, List<Integer>[] adj, int start, int target){
        LinkedList<Integer> queue=new LinkedList<>();
        boolean[] visited=new boolean[n];
        queue.addLast(start);
        visited[start]=true;
        while (!queue.isEmpty()){
            int t=queue.removeFirst();
            List<Integer> list=adj[t];
            if(list==null) continue;
            for(int i:list){
                if(i==target) return true;
                if(visited[i]) continue;
                visited[i]=true;
                queue.addLast(i);
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }