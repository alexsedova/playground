import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by asa on 10.04.15.
 */
public class LeetCode {
    public static void main(String[] args) {

        System.out.println('A');
    }

    public static boolean isValid(String str) {
        if (str.length() % 2 != 0) return false;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < str.length(); i++) {
            if (isOpen(str.charAt(i))) {
                stack.push(i);
            }
            if (isClose(str.charAt(i)) && !stack.empty()) {
                int temp = stack.pop();
                if (!isSame(str.charAt(temp), str.charAt(i))) return false;
            }
        }
        return stack.empty();
    }

    private static boolean isOpen(char ch) {
        return ch == '(' || ch == '{' || ch == '[';
    }

    private static boolean isClose(char ch) {
        return ch == ')' || ch == '}' || ch == ']';
    }

    private static boolean isSame(char ch1, char ch2) {
        return (ch1 == '(' && ch2 == ')') || (ch1 == '{' && ch2 == '}') || (ch1 == '[' && ch2 == ']');
    }

    /* return n-th member og sequence 1, 11, 21, ...  */
    public static String countAndSay(int n) {
        String seq = "1";
        if (n == 1) return seq;
        for (int i = 1; i < n; i++) {
            seq = createNewSeqMember(seq);
        }
        return seq;
    }

    public static String createNewSeqMember(String str) {
        StringBuilder newSeq = new StringBuilder();
        for (int i = 0, length = str.length(); i < length; i++) {
            int n = 1;
            while (i < length - 1 && str.charAt(i) == str.charAt(i + 1)) {
                n = n + 1;
                i++;
            }
            newSeq.append(n).append(str.charAt(i));
        }
        return newSeq.toString();
    }
/**********************************************************************************************************************/
/* Given an integer n, return the number of trailing zeroes in n!.

    Note: Your solution should be in logarithmic time complexity.
    All members contains "0" by trial should contain 10. 10 =5*2, but only 5 can 100% say if its "0" at the end or not
    In this case we only need find how many 5th contain n, but we must not count it twice: 5 contain 1 of 5th,
    but 10 contains two 5th, but one of them already counted in previous itteration. We need to exclude dublicates,
    for it we need change n = n/5 */

    /**
     * ******************************************************************************************************************
     */

    public static int trailingZeroes(int n) {
        if (n < 5) return 0;
        return n / 5 + trailingZeroes(n / 5);
    }

/**********************************************************************************************************************/
/* Given a column title as appear in an Excel sheet, return its corresponding column number.*/

    /**
     * ******************************************************************************************************************
     */

    public static int titleToNumber(String s) {
        int index = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            index = 26 * index + s.charAt(i) - 'A' + 1;
        }
        return index;
    }

/**********************************************************************************************************************/
/* Given a positive integer, return its corresponding column title as appear in an Excel sheet.                       */

    /**
     * ******************************************************************************************************************
     */
    public static String convertToTitle(int n) {
        String str = "";
        while (n != 0) {
            str = (char) ('A' + (n - 1) % 26) + str;
            n = (n - 1) / 26;
        }
        return str;
    }

/**********************************************************************************************************************/
/*   Given an array of size n, find the majority element. The majority element is the element that appears more than
/*   ⌊ n/2 ⌋ times.
/*   You may assume that the array is non-empty and the majority element always exist in the array.                   */
/**
/********************************************************************************************************************/

    public int majorityElement(int[] num) {
        Arrays.sort(num);
        return num[num.length/2];
    }
/**********************************************************************************************************************/
/*  Compare two version numbers version1 and version2.
/*  If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
/*
/*  You may assume that the version strings are non-empty and contain only digits and the . character.
/*  The . character does not represent a decimal point and is used to separate number sequences.
/*  For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
/*
/*  Here is an example of version numbers ordering:
/*
/*  0.1 < 1.1 < 1.2 < 13.37
/*
/**********************************************************************************************************************/

    public int compareVersion(String version1, String version2) {
        if (version1.length() == 0 || version2.length() == 0 || version1.equals(version2)) return 0;
        String [] verArr1 = version1.split("\\.");
        String [] verArr2 = version2.split("\\.");
        int [] intArr1 = new int [verArr1.length];
        int [] intArr2 = new int [verArr2.length];

        for (int i = 0; i < intArr1.length; i++){
            intArr1[i] = Integer.parseInt(verArr1[i]);
        }
        for (int j = 0; j < intArr2.length; j++){
            intArr2[j] = Integer.parseInt(verArr2[j]);
        }
        for (int k = 0; k < Math.min(intArr1.length, intArr2.length); k++) {
            if (intArr1[k] > intArr2[k]) return 1;
            else if (intArr1[k] < intArr2[k]) return -1;
        }
        if (intArr1.length > intArr2.length && intArr1[intArr1.length - 1] != 0) return 1;
        else if (intArr1.length < intArr2.length  && intArr2[intArr2.length - 1] != 0) return -1;
        return 0;
    }
/**********************************************************************************************************************/
/*  Write a program to find the node at which the intersection of two singly linked lists begins.
/*  Notes:
/*  If the two linked lists have no intersection at all, return null.
/*  The linked lists must retain their original structure after the function returns.
/*  You may assume there are no cycles anywhere in the entire linked structure.
/*  Your code should preferably run in O(n) time and use only O(1) memory.
/*
/**********************************************************************************************************************/

    public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
                 val = x;
                 next = null;
             }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode currA, currB;
        currA = headA;
        currB = headB;

        while (currA != currB) {
            currA = currA == null?headB:currA.next;
            currB = currB == null?headA:currB.next;
        }
        return currA;
    }

    /* Another realisation of intersection */
    public ListNode getIntersectionNodeTwo( ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode currA, currB;
        currA = headA;
        currB = headB;
        int lenghtA = 0;
        int lenghtB = 0;
        int middle = 0;
        while (currA != null){
            lenghtA ++;
            currA = currA.next;
        }
        while (currB != null){
            lenghtB ++;
            currB = currB.next;
        }
        currA = headA;
        currB = headB;
        middle = lenghtA - lenghtB;
        if (lenghtA < lenghtB) {
            middle = lenghtB - lenghtA;
            currA = headB;
            currB = headA;
        }
        for (int i = 0; i < middle; i++) {
            currA = currA.next;
        }
        while (currA != null && currB != null) {
            if (currA.val == currB.val) {
                return currA;
            }
            currA = currA.next;
            currB = currB.next;
        }
        return null;
    }
/*
/  Create void function for git commit to plgrsp1 only
*/

    public static void blabla(){

    }

}
