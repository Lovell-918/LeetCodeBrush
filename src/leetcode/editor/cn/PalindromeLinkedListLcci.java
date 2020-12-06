//编写一个函数，检查输入的链表是否是回文的。 
//
// 
//
// 示例 1： 
//
// 输入： 1->2
//输出： false 
// 
//
// 示例 2： 
//
// 输入： 1->2->2->1
//输出： true 
// 
//
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 
// 👍 29 👎 0

  
  package leetcode.editor.cn;
  public class PalindromeLinkedListLcci{
      public static void main(String[] args) {
           Solution solution = new PalindromeLinkedListLcci().new Solution();
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
        ListNode midNode=findMid(head);
        ListNode node2=reverse(midNode.next);
        midNode.next=null;
        while (head!=null&&node2!=null){
            if(head.val!=node2.val) return false;
            head=head.next;
            node2=node2.next;
        }
        return true;
    }

    ListNode findMid(ListNode head){
        ListNode fast=head;
        ListNode slow=head;
        while (fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }

    ListNode reverse(ListNode head){
        ListNode pre=null;
        ListNode next;
        while (head!=null){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
  }