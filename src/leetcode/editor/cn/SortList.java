//在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。 
//
// 示例 1: 
//
// 输入: 4->2->1->3
//输出: 1->2->3->4
// 
//
// 示例 2: 
//
// 输入: -1->5->3->4->0
//输出: -1->0->3->4->5 
// Related Topics 排序 链表

  
  package leetcode.editor.cn;


public class SortList{
      public static void main(String[] args) {
           Solution solution = new SortList().new Solution();
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
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    ListNode mergeSort(ListNode head){
        if(head == null|| head.next==null) return head;
        ListNode mid = findMid(head);
        ListNode tail = mid.next;
        mid.next = null;
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(tail);
        return mergeTwo(left,right);
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

    ListNode mergeTwo(ListNode node1, ListNode node2){
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (node1!=null&&node2!=null){
            if(node1.val<node2.val){
                head.next = node1;
                node1 = node1.next;
            }else{
                head.next = node2;
                node2 = node2.next;
            }
            head = head.next;
        }
        while (node1!=null){
            head.next = node1;
            node1 = node1.next;
            head = head.next;
        }
        while (node2!=null){
            head.next = node2;
            node2 = node2.next;
            head = head.next;
        }
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