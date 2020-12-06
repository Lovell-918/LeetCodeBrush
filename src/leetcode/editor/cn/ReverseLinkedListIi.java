//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。 
//
// 说明: 
//1 ≤ m ≤ n ≤ 链表长度。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL 
// Related Topics 链表

  
  package leetcode.editor.cn;
  public class ReverseLinkedListIi{
      public static void main(String[] args) {
           Solution solution = new ReverseLinkedListIi().new Solution();
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;
        int i=0;
        ListNode pre = new ListNode(-1);
        for (;i<m;++i){
            pre = head;
            head = head.next;
        }
        int j=i;
        ListNode mid = head;
        ListNode temp;
        ListNode next = new ListNode(-1);
        for (; head!=null&&j<=n; ++j){
            temp = head.next;
            head.next = next;
            next = head;
            head = temp;
        }
        pre.next = next;
        mid.next = head;
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