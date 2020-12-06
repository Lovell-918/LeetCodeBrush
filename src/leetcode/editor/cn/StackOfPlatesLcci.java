//堆盘子。设想有一堆盘子，堆太高可能会倒下来。因此，在现实生活中，盘子堆到一定高度时，我们就会另外堆一堆盘子。请实现数据结构SetOfStacks，模拟这种行
//为。SetOfStacks应该由多个栈组成，并且在前一个栈填满时新建一个栈。此外，SetOfStacks.push()和SetOfStacks.pop()应该与
//普通栈的操作方法相同（也就是说，pop()返回的值，应该跟只有一个栈时的情况一样）。 进阶：实现一个popAt(int index)方法，根据指定的子栈，执行p
//op操作。 
//
// 当某个栈为空时，应当删除该栈。当栈中没有元素或不存在该栈时，pop，popAt 应返回 -1. 
//
// 示例1: 
//
//  输入：
//["StackOfPlates", "push", "push", "popAt", "pop", "pop"]
//[[1], [1], [2], [1], [], []]
// 输出：
//[null, null, null, 2, 1, -1]
// 
//
// 示例2: 
//
//  输入：
//["StackOfPlates", "push", "push", "push", "popAt", "popAt", "popAt"]
//[[2], [1], [2], [3], [0], [0], [0]]
// 输出：
//[null, null, null, null, 2, 1, 3]
// 
// Related Topics 设计 
// 👍 5 👎 0

  
  package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StackOfPlatesLcci{
      public static void main(String[] args) {
          StackOfPlates solution = new StackOfPlatesLcci().new StackOfPlates(1);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class StackOfPlates {
    List<LinkedList<Integer>> stackSet;
    int cap;
    int size;
    public StackOfPlates(int cap) {
        stackSet=new ArrayList<>();
        this.cap=cap;
        size=-1;
    }
    
    public void push(int val) {
        if(stackSet.isEmpty()||stackSet.get(size).size()==cap){
            LinkedList<Integer> single=new LinkedList<>();
            single.offerLast(val);
            if(single.size()>cap) return;
            stackSet.add(single);
            size++;
        }else {
            stackSet.get(size).offerLast(val);
        }
    }
    
    public int pop() {
        if(stackSet.isEmpty()) return -1;
        int val=stackSet.get(size).pollLast();
        if(stackSet.get(size).isEmpty()){
            stackSet.remove(size);
            size--;
        }
        return val;
    }
    
    public int popAt(int index) {
        if(index>size) return -1;
        int val=stackSet.get(index).pollLast();
        if(stackSet.get(index).isEmpty()){
            stackSet.remove(index);
            size--;
        }
        return val;
    }
}

/**
 * Your StackOfPlates object will be instantiated and called as such:
 * StackOfPlates obj = new StackOfPlates(cap);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAt(index);
 */
//leetcode submit region end(Prohibit modification and deletion)

  }