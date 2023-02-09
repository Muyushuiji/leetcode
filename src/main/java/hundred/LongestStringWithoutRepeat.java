package hundred;

import java.util.HashMap;

/**
 * @program: leetcode
 * @description: 最大无重复字符串
 * @author: hxl
 * @create: 2023-02-09 11:18
 **/
public class LongestStringWithoutRepeat {
    public  static  int lengthOfLongestSubstring(String s) {
        //思路 通过滑动窗口map记录，移动end 遇到重复值取重复值后一位标志对比
        //map key存储不重复字符，value存储字符后一位 方便遇到重复字符比较位置更新
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int length = 0;
        for (int end = 0, start = 0; end < s.length(); end++) {
            char now = s.charAt(end);
            if (map.containsKey(now)) {
                //取now后一位 和当前start索引 最大值
                start = Math.max(map.get(now), start);
            }
            //不存在则map存储当前值，并更新end值
            length = Math.max(length, end - start + 1);
            map.put(now, end + 1);
        }
        return length;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        String b = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
        System.out.println(lengthOfLongestSubstring(b));
    }
}
