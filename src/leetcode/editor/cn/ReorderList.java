//给定一个单链表 L：L0→L1→…→Ln-1→Ln ， 
//将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→… 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 示例 1: 
//
// 给定链表 1->2->3->4, 重新排列为 1->4->2->3. 
//
// 示例 2: 
//
// 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3. 
// Related Topics 链表

  
  package leetcode.editor.cn;

import java.util.List;

public class ReorderList{
      public static void main(String[] args) {
           Solution solution = new ReorderList().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head==null) return;
        ListNode mid = findMid(head);
        ListNode tail = mid.next;
        mid.next = null;
        tail = reverse(tail);
        head = mergeTwo(head,tail);

    }

    ListNode findMid(ListNode head){
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode temp;
        while (head!=null){
            temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }

    ListNode mergeTwo(ListNode node1, ListNode node2){
        boolean flag = true;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (node1!=null&&node2!=null){
            if(flag){
                cur.next = node1;
                node1 = node1.next;
            }else{
                cur.next = node2;
                node2 = node2.next;
            }
            cur = cur.next;
            flag = !flag;
        }
        while (node1!=null){
            cur.next = node1;
            node1=node1.next;
            cur=cur.next;
        }
        while (node2!=null){
            cur.next = node2;
            node2=node2.next;
            cur=cur.next;
        }
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
  }