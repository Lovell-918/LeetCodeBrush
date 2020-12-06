//给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。 
//
// 你应当保留两个分区中每个节点的初始相对位置。 
//
// 示例: 
//
// 输入: head = 1->4->3->2->5->2, x = 3
//输出: 1->2->2->4->3->5
// 
// Related Topics 链表 双指针

  
  package leetcode.editor.cn;
  public class PartitionList{
      public static void main(String[] args) {
           Solution solution = new PartitionList().new Solution();
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
    public ListNode partition(ListNode head, int x) {
        if(head==null) return null;
        ListNode headDummy = new ListNode(0);
        ListNode tailDummy = new ListNode(0);
        headDummy.next = head;
        head = headDummy;
        ListNode tail = tailDummy;
        while (head.next!=null){
            if(head.next.val < x){
                head = head.next;
            }else {
                ListNode temp = head.next;
                head.next = head.next.next;
                tail.next = temp;
                tail = tail.next;
            }
        }
        tail.next = null;
        head.next = tailDummy.next;
        return headDummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
  }