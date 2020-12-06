//合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。 
//
// 示例: 
//
// 输入:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//输出: 1->1->2->3->4->4->5->6 
// Related Topics 堆 链表 分治算法 
// 👍 811 👎 0

  
  package leetcode.editor.cn;
  public class MergeKSortedLists{
      public static void main(String[] args) {
           Solution solution = new MergeKSortedLists().new Solution();
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
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists,0,lists.length-1);
    }

    ListNode merge(ListNode[] lists, int start, int end){
        if(start>end) return null;
        if(start==end) return lists[start];
        int mid=start+(end-start)/2;
        ListNode leftHead=merge(lists,start,mid);
        ListNode rightHead=merge(lists,mid+1,end);
        if(leftHead==null) return rightHead;
        if(rightHead==null) return leftHead;
        ListNode dummy=new ListNode(-1);
        ListNode pre=dummy;
        while (leftHead!=null&&rightHead!=null){
            if(leftHead.val<=rightHead.val){
                dummy.next=leftHead;
                leftHead=leftHead.next;
            }else {
                dummy.next=rightHead;
                rightHead=rightHead.next;
            }
            dummy=dummy.next;
        }
        if(leftHead!=null) dummy.next=leftHead;
        if(rightHead!=null) dummy.next=rightHead;
        return pre.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
  }