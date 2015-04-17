import java.math.BigInteger;
import java.util.Arrays;

/**
 * Created by asa on 28.02.15.
 */
public class B01 {

    public static void main(String[] args) {

        System.out.println("Result " + isValid("([{()}])"));
    }
    /* return valid string or not. String only from {} [] (). Breakets should be closed in right order*/
    public static boolean isValid(String s) {
        int n = s.length();
        if (n%2 != 0) return false;
        s.indexOf("");
        return false;
    }
    /* find ma[ robsum*/
    public static int rob(int[] num){
        int rob = 0;
        int notRob = 0;
        for (int i = 0; i < num.length; i++){
            int temp = notRob;
            notRob = Math.max(rob, notRob);
            rob = temp + num[i];
        }
        return  Math.max(rob, notRob);
    }

    public static boolean scoresIncreasing(int[] scores) {
        return true;

    }


    public String altPairs(String str) {
        String newStr = "";
        for (int i = 0; i < str.length() - 1; i++){
            if(i%4 == 0){
                newStr = newStr + str.substring(i, i + 2);
            }
        }
        if ((str.length() - 1)%4 == 0){
            newStr = newStr;
        }
        return newStr;

    }

    public static String stringX(String str) {

        if(str.length() <= 1) return str;

        String newStr = str.substring(0,1);
        for(int i = 1; i < str.length() - 1; i++){
            if(!str.substring(i,i+1).equals("x")){
                newStr = newStr + str.substring(i,i+1);
            }
        }
        newStr = newStr + str.substring(str.length() - 1);

        return newStr;
    }

    public static int stringMatch(String a, String b) {
        int count = 0;
        int length = Math.min(a.length(), b.length());
        for (int i = 0; i < length - 1; i++){
            if(a.substring(i, i + 2).equals(b.substring(i, i + 2))) count ++;
        }
        return count;
    }

    public static int last2(String str)  {
        int count = 0;
        for(int i = 0; i < str.length() - 2; i++){
            if(str.substring(i, i + 2).equals(str.substring(str.length() - 2))) {
                count = count + 1;
            }

        }
        return count;

    }
    public static int arrayCount9(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++){
            if(nums[i] == 9){
                count = count + 1;
            }
        }
        return count;
    }
    public static boolean arrayFront9(int[] nums) {
        int arrlenght = 4;
        if (nums.length < 4){
            arrlenght = nums.length;
        }

        for (int i = 0; i < arrlenght; i++){
            if(nums[i] == 9) return true;

        }
        return false;
    }
    public static boolean array123(int[] nums) {
        boolean isOne = false;
        boolean isTwo = false;
        boolean isTree = false;
        for (int num : nums) {
            if (num == 1) isOne = true;
            if (num == 2) isTwo = true;
            if (num == 3) isTree = true;
        }
        return isOne&&isTwo&&isTree;
    }


}
