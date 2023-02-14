package hundred;

/**
 * @program: leetcode
 * @description: 最大回文子串
 * @author: hxl
 * @create: 2023-02-13 16:05
 **/
public class LongestPalindrome {
    public static int numWays(int n) {
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        return numWays(n-1) + numWays(n-2);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
       int n =  numWays(10);
        long end = System.currentTimeMillis();
        long time = end -start;
        System.out.println("递归所求结果：" + n);
        System.out.println(time + "毫秒");
    }
}
