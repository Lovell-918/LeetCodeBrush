//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 4582 👎 0

  
  package leetcode.editor.cn;
  public class AddTwoNumbers{
      public static void main(String[] args) {
           Solution solution = new AddTwoNumbers().new Solution();
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
        if(l1==null&&l2==null) return null;
        if(l1==null) return l2;
        if(l2==null) return l1;
        int c=0;    //进位
        ListNode head=new ListNode(-1);
        int x,y,sum;
        ListNode node=head;
        while (l1!=null||l2!=null){
            x=l1==null?0:l1.val;
            y=l2==null?0:l2.val;
            sum = x+y+c;
            c=sum/10;
            node.next=new ListNode(sum%10);
            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
            node=node.next;
        }
        if(c>0) node.next=new ListNode(c);
        return head.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
  }