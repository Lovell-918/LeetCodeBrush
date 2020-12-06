//三合一。描述如何只用一个数组来实现三个栈。 
//
// 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。s
//tackNum表示栈下标，value表示压入的值。 
//
// 构造函数会传入一个stackSize参数，代表每个栈的大小。 
//
// 示例1: 
//
//  输入：
//["TripleInOne", "push", "push", "pop", "pop", "pop", "isEmpty"]
//[[1], [0, 1], [0, 2], [0], [0], [0], [0]]
// 输出：
//[null, null, null, 1, -1, -1, true]
//说明：当栈为空时`pop, peek`返回-1，当栈满时`push`不压入元素。
// 
//
// 示例2: 
//
//  输入：
//["TripleInOne", "push", "push", "push", "pop", "pop", "pop", "peek"]
//[[2], [0, 1], [0, 2], [0, 3], [0], [0], [0], [0]]
// 输出：
//[null, null, null, null, 2, 1, -1, -1]
// 
// Related Topics 设计 
// 👍 14 👎 0

  
  package leetcode.editor.cn;
  public class ThreeInOneLcci{
      public static void main(String[] args) {
          ThreeInOneLcci solution = new ThreeInOneLcci();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class TripleInOne {
    private int[] nums;
    private int[] stackTop;
    private int stackSize;
    public TripleInOne(int stackSize) {
        this.stackSize=stackSize;
        nums=new int[3*stackSize];
        stackTop=new int[]{0,1,2};
    }
    
    public void push(int stackNum, int value) {
        int curTop=stackTop[stackNum];
        if(curTop/3==stackSize) return;
        nums[curTop]=value;
        stackTop[stackNum]+=3;
    }
    
    public int pop(int stackNum) {
        if(isEmpty(stackNum)) return -1;
        stackTop[stackNum]-=3;
        return nums[stackTop[stackNum]];
    }
    
    public int peek(int stackNum) {
        if(isEmpty(stackNum)) return -1;
        return nums[stackTop[stackNum]-3];
    }
    
    public boolean isEmpty(int stackNum) {
        return stackTop[stackNum]<3;
    }
}

/**
 * Your TripleInOne object will be instantiated and called as such:
 * TripleInOne obj = new TripleInOne(stackSize);
 * obj.push(stackNum,value);
 * int param_2 = obj.pop(stackNum);
 * int param_3 = obj.peek(stackNum);
 * boolean param_4 = obj.isEmpty(stackNum);
 */
//leetcode submit region end(Prohibit modification and deletion)

  }