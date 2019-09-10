package xin.qicloud.array;

import java.util.HashSet;

/**
 * @author qiyb
 * @version 1.0
 * @date 2019/9/10 16:06
 */
public class LongestPalindrome {

    /**
     * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
     * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
     * 注意:
     * 假设字符串的长度不会超过 1010。
     * 示例 1:
     * 输入: "abccccdd"
     * 输出: 7
     * 解释:我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
     *
     * @param s
     * @return
     */
    public static int longestPalindrome(String s) {
        if (s.length() == 0) {
            return 0;
        }
        char[] in = s.toCharArray();
        HashSet<Character> set = new HashSet<Character>();
        int res = 0;
        for (int i = 0; i < in.length; i++) {
            if (!set.contains(in[i])) {
                set.add(in[i]);
            } else {
                set.remove(in[i]);
                res++;
            }
        }
        return set.isEmpty() ? res * 2 : res * 2 + 1;
    }

    public static void main(String[] args) {
        String s = "abccccdd";
        System.out.println(longestPalindrome(s));
    }
}
