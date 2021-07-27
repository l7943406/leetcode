function ListNode(val, next) {
    this.val = (
        val === undefined ? 0 : val
    )
    this.next = (
        next === undefined ? null : next
    )
}

/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function(l1, l2) {
    if(solve(l1,l2,0)){
        return l1;
    }else {
        return l2;
    }
};
var solve = function (l1,l2,num) {
    var sum;
    if (l1 === null && l2 === null) {
        if(num === 0){
            return true;
        }
        return num;
    }

    if (l1 !== null && l2 !== null) {
        sum = l1.val + l2.val + num;
        l1.val = sum % 10;
        l2.val = l1.val;
        var res = solve(l1.next, l2.next, Math.floor(sum / 10));
        if(Number.isInteger(res)){
            l1.next = new ListNode(res,undefined);
            return true;
        }else{
            return res;
        }
    }

    if (l1 === null && l2 !== null) {
        solveOther(l2, num)
        return false;
    }

    if (l1 !== null && l2 === null) {
        solveOther(l1, num)
        return true;
    }


};
var solveOther = function (l,t) {
    var sum = l.val + t;
    l.val = sum % 10;
    t = Math.floor(sum / 10);

    while(l.next !== null){
        l = l.next
        sum = l.val + t;
        l.val = sum % 10;
        t = Math.floor(sum / 10);
    }

    if(t !== 0){
        l.next = new ListNode(t,undefined);
    }

}