//给定两个用链表表示的整数，每个节点包含一个数位。 
// 这些数位是反向存放的，也就是个位排在链表首部。 
// 编写函数对这两个整数求和，并用链表形式返回结果。 
//
// 
//
// 示例： 
//
// 
//输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
//输出：2 -> 1 -> 9，即912
// 
//
// 进阶：假设这些数位是正向存放的，请再做一遍。 
//
// 示例： 
//
// 
//输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
//输出：9 -> 1 -> 2，即912
// 
// Related Topics 链表 数学 
// 👍 30 👎 0

  
  package leetcode.editor.cn;
  public class SumListsLcci{
      public static void main(String[] args) {
           Solution solution = new SumListsLcci().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(-1);
        ListNode cur=dummy;
        int c=0;
        while (l1!=null&&l2!=null){
            c+=l1.val+l2.val;
            cur.next=new ListNode(c%10);
            c/=10;
            cur=cur.next;
            l1=l1.next;
            l2=l2.next;
        }
        while (l1!=null){
            c+=l1.val;
            cur.next=new ListNode(c%10);
            c/=10;
            cur=cur.next;
            l1=l1.next;
        }
        while (l2!=null){
            c+=l2.val;
            cur.next=new ListNode(c%10);
            c/=10;
            cur=cur.next;
            l2=l2.next;
        }
        if(c!=0) cur.next=new ListNode(c);
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
  }