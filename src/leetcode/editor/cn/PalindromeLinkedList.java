//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针

  
  package leetcode.editor.cn;

import java.util.List;

public class PalindromeLinkedList{
      public static void main(String[] args) {
           Solution solution = new PalindromeLinkedList().new Solution();
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
    public boolean isPalindrome(ListNode head) {
        if(head==null) return true;
        ListNode first_end = find_first_end(head);
        ListNode second_start = reverse_list(first_end.next);
        while (second_start!=null){
            if(head.val!=second_start.val) return false;
            head = head.next;
            second_start = second_start.next;
        }
        return true;
    }

    ListNode find_first_end(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next!=null&&fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    ListNode reverse_list(ListNode node){
        ListNode pre = null;
        ListNode cur = node;
        ListNode temp = null;
        while (cur!=null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
  }