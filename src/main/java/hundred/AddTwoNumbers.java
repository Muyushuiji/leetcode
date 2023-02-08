package hundred;

/**
 * @program: leetcode
 * @description:
 * @author: hxl
 * @create: 2023-02-08 09:28
 **/
public class AddTwoNumbers {
    /**
     * 给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * 你可以假设除了数字0之外，这两个数都不会以0开头。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/add-two-numbers
     */

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //思路
        // 遍历两个链表，逆序相加考虑进位值。prev指针代表头结点，不存储数据，cur节点存储相加结果
        ListNode prev = new ListNode(0);
        ListNode cur = prev;
        //设置进位符
        int carry = 0;

        while (l1 != null || l2 != null) {
            //取 l1 和 l2 的值，不为null取
            int var1 = l1 == null ? 0 : l1.val;
            int var2 = l2 == null ? 0 : l2.val;

            int sum = var1 + var2 + carry;
            //取余得sum，将sum存储新结点数取模得carry
            carry = sum / 10;
            sum = sum % 10;
            //cur与prev指向同一个实例化内存空间，移动cur.next
            cur.next = new ListNode(sum);
            cur = cur.next;

            //遍历下一个
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        //返回链表头结点
        return prev.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode result = addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;

        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
