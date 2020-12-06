//请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(
//1)。 示例： MinStack minStack = new MinStack(); minStack.push(-2); minStack.push(0);
// minStack.push(-3); minStack.getMin();   --> 返回 -3. minStack.pop(); minStack.top
//();      --> 返回 0. minStack.getMin();   --> 返回 -2. Related Topics 栈 
// 👍 26 👎 0

  
  package leetcode.editor.cn;

import java.util.LinkedList;

public class MinStackLcci{
      public static void main(String[] args) {
          MinStack solution = new MinStackLcci().new MinStack();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class MinStack {
    private LinkedList<Integer> myStack;
    private LinkedList<Integer> myMin;
    /** initialize your data structure here. */
    public MinStack() {
        myStack=new LinkedList<>();
        myMin=new LinkedList<>();
    }
    
    public void push(int x) {
        myStack.offerLast(x);
        if(myMin.isEmpty()) myMin.offerLast(x);
        else myMin.offerLast(x<myMin.peekLast()?x:myMin.peekLast());
    }
    
    public void pop() {
        if(!myStack.isEmpty()){
            myStack.pollLast();
            myMin.pollLast();
        }
    }
    
    public int top() {
        if(!myStack.isEmpty()){
            return myStack.peekLast();
        }else return -1;
    }
    
    public int getMin() {
        if(!myMin.isEmpty()){
            return myMin.peekLast();
        }else return -1;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

  }