/**
 * Definition for singly-linked list.**/


function ListNode(val, next) {
    this.val = (val === undefined ? 0 : val)
    this.next = (next === undefined ? null : next)
}

var l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
var l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function (l1, l2) {
    var node = new ListNode(0, null);
    var carry = 0;
    var current = node;

    while (l1 || l2) {

        var x = l1 ? l1.val : 0;
        var y = l2 ? l2.val : 0;
        var sum = x + y + carry;

        current.next = new ListNode((sum % 10), null);
        carry = sum > 9 ? 1 : 0;

        current = current.next;
        if (l1) l1 = l1.next;
        if (l2) l2 = l2.next;

        console.log(current);

    }

    if (carry > 0) {
        current.next = new ListNode(carry);
    }

    return node.next;


};

var res = addTwoNumbers(l1, l2);
